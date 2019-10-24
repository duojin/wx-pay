package com.wxpay.api;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStreamException;
import com.wxpay.api.domain.WxpayTradeAppPayModel;
import com.wxpay.api.internal.mapping.MapUtils;
import com.wxpay.api.internal.parser.xml.ObjectXmlParser;
import com.wxpay.api.internal.util.*;

import java.io.FileWriter;
import java.io.IOException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class DefaultWxpayClient implements WxpayClient {

    private String appId;
    private String mch_id;
    private String privateKey;
    private String certPath;
    private String sign_type = WxpayConstants.SIGN_TYPE_MD5;

    private int connectTimeout = 3000;
    private int readTimeout = 15000;
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
    }

    public DefaultWxpayClient(String appId, String mch_id, String privateKey, String certPath) {
        this.appId = appId;
        this.mch_id = mch_id;
        this.privateKey = privateKey;
        this.certPath = certPath;
        this.clientParams.put("appid", appId);
        this.clientParams.put("mch_id", mch_id);
    }

    @Override
    public <T extends WxpayResponse> T execute(WxpayRequest<T> request) throws WxpayApiException {
        WxpayParser<T> parser = new ObjectXmlParser<T>(request.getResponseClass());
        return _execute(request, parser);
    }

    @Override
    public <T extends WxpayResponse> T download(WxpayRequest<T> request, String filePath) throws WxpayApiException {
        RequestParametersHolder requestHolder = getRequestHolderWithSign(request);
        String url = request.getApiUrl();
        String postBody = buildXmlBody(requestHolder.getSortedParams());

        String responseStr = null;
        try {
            if (request.isNeedCert()) {
                responseStr = WebUtils.doHttpsPost2Wx(url, postBody, WxpayConstants.CHARSET, connectTimeout, readTimeout, certPath, mch_id);
            } else {
                responseStr = WebUtils.doHttpPost2Wx(url, postBody, WxpayConstants.CHARSET, connectTimeout, readTimeout);
            }
        } catch (Exception e) {
            throw new WxpayApiException(e);
        }
        if (responseStr == null || responseStr.isEmpty()) {
            return null;
        }

        T tRsp = null;

        WxpayParser<T> parser = new ObjectXmlParser<T>(request.getResponseClass());
        try {
            tRsp = parser.parse(responseStr);
            if (tRsp == null) {
                throw new WxpayApiException("解析响应失败(tRsp==null),responseStr=" + responseStr);
            }
        } catch (XStreamException e) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(filePath);
                fw.write(responseStr);
                fw.close();
                tRsp = parser.parse("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><filePath><![CDATA[" + filePath + "]]></filePath></xml>");
            } catch (Exception ee) {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                throw new WxpayApiException("文件写入失败,filePath=" + filePath, ee);
            }
        } catch (Exception e) {
            throw new WxpayApiException("解析响应失败,responseStr=" + responseStr, e);
        }
        return tRsp;
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
        String sign_type = request.getSign_type();
        if (StringUtils.isEmpty(sign_type)) {
            sign_type = this.sign_type;
        }
        String signContent = WxpaySignature.getSignContent(requestHolder.getSortedParams());
        String sign = WxpaySignature.sign(signContent, this.privateKey, sign_type);
        WxpayLogger.logBizDebug("待签名字符串:" + signContent);
        WxpayLogger.logBizDebug("签名:" + sign);

        appParams.put("sign", sign);

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
            if (tRsp == null) {
                throw new WxpayApiException("解析响应失败(tRsp==null),responseStr=" + responseStr);
            }
        } catch (Exception e) {
            throw new WxpayApiException("解析响应失败,responseStr=" + responseStr, e);
        }

        if (tRsp.isNeedVerifySign()) {
            Map<String, String> params = MapUtils.getParamterMap(tRsp);
            if (WxpayConstants.SUCCESS.equals(params.get("return_code"))) {
                String sign_type = request.getSign_type();
                if (StringUtils.isEmpty(sign_type)) {
                    sign_type = this.sign_type;
                }
                if (!WxpaySignature.signCheck(params, this.privateKey, sign_type)) {
                    throw new WxpayApiException("验证签名没有通过,待验证签名map=" + new Gson().toJson(params));
                }
            }
        }

        return tRsp;
    }

    /**
     * @param request
     * @return
     * @throws WxpayApiException
     */
    private <T extends WxpayResponse> String doPost(WxpayRequest<T> request) throws WxpayApiException {
        RequestParametersHolder requestHolder = getRequestHolderWithSign(request);

        String url = request.getApiUrl();

        String rsp = null;
        String postBody = buildXmlBody(requestHolder.getSortedParams());
        try {
            if (request.isNeedCert()) {
                String certPath = this.certPath;
                String certPwd = this.mch_id;
                rsp = WebUtils.doHttpsPost2Wx(url, postBody, WxpayConstants.CHARSET, connectTimeout, readTimeout, certPath, certPwd);
            } else {
                rsp = WebUtils.doHttpPost2Wx(url, postBody, WxpayConstants.CHARSET, connectTimeout, readTimeout);
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

    @Override
    public String sdkExecute(WxpayTradeAppPayModel request) throws WxpayApiException {
        request.setAppid(this.appId);
        request.setPartnerid(this.mch_id);
        request.setNoncestr(RandomUtil.getRandomString());
        request.setTimestamp(String.valueOf(System.currentTimeMillis() / 1000L));
        String signContent = WxpaySignature.getSignContent(MapUtils.getParamterMap(request));
        request.setSign(WxpaySignature.sign(signContent, this.privateKey, this.sign_type));
        return new Gson().toJson(request);
    }

}
