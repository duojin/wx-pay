package com.wxpay.api;

import java.io.Serializable;

import com.wxpay.api.internal.mapping.ApiField;

/**
 * API基础响应信息。
 * @author Administrator
 *
 */
public abstract class WxpayResponse implements Serializable {

    private static final long   serialVersionUID = 5014379068811962022L;

    @ApiField("return_code")
    private String              return_code;

    @ApiField("return_msg")
    private String              return_msg;
    
    public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public boolean isSuccess() {
        return WxpayConstants.SUCCESS.equals(return_code);
    }
    
    public boolean isNeedVerifySign() {
    	return true;
    }
}
