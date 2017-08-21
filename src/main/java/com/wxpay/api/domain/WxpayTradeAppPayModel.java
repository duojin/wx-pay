package com.wxpay.api.domain;

import com.wxpay.api.internal.mapping.ApiField;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayTradeAppPayModel extends WxpayModel{


	/** 必填:是
	 * 应用ID
	 * 微信开放平台审核通过的应用APPID
	 */
	@ApiField("appid")
	private String appid;

	/** 必填:是
	 * 微信支付分配的商户号
	 */
	@ApiField("partnerid")
	private String partnerid;

	/** 必填:是
	 * 预支付交易会话ID
	 * 微信返回的支付交易会话ID
	 */
	@ApiField("prepayid")
	private String prepayid;

	/** 必填:是
	 * 扩展字段
	 * 暂填写固定值Sign=WXPay
	 */
	@ApiField("package")
	private String packagevalue = "Sign=WXPay";

	/** 必填:是
	 * 随机字符串，不长于32位。
	 */
	@ApiField("noncestr")
	private String noncestr;

	/** 必填:是
	 * 时间戳
	 */
	@ApiField("timestamp")
	private String timestamp;

	/** 必填:是
	 * 
	 * 签名
	 */
	@ApiField("sign")
	private String sign;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public String getPrepayid() {
		return prepayid;
	}

	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}

	public String getPackagevalue() {
		return packagevalue;
	}

	public void setPackagevalue(String packagevalue) {
		this.packagevalue = packagevalue;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
}
