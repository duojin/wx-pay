package com.wxpay.api.request;

import java.util.Map;

import com.wxpay.api.WxpayRequest;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayFundTransOrderQueryResponse;

/**
 * 
 * @author Administrator
 *
 *	用于商户的企业付款操作进行结果查询，返回付款操作详细结果。
 *	查询企业付款API只支持查询30天内的订单，30天之前的订单请登录商户平台查询。
 */
public class WxpayFundTransOrderQueryRequest implements WxpayRequest<WxpayFundTransOrderQueryResponse> {

	/**
	 * 接口链接
	 */
	@Override
    public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";
	}
	
	/**
	 * 是否需要证书	
	 */
	@Override
	public boolean isNeedCert() {
		return true;
	}

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

	/** 必填:是
	 * 
	 * 商户订单号
	 * 
	 * 商户订单号，需保持唯一性(只能是字母或者数字，不能包含有符号)
	 */
	@ApiField("partner_trade_no")
	private String partner_trade_no;

	/** 必填:是
	 * 微信支付分配的商户号
	 */
	@ApiField("mchid")
	private String mchid;

	/** 必填:是
	 * 商户号的appid
	 */
	@ApiField("appid")
	private String appid;

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Override
	public Class<WxpayFundTransOrderQueryResponse> getResponseClass() {
		return WxpayFundTransOrderQueryResponse.class;
	}

	@Override
	public void setClientParams(Map<String, String> clientParams) {
		setAppid(clientParams.get("appid"));
		setMchid(clientParams.get("mch_id"));
	    setNonce_str(RandomUtil.getRandomString());
	}
}
