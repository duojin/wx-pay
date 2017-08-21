package com.wxpay.api.internal.mapping;

import com.wxpay.api.WxpayResponse;

/**
 * 动态格式转换器。
 * @author Administrator
 *
 */
public interface Converter {

    /**
     * 把字符串转换为响应对象。
     * 
     * @param <T> 领域泛型
     * @param rsp 响应字符串
     * @param clazz 领域类型
     * @return 响应对象
     * @throws TopException
     */
    public <T extends WxpayResponse> T toResponse(String rsp, Class<T> clazz);
    
}
