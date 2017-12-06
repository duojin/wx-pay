package com.wxpay.api;

public class WxPaySettings {

    private String appId;
    private String mch_id;
    private String mchKey;
    private String certPath;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		if(appId==null||appId.isEmpty()){
			throw new RuntimeException("appId can not is empty!");
		}
		this.appId = appId;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		if(mch_id==null||mch_id.isEmpty()){
			throw new RuntimeException("mch_id can not is empty!");
		}
		this.mch_id = mch_id;
	}
	public String getMchKey() {
		return mchKey;
	}
	public void setMchKey(String mchKey) {
		if(mchKey==null||mchKey.isEmpty()){
			throw new RuntimeException("mchKey can not is empty!");
		}
		this.mchKey = mchKey;
	}
	public String getCertPath() {
		return certPath;
	}
	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}
	

	public WxPaySettings(String appId, String mch_id, String mchKey, String certPath){
		setAppId(appId);
		setMch_id(mch_id);
		setMchKey(mchKey);
		setCertPath(certPath);
	}
}
