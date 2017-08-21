package com.wxpay.api;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayConstants {

    public static final String CHARSET                        = "UTF-8";
    public static final String SIGN_TYPE_MD5                  = "MD5";
    public static final String SIGN_TYPE_HMAC_SHA256          = "HMAC-SHA256";
    public static final String SIGN_TYPE                      = SIGN_TYPE_MD5;
    public static final String KEY_APPID                      = "appid";//微信开放平台审核通过的应用APPID
    public static final String KEY_MCH_ID                     = "mch_id";//微信支付分配的商户号
    public static final String KEY_NONCE_STR                  = "nonce_str";//随机字符串，不长于32位。
    public static final String KEY_SIGN_TYPE                  = "sign_type";
    public static final String KEY_SIGN                       = "sign";//通过签名算法计算得出的签名值
    public static final String KEY_NOTIFY_URL                 = "notify_url";
    public static final String KEY_TIMESTAMP                  = "timestamp";
    public static final String DATE_TIME_FORMAT               = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIMEZONE                  = "GMT+8";
    public static final String RESPONSE_XML_NODE_NAME         = "xml";
    public static final String SUCCESS                        = "SUCCESS";
    public static final String FAIL                           = "FAIL";

}
