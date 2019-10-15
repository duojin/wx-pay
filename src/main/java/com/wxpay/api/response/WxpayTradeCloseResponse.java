package com.wxpay.api.response;

import com.wxpay.api.WxpayResponse;
import com.wxpay.api.internal.mapping.ApiField;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayTradeCloseResponse extends WxpayResponse {

	private static final long serialVersionUID = -7316060441992092815L;

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



	@Override
    public boolean isNeedVerifySign(){
		return true;
	}
}
