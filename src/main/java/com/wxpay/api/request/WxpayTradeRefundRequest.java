package com.wxpay.api.request;

import java.util.Map;

import com.wxpay.api.WxpayConstants;
import com.wxpay.api.WxpayRequest;
import com.wxpay.api.conf.WxpayConfigure;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayTradeRefundResponse;
import com.wxpay.api.response.WxpayUnifiedorderResponse;

/**
 * 商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再在APP里面调起支付。
 * 
 * @author Administrator
 *
 */
public class WxpayTradeRefundRequest implements WxpayRequest<WxpayTradeRefundResponse> {

	/**
	 * 接口链接
	 */
	@Override
    public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/secapi/pay/refund";
	}
	/**
	 * 是否需要证书	
	 */
	@Override
	public boolean isNeedCert() {
		return true;
	}

	/** 必填:是
	 * 应用ID
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
	private String sign_type = WxpayConstants.SIGN_TYPE_MD5;

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

	/** 必填:是
	 * 
	 * 商户退款单号 String(64)
	 * 
	 * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	 */
	@ApiField("out_refund_no")
	private String out_refund_no;

	/** 必填:是
	 * 
	 * 订单金额，单位为分
	 */
	@ApiField("total_fee")
	private Integer total_fee;

	/** 必填:是
	 * 
	 * 退款金额，单位为分
	 * 退款总金额，订单总金额，单位为分，只能为整数，详见支付金额
	 */
	@ApiField("refund_fee")
	private Integer refund_fee;
	

	/** 必填:否
	 * 
	 * 退款货币种类
	 * 
	 * 符合ISO 4217标准的三位字母代码，默认人民币：CNY
	 */
	@ApiField("refund_fee_type")
	private String refund_fee_type;

	/** 必填:否
	 * 
	 * 退款原因
	 * 
	 * 若商户传入，会在下发给用户的退款消息中体现退款原因
	 */
	@ApiField("refund_desc")
	private String refund_desc;

	/** 必填:否
	 * 
	 * 退款资金来源
	 * 
	 * 仅针对老资金流商户使用
	 */
	@ApiField("refund_account")
	private String refund_account;

	/** 必填:是
	 *
	 * 退款结果通知url
	 * 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
	 */
	@ApiField("notify_url")
	private String notify_url;

	@Override
	public Class<WxpayTradeRefundResponse> getResponseClass() {
		return WxpayTradeRefundResponse.class;
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
	@Override
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
	 * @return the refund_fee_type
	 */
	public String getRefund_fee_type() {
		return refund_fee_type;
	}
	/**
	 * @param refund_fee_type the refund_fee_type to set
	 */
	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}
	/**
	 * @return the refund_desc
	 */
	public String getRefund_desc() {
		return refund_desc;
	}
	/**
	 * @param refund_desc the refund_desc to set
	 */
	public void setRefund_desc(String refund_desc) {
		this.refund_desc = refund_desc;
	}
	/**
	 * @return the refund_account
	 */
	public String getRefund_account() {
		return refund_account;
	}
	/**
	 * @param refund_account the refund_account to set
	 */
	public void setRefund_account(String refund_account) {
		this.refund_account = refund_account;
	}
	/**
	 * @return the notify_url
	 */
	public String getNotify_url() {
		return notify_url;
	}
	/**
	 * @param notify_url the notify_url to set
	 */
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public void setBizContent(Map<String, Object> bizContent){
		setOut_trade_no(getContent("out_trade_no",bizContent));
		setOut_refund_no(getContent("out_refund_no",bizContent));
		setTotal_fee(Integer.valueOf(getContent("total_fee",bizContent)));
		setRefund_fee(Integer.valueOf(getContent("refund_fee",bizContent)));
		setRefund_desc(getContent("refund_desc",bizContent));
	}
	  
	@Override
	public void setClientParams(Map<String, String> clientParams){
		setAppid(clientParams.get("appid"));
		setMch_id(clientParams.get("mch_id"));
		setNonce_str(RandomUtil.getRandomString());
		setSign_type(clientParams.get("sign_type"));
		setNotify_url(WxpayConfigure.getNOTIFY_URL());
	}
	
	private String getContent(String key,Map<String, Object> bizContent){
		if ((bizContent.containsKey(key)) && (bizContent.get(key) != null) && (!bizContent.get(key).toString().isEmpty())) {
			return bizContent.get(key).toString();
		}
		return "";
	}
}
