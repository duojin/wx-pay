package com.wxpay.api.request;

import java.util.Map;

import com.wxpay.api.WxpayRequest;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayFundTransToaccountTransferResponse;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayFundTransToaccountTransferRequest implements WxpayRequest<WxpayFundTransToaccountTransferResponse> {

	/**
	 * 接口链接
	 */
	@Override
    public String getApiUrl() {
	    return "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
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
	@ApiField("mch_appid")
	private String mch_appid;

	/** 必填:是
	 * 微信支付分配的商户号
	 */
	@ApiField("mchid")
	private String mchid;

	/** 必填:否
	 * 终端设备号(门店号或收银设备ID)，默认请传"WEB"
	 */
	@ApiField("device_info")
	private String device_info;

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
	 * 商户订单号
	 * 
	 * 商户订单号，需保持唯一性(只能是字母或者数字，不能包含有符号)
	 */
	@ApiField("partner_trade_no")
	private String partner_trade_no;

	/** 必填:是
	 * 
	 * 用户openid
	 * 
	 * 商户订单号，需保持唯一性(只能是字母或者数字，不能包含有符号)
	 */
	@ApiField("openid")
	private String openid;

	/** 必填:是
	 * 
	 * 校验用户姓名选项
	 * 
	 * NO_CHECK：不校验真实姓名 
	 * FORCE_CHECK：强校验真实姓名
	 */
	@ApiField("check_name")
	private String check_name;

	/** 必填:可选
	 * 
	 * 收款用户姓名
	 * 
	 * 收款用户真实姓名。 
	 * 如果check_name设置为FORCE_CHECK，则必填用户真实姓名
	 */
	@ApiField("re_user_name")
	private String re_user_name;

	/** 必填:是
	 * 
	 * 金额
	 * 
	 * 企业付款金额，单位为分
	 */
	@ApiField("amount")
	private String amount;

	/** 必填:是
	 * 
	 * 企业付款描述信息
	 * 
	 * 企业付款操作说明信息。必填。
	 */
	@ApiField("desc")
	private String desc;

	/** 必填:是
	 * 
	 * Ip地址
	 * 
	 * 调用接口的机器Ip地址
	 */
	@ApiField("spbill_create_ip")
	private String spbill_create_ip;

	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getRe_user_name() {
		return re_user_name;
	}

	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	@Override
	public Class<WxpayFundTransToaccountTransferResponse> getResponseClass() {
		return WxpayFundTransToaccountTransferResponse.class;
	}

	@Override
	public void setClientParams(Map<String, String> clientParams){
		setMch_appid(clientParams.get("appid"));
	    setMchid(clientParams.get("mch_id"));
	    setNonce_str(RandomUtil.getRandomString());
	}
	
	public void setBizContent(Map<String, Object> bizContent){
		setPartner_trade_no(getContent("partner_trade_no",bizContent));
		setOpenid(getContent("openid",bizContent));
		setCheck_name(getContent("check_name",bizContent));
		setRe_user_name(getContent("re_user_name",bizContent));
		setAmount(getContent("amount",bizContent));
		setDesc(getContent("desc",bizContent));
		setSpbill_create_ip(getContent("spbill_create_ip",bizContent));
	}
	
	private String getContent(String key,Map<String, Object> bizContent){
		if ((bizContent.containsKey(key)) && (bizContent.get(key) != null) && (!bizContent.get(key).toString().isEmpty())) {
			return bizContent.get(key).toString();
		}
		return "";
	}
}
