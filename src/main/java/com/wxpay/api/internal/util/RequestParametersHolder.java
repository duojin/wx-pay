package com.wxpay.api.internal.util;

import java.util.Map;
import java.util.TreeMap;

public class RequestParametersHolder {
	private WxpayHashMap Params;

	public WxpayHashMap getParams() {
		return Params;
	}

	public void setParams(WxpayHashMap params) {
		Params = params;
	}

	public Map<String, String> getSortedParams() {
		Map<String, String> sortedParams = new TreeMap<String, String>();
	    if ((Params != null) && (Params.size() > 0)) {
	      sortedParams.putAll(Params);
	    }
	    return sortedParams;
	}
}
