package com.wxpay.api.response;

import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.WxpayResponse;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayFundTransToaccountTransferResponse extends WxpayResponse {

	private static final long serialVersionUID = 4343125499816218851L;

	/** 
	 * 微信分配的公众账号ID（企业号corpid即为此appId）
	 */
	@ApiField("mch_appid")
	private String mch_appid;

	/** 
	 * 调用接口提交的商户号
	 */
	@ApiField("mchid")
	private String mchid;

	/** 
	 * 调用接口提交的终端设备号
	 */
	@ApiField("device_info")
	private String device_info;

	/** 
	 * 微信返回的随机字符串
	 */
	@ApiField("nonce_str")
	private String nonce_str;

	/** 
	 * 业务结果
	 * SUCCESS/FAIL
	 */
	@ApiField("result_code")
	private String result_code;

	/** 
	 * 错误代码
	 */
	@ApiField("err_code")
	private String err_code;

	/** 
	 * 错误代码描述
	 */
	@ApiField("err_code_des")
	private String err_code_des;

	/** 
	 * 商户订单号
	 */
	@ApiField("partner_trade_no")
	private String partner_trade_no;
	
	/** 
	 * 微信订单号
	 */
	@ApiField("payment_no")
	private String payment_no;
	
	/** 
	 * 微信支付成功时间
	 */
	@ApiField("payment_time")
	private String payment_time;

	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public String getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}

	public boolean isNeedVerifySign(){
		return false;
	}
}
