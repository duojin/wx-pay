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
    private String              returnCode;

    @ApiField("return_msg")
    private String              returnMsg;

    public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

    public boolean isSuccess() {
        return WxpayConstants.SUCCESS.equals(returnCode);
    }
    
    public boolean isNeedVerifySign() {
    	return true;
    }
}
