package com.wxpay.api;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.wxpay.api.conf.WxpayConfigure;
import com.wxpay.api.domain.WxpayTradeAppPayModel;
import com.wxpay.api.internal.util.WxpaySignature;
import com.wxpay.api.request.WxpayFundTransToaccountTransferRequest;
import com.wxpay.api.request.WxpayUnifiedorderRequest;
import com.wxpay.api.response.WxpayFundTransToaccountTransferResponse;
import com.wxpay.api.response.WxpayUnifiedorderResponse;



public class WxPay {
    
	private static Log logger = LogFactory.getLog(WxPay.class);
	
	private static WxpayClient wxpayClient = new DefaultWxpayClient(
    			WxpayConfigure.getAPP_ID(),
    			WxpayConfigure.getMCH_ID(),
    			WxpayConfigure.getMCH_KEY()
    		);
    
    public static void initAliPayCustomClient(String appId, String mchId, String key){
    	wxpayClient = new DefaultWxpayClient(appId, mchId, key);
    }
    
    /**
     * 通过业务参数组装支付请求参数包括签名信息
     * @param bizContent 业务参数
     * @return
     * @throws WxpayApiException 
     */
    public static String buildAppPayInfo(Map<String, Object> bizContent) throws WxpayApiException {

    	logger.debug("##in## bizContent:="+new Gson().toJson(bizContent));
    	
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
    public static WxpayFundTransToaccountTransferResponse toaccountTransfer(Map<String, Object> bizContent) throws WxpayApiException{
    	
    	logger.debug("##in## bizContent:="+new Gson().toJson(bizContent));
    	
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
     * 验证签名
     * @param paramsMap 回传参数带签名
     * @return
     * @throws WxpayApiException 
     */
    public static boolean verifySign(Map<String, String> paramsMap) throws WxpayApiException {

        return WxpaySignature.signCheck(paramsMap, WxpayConfigure.getMCH_KEY(), WxpayConstants.SIGN_TYPE);
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
    
}
