package com.wxpay.api.internal.parser.xml;

import com.wxpay.api.WxpayResponse;
import com.wxpay.api.internal.mapping.Converter;


/**
 * Xml格式转换器。
 * @author Administrator
 *
 */
public class XmlConverter implements Converter {

	public <T extends WxpayResponse> T toResponse(String rsp, Class<T> clazz) {
		return null;
	}
}
