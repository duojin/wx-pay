package com.wxpay.api;

import java.util.Map;

import com.wxpay.api.request.*;
import com.wxpay.api.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.wxpay.api.conf.WxpayConfigure;
import com.wxpay.api.domain.WxpayTradeAppPayModel;
import com.wxpay.api.internal.util.WxpaySignature;


public class WxPay {
    
	private static Log logger = LogFactory.getLog(WxPay.class);
	
	private static WxpayClient wxpayClient = new DefaultWxpayClient(
    			WxpayConfigure.getAPP_ID(),
    			WxpayConfigure.getMCH_ID(),
    			WxpayConfigure.getMCH_KEY(),
    			WxpayConfigure.getCERT_PATH()
    		);
    
    public static void initWxPayCustomClient(String appId, String mchId, String key){
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
     * 退款接口
     * make by liuxj 2018年5月14日下午2:45:13
     * @param bizContent
     * @return
     * @throws WxpayApiException
     */
    public static WxpayTradeRefundResponse refund(Map<String, Object> bizContent) throws WxpayApiException{
    	
    	logger.debug("##in## bizContent:="+new Gson().toJson(bizContent));
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
    public static boolean verifySign(Map<String, String> paramsMap) throws WxpayApiException {

        return WxpaySignature.signCheck(paramsMap, WxpayConfigure.getMCH_KEY(), WxpayConstants.SIGN_TYPE);
    }
	public static Map<String,String> decodeReqInfo(String req_info) throws WxpayApiException {

		return WxpaySignature.decodeReqInfo(req_info, WxpayConfigure.getMCH_KEY());
	}
    /**
     * 单个订单查询接口
     * @param bizContent
     * @return
     * @throws WxpayApiException
     */
    public static WxpayTradeQueryResponse queryTrade(Map<String, Object> bizContent) throws WxpayApiException {
    	
    	logger.debug("##in## paramsMap:="+new Gson().toJson(bizContent));
    	
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

	public static void downloadBill(Map<String, Object> bizContent,String filePath) throws WxpayApiException {

		bizContent.put("bill_type", "ALL");
		logger.debug("##in## paramsMap:="+new Gson().toJson(bizContent));

		WxpayDataDataserviceBillDownloadRequest request = new WxpayDataDataserviceBillDownloadRequest();
		request.setBizContent(bizContent);
		WxpayDataDataserviceBillDownloadResponse response = wxpayClient.download(request,filePath);
		if(response.isSuccess()){
			logger.info("##out## response:="+new Gson().toJson(response));
		} else {
			logger.error("##out## response:="+new Gson().toJson(response));
			throw new WxpayApiException(response.getErr_code());
		}
	}

	public static void downloadFundflow(Map<String, Object> bizContent,String filePath) throws WxpayApiException {

		bizContent.put("account_type", "Basic");
		logger.debug("##in## paramsMap:="+new Gson().toJson(bizContent));

		WxpayDataDataserviceFundDownloadRequest request = new WxpayDataDataserviceFundDownloadRequest();
		request.setBizContent(bizContent);
		WxpayDataDataserviceFundDownloadResponse response = wxpayClient.download(request,filePath);
		if(response.isSuccess()){
			logger.info("##out## response:="+new Gson().toJson(response));
		} else {
			logger.error("##out## response:="+new Gson().toJson(response));
			throw new WxpayApiException(response.getErr_code());
		}
	}

	public static void downloadComment(Map<String, Object> bizContent,String filePath) throws WxpayApiException {

		logger.debug("##in## paramsMap:="+new Gson().toJson(bizContent));

		WxpayDataDataserviceCommentDownloadRequest request = new WxpayDataDataserviceCommentDownloadRequest();
		request.setBizContent(bizContent);
		WxpayDataDataserviceCommentDownloadResponse response = wxpayClient.download(request,filePath);
		if(response.isSuccess()){
			logger.info("##out## response:="+new Gson().toJson(response));
		} else {
			logger.error("##out## response:="+new Gson().toJson(response));
			throw new WxpayApiException(response.getErr_code());
		}
	}

	public static WxpayTradeCloseResponse closeTrade(Map<String, Object> bizContent) throws WxpayApiException {

		logger.debug("##in## paramsMap:="+new Gson().toJson(bizContent));

		WxpayTradeCloseRequest request = new WxpayTradeCloseRequest();
		request.setBizContent(bizContent);
		WxpayTradeCloseResponse response = wxpayClient.execute(request);
		if(response.isSuccess()){
			logger.info("##out## response:="+new Gson().toJson(response));
		} else {
			logger.error("##out## response:="+new Gson().toJson(response));
			throw new WxpayApiException(response.getErr_code());
		}
		return response;
	}

	public static WxpayTradeRefundQueryResponse queryRefundTrade(Map<String, Object> bizContent) throws WxpayApiException {

		logger.debug("##in## paramsMap:="+new Gson().toJson(bizContent));

		WxpayTradeRefundQueryRequest request = new WxpayTradeRefundQueryRequest();
		request.setBizContent(bizContent);
		WxpayTradeRefundQueryResponse response = wxpayClient.execute(request);
		if(response.isSuccess()){
			logger.info("##out## response:="+new Gson().toJson(response));
		} else {
			logger.error("##out## response:="+new Gson().toJson(response));
			throw new WxpayApiException(response.getErr_code());
		}
		return response;
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
