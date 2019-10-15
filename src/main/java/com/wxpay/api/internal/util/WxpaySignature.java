package com.wxpay.api.internal.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.wxpay.api.WxpayApiException;
import com.wxpay.api.WxpayConstants;
import com.wxpay.api.internal.parser.xml.XMLParser;
import com.wxpay.api.internal.util.codec.Hex;

/**
 * 
 * @author Administrator
 *
 */
public class WxpaySignature {

    /**
     * 获取map的待签名字符串
     * @param params
     * @return
     */
    public static String getSignContent(Map<String, String> params) {
        if (params == null) {
            return null;
        }

        params.remove("sign");

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (StringUtils.areNotEmpty(key, value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    public static String sign(Map<String, String> params, String privateKey, String signType) throws WxpayApiException {
    	String content = getSignContent(params);
    	return sign(content, privateKey, signType);
    }
    
    /**
     * 内容签名
     * @param content
     * @param privateKey
     * @param signType
     * @return
     * @throws WxpayApiException
     */
    public static String sign(String content, String privateKey, String signType) throws WxpayApiException {

    	content = content + "&key=" + privateKey;

        try {
	        if (WxpayConstants.SIGN_TYPE_MD5.equals(signType)) {
                MessageDigest md = MessageDigest.getInstance(WxpayConstants.SIGN_TYPE_MD5);
                
                return Hex.byteArrayToHexString(md.digest(content.getBytes(WxpayConstants.CHARSET))).toUpperCase();
	        } else if (WxpayConstants.SIGN_TYPE_HMAC_SHA256.equals(signType)) {
				Mac mac = Mac.getInstance("HmacSHA256");
	            SecretKeySpec secret = new SecretKeySpec(privateKey.getBytes(WxpayConstants.CHARSET), mac.getAlgorithm());
	            mac.init(secret);
	            
	            return Hex.byteArrayToHexString(mac.doFinal(content.getBytes(WxpayConstants.CHARSET))).toUpperCase();
	        } else {
	            throw new WxpayApiException("Sign Type is Not Support : signType=" + signType);
	        }
        } catch (Exception e) {
            throw new WxpayApiException(signType+" content = " + content, e);
        }

    }

    public static boolean signCheck(Map<String, String> params, String privateKey, String signType) throws WxpayApiException {

        String sign = params.get("sign");
        String content = getSignContent(params);
    	content = content + "&key=" + privateKey;
        try {
	        if (WxpayConstants.SIGN_TYPE_MD5.equals(signType)) {
	
	        	MessageDigest md = MessageDigest.getInstance(signType);
	            
	            String checkSign = Hex.byteArrayToHexString(md.digest(content.getBytes(WxpayConstants.CHARSET))).toUpperCase();
	
	            return sign!=null && sign.equals(checkSign);
	
	        } else if (WxpayConstants.SIGN_TYPE_HMAC_SHA256.equals(signType)) {
	        	Mac mac = Mac.getInstance("HmacSHA256");
	            SecretKeySpec secret = new SecretKeySpec(privateKey.getBytes(WxpayConstants.CHARSET), mac.getAlgorithm());
	            mac.init(secret);
	            
	            String checkSign = Hex.byteArrayToHexString(mac.doFinal(content.getBytes(WxpayConstants.CHARSET))).toUpperCase();
	            
	            return (sign != null) && (sign.equals(checkSign));
	
	        } else {
	
	            throw new WxpayApiException("Sign Type is Not Support : signType=" + signType);
	        }
        } catch (Exception e) {
            throw new WxpayApiException(
                "CHECK SIGN content = " + content + ",sign=" + sign, e);
        }
    }

    public static Map<String, String> decodeReqInfo(String req_info, String mch_key) throws WxpayApiException {
        return XMLParser.getMapFromXML(decodeReqInfoToStr(req_info,mch_key));
    }

    public static String decodeReqInfoToStr(String req_info, String mch_key) throws WxpayApiException {
        try{
            String decodeXml = AESUtil.decryptData(req_info,mch_key);
            return decodeXml;
        }catch (Exception e){
            throw new WxpayApiException(e);
        }
    }
}
