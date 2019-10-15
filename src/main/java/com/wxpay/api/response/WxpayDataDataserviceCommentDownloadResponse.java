package com.wxpay.api.response;

import com.wxpay.api.WxpayResponse;
import com.wxpay.api.internal.mapping.ApiField;

/**
 * 
 * @author Administrator
 *
 */
public class WxpayDataDataserviceCommentDownloadResponse extends WxpayResponse {

	private static final long serialVersionUID = 1415426866651155291L;

	/** 
	 * 业务结果
	 * SUCCESS/FAIL
	 */
	@ApiField("result_code")
	private String result_code;

	/** 
	 * 错误代码
	 * 错误码信息
	 */
	@ApiField("err_code")
	private String err_code;


	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	@Override
	public boolean isNeedVerifySign(){
		return false;
	}
}
