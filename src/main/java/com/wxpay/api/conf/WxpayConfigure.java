package com.wxpay.api.conf;

import java.util.ResourceBundle;

public class WxpayConfigure {

	static ResourceBundle resource = ResourceBundle.getBundle("wxpay");
	  private static String APP_ID = resource.getString("APP_ID");
	  private static String MCH_ID = resource.getString("MCH_ID");
	  private static String NOTIFY_URL = resource.getString("NOTIFY_URL");
	  private static String MCH_KEY = resource.getString("MCH_KEY");
	  private static String CERT_PATH = resource.getString("CERT_PATH");
	  private static String MP_APPID = resource.getString("MP_APPID");
	public static String getAPP_ID() {
		return APP_ID;
	}
	public static void setAPP_ID(String aPP_ID) {
		APP_ID = aPP_ID;
	}
	public static String getMCH_ID() {
		return MCH_ID;
	}
	public static void setMCH_ID(String mCH_ID) {
		MCH_ID = mCH_ID;
	}
	public static String getNOTIFY_URL() {
		return NOTIFY_URL;
	}
	public static void setNOTIFY_URL(String nOTIFY_URL) {
		NOTIFY_URL = nOTIFY_URL;
	}
	public static String getMCH_KEY() {
		return MCH_KEY;
	}
	public static void setMCH_KEY(String mCH_KEY) {
		MCH_KEY = mCH_KEY;
	}
	public static String getCERT_PATH() {
		return CERT_PATH;
	}
	public static void setCERT_PATH(String cERT_PATH) {
		CERT_PATH = cERT_PATH;
	}
	public static String getMP_APPID() {
		return MP_APPID;
	}
	public static void setMP_APPID(String mP_APPID) {
		MP_APPID = mP_APPID;
	}
	  

}

