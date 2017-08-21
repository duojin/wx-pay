package com.wxpay.api.internal.parser.xml;

import com.wxpay.api.WxpayApiException;
import com.wxpay.api.WxpayParser;
import com.wxpay.api.WxpayResponse;
import com.wxpay.api.internal.mapping.Converter;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class ObjectXmlParser<T extends WxpayResponse> implements WxpayParser<T> {

    private Class<T> clazz;

    public ObjectXmlParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T parse(String rsp) throws WxpayApiException {
        Converter converter = new XmlConverter();
        return converter.toResponse(rsp, clazz);
    }

    public Class<T> getResponseClass() {
        return clazz;
    }

}
