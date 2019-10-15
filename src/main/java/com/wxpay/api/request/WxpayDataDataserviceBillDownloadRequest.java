package com.wxpay.api.request;

import com.wxpay.api.WxpayRequest;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayDataDataserviceBillDownloadResponse;

import java.util.Map;

/**
 * 
 * @author Administrator
 *
 *	商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。
 */
public class WxpayDataDataserviceBillDownloadRequest implements WxpayRequest<WxpayDataDataserviceBillDownloadResponse> {

	/**
	 * 接口链接
	 */
	@Override
	public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/pay/downloadbill";
	}
	
	/**
	 * 是否需要证书	
	 */
	@Override
	public boolean isNeedCert() {
		return false;
	}

	/** 必填:是
	 * 微信分配的公众账号ID
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

	/** 必填:是
	 *
	 * 对账单日期
	 * 下载对账单的日期，格式：20140603
	 */
	@ApiField("bill_date")
	private String bill_date;

	/** 必填:否
	 *
	 * 账单类型
	 * ALL（默认值），返回当日所有订单信息（不含充值退款订单）
	 *
	 * SUCCESS，返回当日成功支付的订单（不含充值退款订单）
	 *
	 * REFUND，返回当日退款订单（不含充值退款订单）
	 *
	 * RECHARGE_REFUND，返回当日充值退款订单
	 */
	@ApiField("bill_type")
	private String bill_type;

	/** 必填:否
	 *
	 * 压缩账单
	 * 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
	 */
	@ApiField("tar_type")
	private String tar_type;

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

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public String getTar_type() {
		return tar_type;
	}

	public void setTar_type(String tar_type) {
		this.tar_type = tar_type;
	}

	@Override
	public Class<WxpayDataDataserviceBillDownloadResponse> getResponseClass() {
		return WxpayDataDataserviceBillDownloadResponse.class;
	}
	public void setBizContent(Map<String, Object> bizContent){
		setBill_date(getContent("bill_date",bizContent));
		setBill_type(getContent("bill_type",bizContent));
	}
	@Override
	public void setClientParams(Map<String, String> clientParams) {
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
