package com.wxpay.api.response;

import com.wxpay.api.WxpayResponse;
import com.wxpay.api.internal.mapping.ApiField;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayTradeRefundQueryResponse extends WxpayResponse {

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
	 * 微信返回的订单总退款次数
	 */
	@ApiField("total_refund_count")
	private Integer total_refund_count;

	/**
	 * 微信返回的订单总金额
	 * 订单总金额，单位为分，只能为整数，详见支付金额https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("total_fee")
	private Integer total_fee;

	/**
	 * 微信返回的订单金额货币种类
	 * 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("fee_type")
	private String fee_type;
	
	/**
	 * 微信返回的现金支付金额
	 * 现金支付金额，单位为分，只能为整数，详见支付金额https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("cash_fee")
	private Integer cash_fee;

	/**
	 * 微信返回的现金支付货币类型
	 * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 */
	@ApiField("cash_fee_type")
	private String cash_fee_type;

	/**
	 * 微信返回的应结订单金额
	 * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
	 */
	@ApiField("settlement_total_fee")
	private Integer settlement_total_fee;

	/**
	 * 微信返回的退款笔数
	 * 当前返回退款笔数
	 */
	@ApiField("refund_count")
	private Integer refund_count;

	/**
	 * 微信返回的商户退款单号
	 * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	 */
	@ApiField("out_refund_no_0")
	private String out_refund_no_0;

	/**
	 * 微信返回的微信退款单号
	 */
	@ApiField("refund_id_0")
	private String refund_id_0;

	/**
	 * 微信返回的退款渠道
	 *
	 * ORIGINAL—原路退款
	 * BALANCE—退回到余额
	 * OTHER_BALANCE—原账户异常退到其他余额账户
	 * OTHER_BANKCARD—原银行卡异常退到其他银行卡
	 */
	@ApiField("refund_channel_0")
	private String refund_channel_0;

	/**
	 * 微信返回的退款金额
	 * 退款总金额,单位为分,可以做部分退款
	 */
	@ApiField("refund_fee")
	private Integer refund_fee;

	public Integer getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	/**
	 * 微信返回的退款金额
	 * 退款总金额,单位为分,可以做部分退款
	 */
	@ApiField("refund_fee_0")
	private Integer refund_fee_0;

	/**
	 * 微信返回的代金券退款金额
	 * 代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
	 */
	@ApiField("coupon_refund_fee_0")
	private Integer coupon_refund_fee_0;

	/**
	 * 微信返回的代金券使用数量
	 * 代金券或立减优惠使用数量 ,$n为下标,从0开始编号
	 */
	@ApiField("coupon_refund_count_0")
	private Integer coupon_refund_count_0;

	/**
	 * 微信返回的代金券ID
	 * 代金券或立减优惠ID, $n为下标，$m为下标，从0开始编号
	 */
	@ApiField("coupon_refund_id_0_0")
	private String coupon_refund_id_0_0;

	/**
	 * 微信返回的代金券类型
	 * CASH--充值代金券
	 * NO_CASH---非充值优惠券
	 * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,$m为下标,从0开始编号，举例：coupon_type_$0_$1
	 */
	@ApiField("coupon_type_0_0")
	private String coupon_type_0_0;

	/**
	 * 微信返回的单个代金券退款金额
	 */
	@ApiField("coupon_refund_fee_0_0")
	private Integer coupon_refund_fee_0_0;

	/**
	 * 微信返回的退款状态
	 *
	 * 退款状态：
	 * SUCCESS—退款成功
	 * REFUNDCLOSE—退款关闭。
	 * PROCESSING—退款处理中
	 * CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。$n为下标，从0开始编号。
	 */
	@ApiField("refund_status_0")
	private String refund_status_0;

	/**
	 * 微信返回的退款资金来源
	 *
	 * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
	 * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
	 * $n为下标，从0开始编号。
	 */
	@ApiField("refund_account_0")
	private String refund_account_0;

	/**
	 * 微信返回的退款入账账户
	 *
	 * 取当前退款单的退款入账方
	 * 1）退回银行卡：
	 * {银行名称}{卡类型}{卡尾号}
	 * 2）退回支付用户零钱:
	 * 支付用户零钱
	 * 3）退还商户:
	 * 商户基本账户
	 * 商户结算银行账户
	 * 4）退回支付用户零钱通:
	 * 支付用户零钱通
	 */
	@ApiField("refund_recv_accout_0")
	private String refund_recv_accout_0;

	/**
	 * 微信返回的退款成功时间
	 *
	 * 退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号。
	 */
	@ApiField("refund_success_time_0")
	private String refund_success_time_0;

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

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public Integer getTotal_refund_count() {
		return total_refund_count;
	}

	public void setTotal_refund_count(Integer total_refund_count) {
		this.total_refund_count = total_refund_count;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}

	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	public Integer getRefund_count() {
		return refund_count;
	}

	public void setRefund_count(Integer refund_count) {
		this.refund_count = refund_count;
	}

	public String getOut_refund_no_0() {
		return out_refund_no_0;
	}

	public void setOut_refund_no_0(String out_refund_no_0) {
		this.out_refund_no_0 = out_refund_no_0;
	}

	public String getRefund_id_0() {
		return refund_id_0;
	}

	public void setRefund_id_0(String refund_id_0) {
		this.refund_id_0 = refund_id_0;
	}

	public String getRefund_channel_0() {
		return refund_channel_0;
	}

	public void setRefund_channel_0(String refund_channel_0) {
		this.refund_channel_0 = refund_channel_0;
	}

	public Integer getRefund_fee_0() {
		return refund_fee_0;
	}

	public void setRefund_fee_0(Integer refund_fee_0) {
		this.refund_fee_0 = refund_fee_0;
	}

	public Integer getCoupon_refund_fee_0() {
		return coupon_refund_fee_0;
	}

	public void setCoupon_refund_fee_0(Integer coupon_refund_fee_0) {
		this.coupon_refund_fee_0 = coupon_refund_fee_0;
	}

	public Integer getCoupon_refund_count_0() {
		return coupon_refund_count_0;
	}

	public void setCoupon_refund_count_0(Integer coupon_refund_count_0) {
		this.coupon_refund_count_0 = coupon_refund_count_0;
	}

	public String getCoupon_refund_id_0_0() {
		return coupon_refund_id_0_0;
	}

	public void setCoupon_refund_id_0_0(String coupon_refund_id_0_0) {
		this.coupon_refund_id_0_0 = coupon_refund_id_0_0;
	}

	public String getCoupon_type_0_0() {
		return coupon_type_0_0;
	}

	public void setCoupon_type_0_0(String coupon_type_0_0) {
		this.coupon_type_0_0 = coupon_type_0_0;
	}

	public Integer getCoupon_refund_fee_0_0() {
		return coupon_refund_fee_0_0;
	}

	public void setCoupon_refund_fee_0_0(Integer coupon_refund_fee_0_0) {
		this.coupon_refund_fee_0_0 = coupon_refund_fee_0_0;
	}

	public String getRefund_status_0() {
		return refund_status_0;
	}

	public void setRefund_status_0(String refund_status_0) {
		this.refund_status_0 = refund_status_0;
	}

	public String getRefund_account_0() {
		return refund_account_0;
	}

	public void setRefund_account_0(String refund_account_0) {
		this.refund_account_0 = refund_account_0;
	}

	public String getRefund_recv_accout_0() {
		return refund_recv_accout_0;
	}

	public void setRefund_recv_accout_0(String refund_recv_accout_0) {
		this.refund_recv_accout_0 = refund_recv_accout_0;
	}

	public String getRefund_success_time_0() {
		return refund_success_time_0;
	}

	public void setRefund_success_time_0(String refund_success_time_0) {
		this.refund_success_time_0 = refund_success_time_0;
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
