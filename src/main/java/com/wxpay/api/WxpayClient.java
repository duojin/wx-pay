package com.wxpay.api;

import com.wxpay.api.domain.WxpayTradeAppPayModel;

/**
 * 
 * @author Administrator
 *
 */
public interface WxpayClient {

    /**
     * 
     * 
     * @param <T>
     * @param request
     * @return
     * @throws WxpayApiException
     */
    public <T extends WxpayResponse> T execute(WxpayRequest<T> request) throws WxpayApiException;

	public String sdkExecute(WxpayTradeAppPayModel appPay) throws WxpayApiException;

    public <T extends WxpayResponse> T download(WxpayRequest<T> request,String filePath)  throws WxpayApiException;

}
