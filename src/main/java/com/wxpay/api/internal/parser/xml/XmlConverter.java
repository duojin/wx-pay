package com.wxpay.api.internal.parser.xml;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.wxpay.api.WxpayConstants;
import com.wxpay.api.WxpayResponse;
import com.wxpay.api.internal.mapping.Converter;
import com.wxpay.api.response.WxpayFundTransToaccountTransferResponse;


/**
 * Xml格式转换器。
 * @author Administrator
 *
 */
public class XmlConverter implements Converter {

	@SuppressWarnings("unchecked")
	public <T extends WxpayResponse> T toResponse(String rsp, Class<T> clazz) {

		XStream xStream = new XStream();
		xStream.alias(WxpayConstants.RESPONSE_XML_NODE_NAME, clazz);
		xStream.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return (T) xStream.fromXML(rsp);
	}
	
	public static void main(String[] args){
		String inStr = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[支付失败]]></return_msg><mch_appid><![CDATA[wx628bb5f71f06cc1b]]></mch_appid><mchid><![CDATA[1399307302]]></mchid><result_code><![CDATA[FAIL]]></result_code><err_code><![CDATA[NOTENOUGH]]></err_code><err_code_des><![CDATA[余额不足]]></err_code_des></xml>";
		
		
		XmlConverter a = new XmlConverter();
		WxpayResponse r = a.toResponse(inStr, WxpayFundTransToaccountTransferResponse.class);
		
		System.out.println(new Gson().toJson(r));
		System.out.println(r.isNeedVerifySign());
	}
}
