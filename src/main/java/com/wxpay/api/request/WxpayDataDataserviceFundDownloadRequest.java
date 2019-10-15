package com.wxpay.api.request;

import com.wxpay.api.WxpayConstants;
import com.wxpay.api.WxpayRequest;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayDataDataserviceFundDownloadResponse;

import java.util.Map;

/**
 * 
 * @author Administrator
 *
 *	商户可以通过该接口下载自2017年6月1日起 的历史资金流水账单。
 *
 * 说明：
 * 1、资金账单中的数据反映的是商户微信账户资金变动情况；
 * 2、当日账单在次日上午9点开始生成，建议商户在上午10点以后获取；
 * 3、资金账单中涉及金额的字段单位为“元”。
 */
public class WxpayDataDataserviceFundDownloadRequest implements WxpayRequest<WxpayDataDataserviceFundDownloadResponse> {

	/**
	 * 接口链接
	 */
	@Override
	public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/pay/downloadfundflow";
	}
	
	/**
	 * 是否需要证书	
	 */
	@Override
	public boolean isNeedCert() {
		return true;
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

	/** 必填:否
	 *
	 * 签名类型
	 *
	 * 签名类型，目前仅支持HMAC-SHA256
	 */
	@ApiField("sign_type")
	private String sign_type = WxpayConstants.SIGN_TYPE_HMAC_SHA256;

	/** 必填:是
	 *
	 * 资金账单日期
	 * 下载对账单的日期，格式：20140603
	 */
	@ApiField("bill_date")
	private String bill_date;

	/** 必填:是
	 *
	 * 资金账户类型
	 *
	 * 账单的资金来源账户：
	 * Basic  基本账户
	 * Operation 运营账户
	 * Fees 手续费账户
	 */
	@ApiField("account_type")
	private String account_type;

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

	@Override
    public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getTar_type() {
		return tar_type;
	}

	public void setTar_type(String tar_type) {
		this.tar_type = tar_type;
	}

	@Override
	public Class<WxpayDataDataserviceFundDownloadResponse> getResponseClass() {
		return WxpayDataDataserviceFundDownloadResponse.class;
	}
	public void setBizContent(Map<String, Object> bizContent){
		setBill_date(getContent("bill_date",bizContent));
		setAccount_type(getContent("account_type",bizContent));
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
