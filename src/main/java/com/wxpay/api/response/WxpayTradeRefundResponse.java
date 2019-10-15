package com.wxpay.api.response;

import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.WxpayResponse;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayTradeRefundResponse extends WxpayResponse {

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
	 * 微信返回的微信订单号
	 */
	@ApiField("transaction_id")
	private String transaction_id;

	/**
	 * 微信返回的商户订单号
	 */
	@ApiField("out_trade_no")
	private String out_trade_no;

	/**
	 * 微信返回的商户退款单号
	 */
	@ApiField("out_refund_no")
	private String out_refund_no;

	/**
	 * 微信返回的微信退款单号
	 */
	@ApiField("refund_id")
	private String refund_id;
	
	/**
	 * 微信返回的退款金额
	 */
	@ApiField("refund_fee")
	private Integer refund_fee;

	/**
	 * 微信返回的应结退款金额
	 */
	@ApiField("settlement_refund_fee")
	private Integer settlement_refund_fee;

	/**
	 * 微信返回的标价金额
	 */
	@ApiField("total_fee")
	private Integer total_fee;

	/**
	 * 微信返回的应结订单金额
	 */
	@ApiField("settlement_total_fee")
	private Integer settlement_total_fee;

	/**
	 * 微信返回的标价币种
	 */
	@ApiField("fee_type")
	private String fee_type;

	/**
	 * 微信返回的现金支付金额
	 */
	@ApiField("cash_fee")
	private Integer cash_fee;

	/**
	 * 微信返回的现金支付币种
	 */
	@ApiField("cash_fee_type")
	private String cash_fee_type;

	/**
	 * 微信返回的现金退款金额
	 */
	@ApiField("cash_refund_fee")
	private Integer cash_refund_fee;

	/**
	 * 微信返回的代金券类型
	 */
	@ApiField("coupon_type_0")
	private String coupon_type_0;

	/**
	 * 微信返回的代金券退款总金额
	 */
	@ApiField("coupon_refund_fee")
	private Integer coupon_refund_fee;

	/**
	 * 微信返回的单个代金券退款金额
	 */
	@ApiField("coupon_refund_fee_0")
	private Integer coupon_refund_fee_0;

	/**
	 * 微信返回的退款代金券使用数量
	 */
	@ApiField("coupon_refund_count")
	private Integer coupon_refund_count;

	/**
	 * 微信返回的退款代金券ID
	 */
	@ApiField("coupon_refund_id_0")
	private String coupon_refund_id_0;
	
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

	/**
	 * @return the out_refund_no
	 */
	public String getOut_refund_no() {
		return out_refund_no;
	}

	/**
	 * @param out_refund_no the out_refund_no to set
	 */
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	/**
	 * @return the refund_id
	 */
	public String getRefund_id() {
		return refund_id;
	}

	/**
	 * @param refund_id the refund_id to set
	 */
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	/**
	 * @return the refund_fee
	 */
	public Integer getRefund_fee() {
		return refund_fee;
	}

	/**
	 * @param refund_fee the refund_fee to set
	 */
	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	/**
	 * @return the settlement_refund_fee
	 */
	public Integer getSettlement_refund_fee() {
		return settlement_refund_fee;
	}

	/**
	 * @param settlement_refund_fee the settlement_refund_fee to set
	 */
	public void setSettlement_refund_fee(Integer settlement_refund_fee) {
		this.settlement_refund_fee = settlement_refund_fee;
	}

	/**
	 * @return the total_fee
	 */
	public Integer getTotal_fee() {
		return total_fee;
	}

	/**
	 * @param total_fee the total_fee to set
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * @return the settlement_total_fee
	 */
	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}

	/**
	 * @param settlement_total_fee the settlement_total_fee to set
	 */
	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	/**
	 * @return the fee_type
	 */
	public String getFee_type() {
		return fee_type;
	}

	/**
	 * @param fee_type the fee_type to set
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	/**
	 * @return the cash_fee
	 */
	public Integer getCash_fee() {
		return cash_fee;
	}

	/**
	 * @param cash_fee the cash_fee to set
	 */
	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	/**
	 * @return the cash_fee_type
	 */
	public String getCash_fee_type() {
		return cash_fee_type;
	}

	/**
	 * @param cash_fee_type the cash_fee_type to set
	 */
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	/**
	 * @return the cash_refund_fee
	 */
	public Integer getCash_refund_fee() {
		return cash_refund_fee;
	}

	/**
	 * @param cash_refund_fee the cash_refund_fee to set
	 */
	public void setCash_refund_fee(Integer cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}

	/**
	 * @return the coupon_type_0
	 */
	public String getCoupon_type_0() {
		return coupon_type_0;
	}

	/**
	 * @param coupon_type_0 the coupon_type_0 to set
	 */
	public void setCoupon_type_0(String coupon_type_0) {
		this.coupon_type_0 = coupon_type_0;
	}

	/**
	 * @return the coupon_refund_fee
	 */
	public Integer getCoupon_refund_fee() {
		return coupon_refund_fee;
	}

	/**
	 * @param coupon_refund_fee the coupon_refund_fee to set
	 */
	public void setCoupon_refund_fee(Integer coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}

	/**
	 * @return the coupon_refund_fee_0
	 */
	public Integer getCoupon_refund_fee_0() {
		return coupon_refund_fee_0;
	}

	/**
	 * @param coupon_refund_fee_0 the coupon_refund_fee_0 to set
	 */
	public void setCoupon_refund_fee_0(Integer coupon_refund_fee_0) {
		this.coupon_refund_fee_0 = coupon_refund_fee_0;
	}

	/**
	 * @return the coupon_refund_count
	 */
	public Integer getCoupon_refund_count() {
		return coupon_refund_count;
	}

	/**
	 * @param coupon_refund_count the coupon_refund_count to set
	 */
	public void setCoupon_refund_count(Integer coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}

	/**
	 * @return the coupon_refund_id_0
	 */
	public String getCoupon_refund_id_0() {
		return coupon_refund_id_0;
	}

	/**
	 * @param coupon_refund_id_0 the coupon_refund_id_0 to set
	 */
	public void setCoupon_refund_id_0(String coupon_refund_id_0) {
		this.coupon_refund_id_0 = coupon_refund_id_0;
	}

	/**
	 * @return the result_code
	 */
	public String getResult_code() {
		return result_code;
	}

	/**
	 * @param result_code the result_code to set
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	/**
	 * @return the err_code
	 */
	public String getErr_code() {
		return err_code;
	}

	/**
	 * @param err_code the err_code to set
	 */
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	/**
	 * @return the err_code_des
	 */
	public String getErr_code_des() {
		return err_code_des;
	}

	/**
	 * @param err_code_des the err_code_des to set
	 */
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	@Override
    public boolean isNeedVerifySign(){
		return true;
	}
}
