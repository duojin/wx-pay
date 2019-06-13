package com.wxpay.api;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.wxpay.api.response.WxpayTradeQueryResponse;

public class TestWxPay {

	@Test
	public void TestTradeUqery() throws WxpayApiException{
		Map<String, Object> bizContent = new HashMap();
        bizContent.put("out_trade_no", "1000143002120190320347");
        WxpayTradeQueryResponse rsp = WxPay.queryTrade(bizContent);
        
        System.out.println(new Gson().toJson(rsp));
        
	}
	
	
}
