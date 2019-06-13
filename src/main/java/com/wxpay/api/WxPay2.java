package com.wxpay.api;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.wxpay.api.conf.WxpayConfigure;
import com.wxpay.api.domain.WxpayTradeAppPayModel;
import com.wxpay.api.internal.util.WxpaySignature;
import com.wxpay.api.request.WxpayFundTransToaccountTransferRequest;
import com.wxpay.api.request.WxpayTradeQueryRequest;
import com.wxpay.api.request.WxpayTradeRefundRequest;
import com.wxpay.api.request.WxpayUnifiedorderRequest;
import com.wxpay.api.response.WxpayFundTransToaccountTransferResponse;
import com.wxpay.api.response.WxpayTradeQueryResponse;
import com.wxpay.api.response.WxpayTradeRefundResponse;
import com.wxpay.api.response.WxpayUnifiedorderResponse;



public class WxPay2 {
    
	private static Log logger = LogFactory.getLog(WxPay2.class);
	
	private static WxpayClient defaultWxpayClient = new DefaultWxpayClient(
    			WxpayConfigure.getAPP_ID(),
    			WxpayConfigure.getMCH_ID(),
    			WxpayConfigure.getMCH_KEY(),
    			WxpayConfigure.getCERT_PATH()
    		);
    
    public static void initWxPayCustomClient(String appId, String mchId, String key){
    	defaultWxpayClient = new DefaultWxpayClient(appId, mchId, key);
    }
    
    /**
     * 通过业务参数组装支付请求参数包括签名信息
     * @param bizContent 业务参数
     * @return
     * @throws WxpayApiException 
     */
    public static String buildAppPayInfo(Map<String, Object> bizContent, WxPaySettings settings) throws WxpayApiException {

    	logger.debug("##in## bizContent:="+new Gson().toJson(bizContent));
    	WxpayClient wxpayClient = getWxpayClient(settings);
    	WxpayUnifiedorderRequest request = new WxpayUnifiedorderRequest();
        request.setTrade_type("APP");
        request.setBizContent(bizContent);
        WxpayUnifiedorderResponse response = wxpayClient.execute(request);
        
        if(response.isSuccess()){
    		logger.info("##out## response:="+new Gson().toJson(response));
    		 WxpayTradeAppPayModel appPay = new WxpayTradeAppPayModel();
    	     appPay.setPrepayid(response.getPrepay_id());
    	     return wxpayClient.sdkExecute(appPay);
    	} else {
    		logger.error("##out## response:="+new Gson().toJson(response));
    		throw new WxpayApiException(response.getErr_code_des());
    	}
    }
    
	/**
     * 转账接口
     * @param bizContent
     * @return
     * @throws WxpayApiException
     */
    public static WxpayFundTransToaccountTransferResponse toaccountTransfer(Map<String, Object> bizContent, WxPaySettings settings) throws WxpayApiException{
    	
    	logger.debug("##in## bizContent:="+new Gson().toJson(bizContent));
    	WxpayClient wxpayClient = getWxpayClient(settings);
    	WxpayFundTransToaccountTransferRequest request = new WxpayFundTransToaccountTransferRequest();
    	request.setBizContent(bizContent);
    	WxpayFundTransToaccountTransferResponse response = wxpayClient.execute(request);
    	if(response.isSuccess()){
    		logger.info("##out## response:="+new Gson().toJson(response));
    		return response;
    	} else {
    		logger.error("##out## response:="+new Gson().toJson(response));
    		throw new WxpayApiException(response.getErr_code_des());
    	}
    }

    /**
     * 退款接口
     * make by liuxj 2018年5月14日下午2:44:24
     * @param bizContent
     * @param settings
     * @return
     * @throws WxpayApiException
     */
    public static WxpayTradeRefundResponse refund(Map<String, Object> bizContent, WxPaySettings settings) throws WxpayApiException{
    	
    	logger.debug("##in## bizContent:="+new Gson().toJson(bizContent));
    	WxpayClient wxpayClient = getWxpayClient(settings);
    	WxpayTradeRefundRequest request = new WxpayTradeRefundRequest();
    	request.setBizContent(bizContent);
    	WxpayTradeRefundResponse response = wxpayClient.execute(request);
    	if(response.isSuccess()){
    		logger.info("##out## response:="+new Gson().toJson(response));
    		return response;
    	} else {
    		logger.error("##out## response:="+new Gson().toJson(response));
    		throw new WxpayApiException(response.getErr_code_des());
    	}
    }
    
    /**
     * 验证签名
     * @param paramsMap 回传参数带签名
     * @return
     * @throws WxpayApiException 
     */
    public static boolean verifySign(Map<String, String> paramsMap, WxPaySettings settings) throws WxpayApiException {

    	if(settings==null){
    		return WxpaySignature.signCheck(paramsMap, WxpayConfigure.getMCH_KEY(), WxpayConstants.SIGN_TYPE);
    	}else{
    		return WxpaySignature.signCheck(paramsMap, settings.getMchKey(), WxpayConstants.SIGN_TYPE);
    	}
    }
    /**
     * 单个订单查询接口
     * @param bizContent
     * @return
     * @throws WxpayApiException
     */
    public static WxpayTradeQueryResponse queryTrade(Map<String, Object> bizContent, WxPaySettings settings) throws WxpayApiException {
    	
    	logger.debug("##in## paramsMap:="+new Gson().toJson(bizContent));
    	WxpayClient wxpayClient = getWxpayClient(settings);
    	
    	WxpayTradeQueryRequest request = new WxpayTradeQueryRequest();
    	request.setBizContent(bizContent);
    	WxpayTradeQueryResponse response = wxpayClient.execute(request);
    	if(response.isSuccess()){
    		logger.info("##out## response:="+new Gson().toJson(response));
    		return response;
    	} else {
    		logger.error("##out## response:="+new Gson().toJson(response));
    		throw new WxpayApiException(response.getErr_code_des());
    	}
    }
    public static String notifyResponse(Response res){
    	return res.getResponse();
    }
    
    public static enum Response {
    	SUCCESS("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>"),  FAILURE("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[NG]]></return_msg></xml>");
        
		private String response;
    	private Response(String response) {
			this.response = response;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
    	
    }

    private static WxpayClient getWxpayClient(WxPaySettings settings) {
    	WxpayClient wxpayClient = defaultWxpayClient;
    	if(settings==null){
        	logger.info("使用默认配置===========");
    	}else{
    		wxpayClient = new  DefaultWxpayClient(
    				settings.getAppId(),
    				settings.getMch_id(),
    				settings.getMchKey(),
    				settings.getCertPath()
    				);
    	}
    	return wxpayClient;
	}

}
