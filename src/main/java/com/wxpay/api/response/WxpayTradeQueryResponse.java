package com.wxpay.api.response;

import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.WxpayResponse;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayTradeQueryResponse extends WxpayResponse {

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
	 * 微信返回的设备号
	 */
	@ApiField("device_info")
	private String device_info;

	/**
	 * 微信返回的用户标识
	 * 用户在商户appid下的唯一标识
	 */
	@ApiField("openid")
	private String openid;

	/**
	 * 是否关注公众账号
	 * 用户是否关注公众账号，Y-关注，N-未关注
	 */
	@ApiField("is_subscribe")
	private String is_subscribe;

	/**
	 * 交易类型
	 * 调用接口提交的交易类型
	 */
	@ApiField("trade_type")
	private String trade_type;	

	/**
	 * 交易状态
	 * SUCCESS—支付成功
	 * REFUND—转入退款
	 * NOTPAY—未支付
	 * CLOSED—已关闭
	 * REVOKED—已撤销（刷卡支付）
	 * USERPAYING--用户支付中
	 * PAYERROR--支付失败(其他原因，如银行返回失败)
	 */
	@ApiField("trade_state")
	private String trade_state;	

	/**
	 * 付款银行
	 * 银行类型，采用字符串类型的银行标识
	 */
	@ApiField("bank_type")
	private String bank_type;
	
	/**
	 * 总金额
	 * 订单总金额，单位为分
	 */
	@ApiField("total_fee")
	private Integer total_fee;

	/**
	 * 货币种类
	 * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("fee_type")
	private String fee_type;

	/**
	 * 现金支付金额
	 * 现金支付金额订单现金支付金额，详见支付金额https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("cash_fee")
	private Integer cash_fee;

	/**
	 * 现金支付货币类型
	 * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("cash_fee_type")
	private String cash_fee_type;
	
	/**
	 * 应结订单金额
	 */
	@ApiField("settlement_total_fee")
	private Integer settlement_total_fee;
	
	/**
	 * 代金券金额
	 * “代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("coupon_fee")
	private Integer coupon_fee;
	
	/**
	 * 代金券使用数量
	 * 代金券或立减优惠使用数量
	 */
	@ApiField("coupon_count")
	private Integer coupon_count;	

	/**
	 * 代金券ID
	 */
	@ApiField("coupon_id_0")
	private String coupon_id_0;

	/**
	 * 代金券类型
	 */
	@ApiField("coupon_type_0")
	private String coupon_type_0;

	/**
	 * 单个代金券支付金额
	 * 单个代金券或立减优惠支付金额, $n为下标，从0开始编号
	 */
	@ApiField("coupon_fee_0")
	private Integer coupon_fee_0;

	/**
	 * 附加数据
	 */
	@ApiField("attach")
	private String attach;

	/**
	 * 支付完成时间
	 * 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	@ApiField("time_end")
	private String time_end;

	/**
	 * 交易状态描述
	 * 对当前查询订单状态的描述和下一步操作的指引
	 */
	@ApiField("trade_state_desc")
	private String trade_state_desc;
	
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



	public String getDevice_info() {
		return device_info;
	}



	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}



	public String getOpenid() {
		return openid;
	}



	public void setOpenid(String openid) {
		this.openid = openid;
	}



	public String getIs_subscribe() {
		return is_subscribe;
	}



	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}



	public String getTrade_type() {
		return trade_type;
	}



	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}



	public String getTrade_state() {
		return trade_state;
	}



	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}



	public String getBank_type() {
		return bank_type;
	}



	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
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



	public Integer getCoupon_fee() {
		return coupon_fee;
	}



	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}



	public Integer getCoupon_count() {
		return coupon_count;
	}



	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
	}



	public String getCoupon_id_0() {
		return coupon_id_0;
	}



	public void setCoupon_id_0(String coupon_id_0) {
		this.coupon_id_0 = coupon_id_0;
	}



	public String getCoupon_type_0() {
		return coupon_type_0;
	}



	public void setCoupon_type_0(String coupon_type_0) {
		this.coupon_type_0 = coupon_type_0;
	}



	public Integer getCoupon_fee_0() {
		return coupon_fee_0;
	}



	public void setCoupon_fee_0(Integer coupon_fee_0) {
		this.coupon_fee_0 = coupon_fee_0;
	}



	public String getAttach() {
		return attach;
	}



	public void setAttach(String attach) {
		this.attach = attach;
	}



	public String getTime_end() {
		return time_end;
	}



	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}



	public String getTrade_state_desc() {
		return trade_state_desc;
	}



	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
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



	public boolean isNeedVerifySign(){
		return true;
	}
}
