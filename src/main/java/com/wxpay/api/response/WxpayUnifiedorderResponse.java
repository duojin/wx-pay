package com.wxpay.api.response;

import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.WxpayResponse;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayUnifiedorderResponse extends WxpayResponse {

	private static final long serialVersionUID = 8516871145151267475L;

	/** 
	 * 调用接口提交的应用ID
	 */
	@ApiField("appid")
	private String appid;

	/** 
	 * 调用接口提交的商户号
	 */
	@ApiField("mch_id")
	private String mch_id;

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
	 * 微信返回的签名
	 */
	@ApiField("sign")
	private String sign;

	/** 
	 * 业务结果  SUCCESS/FAIL
	 */
	@ApiField("result_code")
	private String result_code;
	
	/** 
	 * 错误代码
	 */
	@ApiField("err_code")
	private String err_code;
	
	/** 
	 * 错误返回的信息描述
	 */
	@ApiField("err_code_des")
	private String err_code_des;
	
	/** 
	 * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP
	 */
	@ApiField("trade_type")
	private String trade_type;
	
	/** 
	 * 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	 */
	@ApiField("prepay_id")
	private String prepay_id;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	
	@Override
    public boolean isNeedVerifySign(){
		return true;
	}
}
