package com.wxpay.api.request;

import com.wxpay.api.WxpayRequest;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayTradeRefundQueryResponse;

import java.util.Map;

/**
 * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
 * 
 * @author Administrator
 *
 */
public class WxpayTradeRefundQueryRequest implements WxpayRequest<WxpayTradeRefundQueryResponse> {

	/**
	 * 接口链接
	 */
	@Override
	public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/pay/refundquery";
	}
	/**
	 * 是否需要证书	
	 */
	@Override
	public boolean isNeedCert() {
		return false;
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

	/** 必填:四选一
	 *
	 * 微信订单号
	 *
	 * 微信订单号查询的优先级是： refund_id > out_refund_no > transaction_id > out_trade_no
	 */
	@ApiField("transaction_id")
	private String transaction_id;

	/** 必填:四选一
	 * 
	 * 商户订单号
	 * 
	 * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
	 */
	@ApiField("out_trade_no")
	private String out_trade_no;

	/** 必填:四选一
	 * 
	 * 商户退款单号 String(64)
	 * 
	 * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	 */
	@ApiField("out_refund_no")
	private String out_refund_no;

	/** 必填:四选一
	 * 
	 * 微信退款单号
	 * 微信生成的退款单号，在申请退款接口有返回
	 */
	@ApiField("refund_id")
	private String refund_id;

	/** 必填:否
	 * 
	 * 偏移量
	 * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
	 */
	@ApiField("offset")
	private Integer offset;

	@Override
	public Class<WxpayTradeRefundQueryResponse> getResponseClass() {
		return WxpayTradeRefundQueryResponse.class;
	}

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

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public void setBizContent(Map<String, Object> bizContent){
		setTransaction_id(getContent("transaction_id",bizContent));
		setOut_trade_no(getContent("out_trade_no",bizContent));
		setOut_refund_no(getContent("out_refund_no",bizContent));
		setRefund_id(getContent("refund_id",bizContent));
		if((bizContent.containsKey("offset")) && (bizContent.get("offset") != null) && (!bizContent.get("offset").toString().isEmpty())){
			setOffset(Integer.valueOf(getContent("offset",bizContent)));
		}
	}
	  
	@Override
	public void setClientParams(Map<String, String> clientParams){
		setAppid(clientParams.get("appid"));
		setMch_id(clientParams.get("mch_id"));
		setNonce_str(RandomUtil.getRandomString());
	}
	
	private String getContent(String key,Map<String, Object> bizContent){
		if ((bizContent.containsKey(key)) && (bizContent.get(key) != null) && (!bizContent.get(key).toString().isEmpty())) {
			return bizContent.get(key).toString();
		}
		return "";
	}
}
