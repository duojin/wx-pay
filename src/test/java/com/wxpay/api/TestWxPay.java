package com.wxpay.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.wxpay.api.response.WxpayTradeCloseResponse;
import com.wxpay.api.response.WxpayTradeRefundQueryResponse;
import com.wxpay.api.response.WxpayTradeRefundResponse;
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

	@Test
	public void TestTradeRefund() throws WxpayApiException{

		Map<String, Object> bizContent = new HashMap();
		bizContent.put("out_trade_no", "");
		bizContent.put("transaction_id", "4200000413201910242619955550");//二选一
		bizContent.put("out_refund_no", UUID.randomUUID().toString().replaceAll("-",""));
		String fee = "1";
		bizContent.put("total_fee", fee);
		bizContent.put("refund_fee",fee);
		WxPay.refund(bizContent);
	}

	@Test
	public void TestDownloadBills() throws WxpayApiException{
		Map<String, Object> bizContent = new HashMap();
		bizContent.put("bill_date", "20191014");
		WxPay.downloadBill(bizContent,"E:/b.txt");
	}

	@Test
	public void TestCloseTrade() throws WxpayApiException{
		Map<String, Object> bizContent = new HashMap();
		bizContent.put("out_trade_no", "1ac1248b550943d88130af0068723052");
		WxpayTradeCloseResponse rsp = 	WxPay.closeTrade(bizContent);
		System.out.println(new Gson().toJson(rsp));
	}


	@Test
	public void TestQueryRefundTrade() throws WxpayApiException{
		Map<String, Object> bizContent = new HashMap();
		bizContent.put("out_trade_no", "f00b0a9c24ce4dc3ac9bd3fda992999c");
		WxpayTradeRefundQueryResponse rsp = 	WxPay.queryRefundTrade(bizContent);
		System.out.println(new Gson().toJson(rsp));
	}

	@Test
	public void TestDownloadComment() throws WxpayApiException{
		Map<String, Object> bizContent = new HashMap();
		bizContent.put("begin_time", "20191014000000");
		bizContent.put("end_time", "20191015000000");
		WxPay.downloadComment(bizContent,"E:/d.txt");
	}

	@Test
	public void TestDownloadRundflow() throws WxpayApiException{
		Map<String, Object> bizContent = new HashMap();
		bizContent.put("bill_date", "20191014");
		WxPay.downloadFundflow(bizContent,"E:/c.txt");
	}
}
