package com.wxpay.api.request;

import java.util.Map;

import com.wxpay.api.WxpayRequest;
import com.wxpay.api.conf.WxpayConfigure;
import com.wxpay.api.internal.mapping.ApiField;
import com.wxpay.api.internal.util.RandomUtil;
import com.wxpay.api.response.WxpayUnifiedorderResponse;

/**
 * 商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再在APP里面调起支付。
 * 
 * @author Administrator
 *
 */
public class WxpayUnifiedorderRequest implements WxpayRequest<WxpayUnifiedorderResponse> {

	/**
	 * 接口链接
	 */
	public String getApiUrl() {
		return "https://api.mch.weixin.qq.com/pay/unifiedorder";
	}
	/**
	 * 是否需要证书	
	 */
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

	/** 必填:否
	 * 
	 * 签名类型
	 * 
	 * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
	 */
	@ApiField("sign_type")
	private String sign_type;

	/** 必填:是
	 * 
	 * 商品描述
	 * 
	 * 商品描述交易字段格式根据不同的应用场景按照以下格式：APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。
	 */
	@ApiField("body")
	private String body;

	/** 必填:否
	 * 
	 * 商品详情
	 * 
	 * 商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传
	 */
	@ApiField("detail")
	private String detail;

	/** 必填:否
	 * 
	 * 附加数据
	 * 
	 * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	 */
	@ApiField("attach")
	private String attach;

	/** 必填:是
	 * 
	 * 商户订单号
	 * 
	 * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
	 */
	@ApiField("out_trade_no")
	private String out_trade_no;

	/** 必填:否
	 * 
	 * 货币类型
	 * 
	 * 符合ISO 4217标准的三位字母代码，默认人民币：CNY
	 */
	@ApiField("fee_type")
	private String fee_type;

	/** 必填:是
	 * 
	 * 订单总金额，单位为分
	 */
	@ApiField("total_fee")
	private String total_fee;

	/** 必填:是
	 *
	 * 终端IP ：用户端实际ip
	 */
	@ApiField("spbill_create_ip")
	private String spbill_create_ip;

	/** 必填:否
	 *
	 * 交易起始时间
	 * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
	 */
	@ApiField("time_start")
	private String time_start;

	/** 必填:否
	 *
	 * 交易结束时间
	 * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
	 * 注意：最短失效时间间隔必须大于5分钟
	 */
	@ApiField("time_expire")
	private String time_expire;

	/** 必填:否
	 *
	 * 订单优惠标记
	 * 订单优惠标记，代金券或立减优惠功能的参数
	 */
	@ApiField("goods_tag")
	private String goods_tag;

	/** 必填:是
	 *
	 * 通知地址
	 * 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
	 */
	@ApiField("notify_url")
	private String notify_url;

	/** 必填:是
	 *
	 * 交易类型
	 * 支付类型
	 */
	@ApiField("trade_type")
	private String trade_type;

	/** 必填:否
	 *
	 * 指定支付方式
	 * no_credit--指定不能使用信用卡支付
	 */
	@ApiField("limit_pay")
	private String limit_pay;

	/** 必填:否
	 *
	 * 指定支付方式
	 * 该字段用于统一下单时上报场景信息，目前支持上报实际门店信息。
	 * {
	 *	 "store_id": "", //门店唯一标识，选填，String(32)
	 *	 "store_name":"”//门店名称，选填，String(64)
	 * }
	 */
	@ApiField("scene_info")
	private String scene_info;
	
	public Class<WxpayUnifiedorderResponse> getResponseClass() {
		return WxpayUnifiedorderResponse.class;
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

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getScene_info() {
		return scene_info;
	}

	public void setScene_info(String scene_info) {
		this.scene_info = scene_info;
	}
	
	public void setBizContent(Map<String, Object> bizContent){
		setBody(getContent("body",bizContent));
		setTotal_fee(getContent("total_fee",bizContent));
		setOut_trade_no(getContent("out_trade_no",bizContent));
		setSpbill_create_ip(getContent("spbill_create_ip",bizContent));
	}
	  
	public void setClientParams(Map<String, String> clientParams){
		setAppid((String)clientParams.get("appid"));
		setMch_id((String)clientParams.get("mch_id"));
		setNonce_str(RandomUtil.getRandomString());
		setSign_type((String)clientParams.get("sign_type"));
		setNotify_url(WxpayConfigure.getNOTIFY_URL());
	}
	
	private String getContent(String key,Map<String, Object> bizContent){
		if ((bizContent.containsKey(key)) && (bizContent.get(key) != null) && (!bizContent.get(key).toString().isEmpty())) {
			return bizContent.get(key).toString();
		}
		return "";
	}
}
