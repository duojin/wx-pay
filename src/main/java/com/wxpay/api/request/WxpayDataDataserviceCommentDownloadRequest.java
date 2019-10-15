package com.wxpay.api.request;

import com.wxpay.api.WxpayConstants;
import com.wxpay.api.WxpayRequest;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayDataDataserviceCommentDownloadResponse;

import java.util.Map;

/**
 * 
 * @author Administrator
 *
 *	商户可以通过该接口拉取用户在微信支付交易记录中针对你的支付记录进行的评价内容。商户可结合商户系统逻辑对该内容数据进行存储、分析、展示、客服回访以及其他使用。如商户业务对评价内容有依赖，可主动引导用户进入微信支付交易记录进行评价。
 *  注意：
 * 1. 该内容所有权为提供内容的微信用户，商户在使用内容的过程中应遵从用户意愿
 * 2. 一次最多拉取200条评价数据，可根据时间区间分批次拉取
 * 3. 接口只能拉取最近三个月以内的评价数据
 */
public class WxpayDataDataserviceCommentDownloadRequest implements WxpayRequest<WxpayDataDataserviceCommentDownloadResponse> {

	/**
	 * 接口链接
	 */
	@Override
	public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/billcommentsp/batchquerycomment";
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
	 * 签名类型，目前仅支持HMAC-SHA256，默认就是HMAC-SHA256
	 */
	@ApiField("sign_type")
	private String sign_type = WxpayConstants.SIGN_TYPE_HMAC_SHA256;

	/** 必填:是
	 *
	 * 开始时间
	 * 按用户评论时间批量拉取的起始时间，格式为yyyyMMddHHmmss
	 */
	@ApiField("begin_time")
	private String begin_time;

	/** 必填:是
	 *
	 * 结束时间
	 * 按用户评论时间批量拉取的结束时间，格式为yyyyMMddHHmmss
	 */
	@ApiField("end_time")
	private String end_time;

	/** 必填:是
	 *
	 * 位移
	 * 指定从某条记录的下一条开始返回记录。接口调用成功时，会返回本次查询最后一条数据的offset。商户需要翻页时，应该把本次调用返回的offset 作为下次调用的入参。注意offset是评论数据在微信支付后台保存的索引，未必是连续的
	 */
	@ApiField("offset")
	private Integer offset;

	/** 必填:否
	 *
	 * 条数
	 * 一次拉取的条数, 最大值是200，默认是200
	 * 实际接口必须
	 */
	@ApiField("limit")
	private Integer limit=200;

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

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public Class<WxpayDataDataserviceCommentDownloadResponse> getResponseClass() {
		return WxpayDataDataserviceCommentDownloadResponse.class;
	}
	public void setBizContent(Map<String, Object> bizContent){
		setBegin_time(getContent("begin_time",bizContent));
		setEnd_time(getContent("end_time",bizContent));
		if ((bizContent.containsKey("offset")) && (bizContent.get("offset") != null) && (!bizContent.get("offset").toString().isEmpty())) {
			setOffset(Integer.valueOf(bizContent.get("offset").toString()));
		}else{
			setOffset(0);
		}
		if ((bizContent.containsKey("limit")) && (bizContent.get("limit") != null) && (!bizContent.get("limit").toString().isEmpty())) {
			setLimit(Integer.valueOf(bizContent.get("limit").toString()));
		}
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
