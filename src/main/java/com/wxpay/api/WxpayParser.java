package com.wxpay.api;

/**
 * 响应解释器接口。
 * 
 * @author Administrator
 *
 * @param <T>
 */
public interface WxpayParser<T extends WxpayResponse> {

    /**
     * 把响应字符串解释成相应的领域对象。
     * 
     * @param rsp 响应字符串
     * @return 领域对象
     */
    public T parse(String rsp) throws WxpayApiException;

}
