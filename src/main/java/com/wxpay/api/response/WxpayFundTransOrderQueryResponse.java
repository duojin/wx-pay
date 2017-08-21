package com.wxpay.api.response;

import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.WxpayResponse;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayFundTransOrderQueryResponse extends WxpayResponse {

	private static final long serialVersionUID = 1415426866651155291L;

	/** 
	 * 业务结果
	 * SUCCESS/FAIL
	 */
	@ApiField("result_code")
	private String result_code;

	/** 
	 * 错误代码
	 * 错误码信息
	 */
	@ApiField("err_code")
	private String err_code;

	/** 
	 * 错误代码描述
	 */
	@ApiField("err_code_des")
	private String err_code_des;

	/** 
	 * 商户单号
	 */
	@ApiField("partner_trade_no")
	private String partner_trade_no;

	/** 
	 * 商户号
	 */
	@ApiField("mch_id")
	private String mch_id;

	/** 
	 * 付款单号
	 */
	@ApiField("detail_id")
	private String detail_id;

	/** 
	 * 转账状态
	 */
	@ApiField("status")
	private String status;

	/** 
	 * 失败原因
	 */
	@ApiField("reason")
	private String reason;

	/** 
	 * 收款用户openid
	 */
	@ApiField("openid")
	private String openid;

	/** 
	 * 收款用户姓名
	 */
	@ApiField("transfer_name")
	private String transfer_name;

	/** 
	 * 付款金额
	 */
	@ApiField("payment_amount")
	private String payment_amount;

	/** 
	 * 转账时间
	 */
	@ApiField("transfer_time")
	private String transfer_time;

	/** 
	 * 付款描述
	 */
	@ApiField("desc")
	private String desc;

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

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTransfer_name() {
		return transfer_name;
	}

	public void setTransfer_name(String transfer_name) {
		this.transfer_name = transfer_name;
	}

	public String getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getTransfer_time() {
		return transfer_time;
	}

	public void setTransfer_time(String transfer_time) {
		this.transfer_time = transfer_time;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isNeedVerifySign(){
		return false;
	}
}
