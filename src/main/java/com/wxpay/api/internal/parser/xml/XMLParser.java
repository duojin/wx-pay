package com.wxpay.api.internal.parser.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.wxpay.api.WxpayApiException;

public class XMLParser {
	public static Map<String, String> getMapFromXML(String xmlString) throws WxpayApiException {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(xmlString)));

			NodeList allNodes = document.getFirstChild().getChildNodes();
			for (int i = 0,l = allNodes.getLength(); i < l; i++) {
				Node node = allNodes.item(i);
				if ((node instanceof Element)) {
					map.put(node.getNodeName(), node.getTextContent());
				}
			}
		} catch (SAXException e) {
			e.printStackTrace();
			throw new WxpayApiException("SAXException:" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new WxpayApiException("IOException:" + e.getMessage());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new WxpayApiException("ParserConfigurationException:" + e.getMessage());
		}
		return map;
	}

	public static void main(String[] args) throws WxpayApiException {
		String xmlString = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg>OK</return_msg><appid><![CDATA[wx973427b99180717b]]></appid><mch_id><![CDATA[1324635801]]></mch_id><device_info><![CDATA[WEB]]></device_info><nonce_str><![CDATA[ABy6vN35zzRPvHfh]]></nonce_str><sign><![CDATA[2863D41EA9E876697C0598A50FEAB0AE]]></sign><result_code><![CDATA[SUCCESS]]></result_code><prepay_id><![CDATA[wx201610171127233cf9ea7af10102739752]]></prepay_id><trade_type><![CDATA[APP]]></trade_type></xml>";

		Map<String, String> aa = getMapFromXML(xmlString);
		System.out.println("aa" + aa);
	}
}
