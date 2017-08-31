package com.wxpay.api;

import java.security.Security;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.wxpay.api.conf.WxpayConfigure;
import com.wxpay.api.domain.WxpayTradeAppPayModel;
import com.wxpay.api.internal.mapping.MapUtils;
import com.wxpay.api.internal.parser.xml.ObjectXmlParser;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.internal.util.RequestParametersHolder;
import com.wxpay.api.internal.util.StringUtils;
import com.wxpay.api.internal.util.WebUtils;
import com.wxpay.api.internal.util.WxpayHashMap;
import com.wxpay.api.internal.util.WxpayLogger;
import com.wxpay.api.internal.util.WxpaySignature;

/**
 * 
 * @author Administrator
 *
 */
public class DefaultWxpayClient implements WxpayClient {

    private String appId;
    private String mch_id;
    private String privateKey;
    private String sign_type      = WxpayConstants.SIGN_TYPE_MD5;

    private int    connectTimeout = 3000;
    private int    readTimeout    = 15000;
    private Map<String, String> clientParams = new HashMap<String, String>();

    static {
        //清除安全设置
        Security.setProperty("jdk.certpath.disabledAlgorithms", "");
    }

    public DefaultWxpayClient(String appId, String mch_id, String privateKey) {
        this.appId = appId;
        this.mch_id = mch_id;
        this.privateKey = privateKey;
        this.clientParams.put("appid", appId);
        this.clientParams.put("mch_id", mch_id);
        this.clientParams.put("sign_type", this.sign_type);
    }
    
    public <T extends WxpayResponse> T execute(WxpayRequest<T> request) throws WxpayApiException {
    	WxpayParser<T> parser = new ObjectXmlParser<T>(request.getResponseClass());
        return _execute(request,parser);
    }

    /**
     * 组装接口参数，处理加密、签名逻辑
     * 
     * @param request
     * @return
     * @throws WxpayApiException
     */
	private <T extends WxpayResponse> RequestParametersHolder getRequestHolderWithSign(WxpayRequest<?> request)
			throws WxpayApiException {
		RequestParametersHolder requestHolder = new RequestParametersHolder();
		request.setClientParams(this.clientParams);
		WxpayHashMap appParams = new WxpayHashMap(MapUtils.getParamterMap(request));
		requestHolder.setParams(appParams);
		if (!StringUtils.isEmpty(this.sign_type)) {
			String signContent = WxpaySignature.getSignContent(requestHolder.getSortedParams());
			String sign = WxpaySignature.sign(signContent, this.privateKey, this.sign_type);
			WxpayLogger.logBizDebug("待签名字符串:" + signContent);

			WxpayLogger.logBizDebug("签名:" + sign);
			appParams.put("sign", sign);
		} else {
			appParams.put("sign", "");
		}
		return requestHolder;
	}

    private <T extends WxpayResponse> T _execute(WxpayRequest<T> request, WxpayParser<T> parser) throws WxpayApiException {

        String responseStr = doPost(request);
        if (responseStr == null) {
            return null;
        }

        T tRsp = null;

        try {

        	tRsp = parser.parse(responseStr);
        	if(tRsp==null){
        		throw new WxpayApiException("解析响应失败(tRsp==null),responseStr="+responseStr);
        	}
        } catch (Exception e) {
        	throw new WxpayApiException("解析响应失败,responseStr="+responseStr,e);
        } 

    	if(tRsp.isNeedVerifySign()){
    		Map<String,String> params = MapUtils.getParamterMap(tRsp);
    		if(!WxpaySignature.signCheck(params, this.privateKey, this.sign_type)){
    			throw new WxpayApiException("验证签名没有通过,待验证签名map="+new Gson().toJson(params));
    		}
    	}

        return tRsp;
    }

    /**
     * 
     * @param request
     * @param parser
     * @return
     * @throws WxpayApiException
     */
    private <T extends WxpayResponse> String doPost(WxpayRequest<T> request) throws WxpayApiException {
        RequestParametersHolder requestHolder = getRequestHolderWithSign(request);

        String url = request.getApiUrl();

        String rsp = null;
        String postBody = buildXmlBody(requestHolder.getSortedParams());
        try {
        	if(request.isNeedCert()){
                String certPath = WxpayConfigure.getCERT_PATH();
                String certPwd = WxpayConfigure.getMCH_ID();
                rsp = WebUtils.doHttpsPost2Wx(url, postBody, WxpayConstants.CHARSET,connectTimeout, readTimeout,certPath,certPwd);
        	}else{
                rsp = WebUtils.doHttpPost2Wx(url, postBody, WxpayConstants.CHARSET,connectTimeout, readTimeout);
        	}
        } catch (Exception e) {
            throw new WxpayApiException(e);
        }
        return rsp;
    }
    
	private static String buildXmlBody(Map<String, String> params) {
		StringBuffer reslutXml = new StringBuffer("<xml>");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			reslutXml.append("<" + (String) entry.getKey() + ">");
			reslutXml.append("<![CDATA[");

			reslutXml.append((String) entry.getValue());

			reslutXml.append("]]>");
			reslutXml.append("</" + (String) entry.getKey() + ">");
		}
		reslutXml.append("</xml>");
		return reslutXml.toString();
	}

	public String sdkExecute(WxpayTradeAppPayModel request) throws WxpayApiException {
		request.setAppid(this.appId);
	    request.setPartnerid(this.mch_id);
	    request.setNoncestr(RandomUtil.getRandomString());
	    request.setTimestamp(String.valueOf(new Date().getTime() / 1000L));
	    String signContent = WxpaySignature.getSignContent(MapUtils.getParamterMap(request));
	    request.setSign(WxpaySignature.sign(signContent, this.privateKey, this.sign_type));
	    return new Gson().toJson(request);
	}

}
