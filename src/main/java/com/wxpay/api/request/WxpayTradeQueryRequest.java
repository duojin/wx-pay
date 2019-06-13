package com.wxpay.api.request;

import java.util.Map;

import com.wxpay.api.WxpayRequest;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayTradeQueryResponse;

/**
 * 查询订单
 * 
 * @author Administrator
 *
 */
public class WxpayTradeQueryRequest implements WxpayRequest<WxpayTradeQueryResponse> {

	/**
	 * 接口链接
	 */
	public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/pay/orderquery";
	}
	/**
	 * 是否需要证书	
	 */
	public boolean isNeedCert() {
		return false;
	}

	/** 必填:是
	 * 应用APPID
	 * 微信开放平台审核通过的应用APPID
	 */
	@ApiField("appid")
	private String appid;

	/** 必填:是
	 * 微信支付分配的商户号
	 */
	@ApiField("mch_id")
	private String mch_id;

	/** 必填:是
	 * 随机字符串，不长于32位。
	 */
	@ApiField("nonce_str")
	private String nonce_str;

	/** 必填:是
	 * 
	 * 签名
	 */
	@ApiField("sign")
	private String sign;

	/** 必填:否
	 * 
	 * 签名类型
	 * 
	 * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
	 */
	@ApiField("sign_type")
	private String sign_type;

	/** 必填:二选一
	 * 
	 * 微信订单号
	 * 
	 * 微信生成的订单号，在支付通知中有返回
	 */
	@ApiField("transaction_id")
	private String transaction_id;

	/** 必填:二选一
	 * 
	 * 商户订单号
	 * 
	 * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
	 */
	@ApiField("out_trade_no")
	private String out_trade_no;

	public Class<WxpayTradeQueryResponse> getResponseClass() {
		return WxpayTradeQueryResponse.class;
	}

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * @return the mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}
	/**
	 * @param mch_id the mch_id to set
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/**
	 * @return the nonce_str
	 */
	public String getNonce_str() {
		return nonce_str;
	}
	/**
	 * @param nonce_str the nonce_str to set
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * @return the sign_type
	 */
	public String getSign_type() {
		return sign_type;
	}
	/**
	 * @param sign_type the sign_type to set
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}
	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**
	 * @param out_trade_no the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public void setBizContent(Map<String, Object> bizContent){
		setOut_trade_no(getContent("out_trade_no",bizContent));
		setTransaction_id(getContent("transaction_id",bizContent));
	}
	  
	public void setClientParams(Map<String, String> clientParams){
		setAppid(clientParams.get("appid"));
		setMch_id(clientParams.get("mch_id"));
		setNonce_str(RandomUtil.getRandomString());
		setSign_type(clientParams.get("sign_type"));
	}
	
	private String getContent(String key,Map<String, Object> bizContent){
		if ((bizContent.containsKey(key)) && (bizContent.get(key) != null) && (!bizContent.get(key).toString().isEmpty())) {
			return bizContent.get(key).toString();
		}
		return "";
	}
}
