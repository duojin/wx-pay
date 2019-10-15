package com.wxpay.api;

import java.util.Map;

/**
 * 请求接口。
 */
public interface WxpayRequest<T extends WxpayResponse> {

	/**
	 * 获取请求的Url
	 * @return
	 */
	public abstract String getApiUrl();
	
    /**
     * 得到当前API的响应结果类型
     * 
     * @return 响应类型
     */
    public Class<T> getResponseClass();

    /**
     * 判断是否需要证书
     * 
     * @return
     */
    public boolean isNeedCert();

    /**
     * 签名类型
     *
     * @return
     */
    public default String getSign_type(){
        return WxpayConstants.SIGN_TYPE_MD5;
    }
    
    /**
     * 设置公共参数
     * @param paramMap
     */
    public abstract void setClientParams(Map<String, String> paramMap);

}
