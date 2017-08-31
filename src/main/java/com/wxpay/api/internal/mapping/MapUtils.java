package com.wxpay.api.internal.mapping;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wxpay.api.response.WxpayUnifiedorderResponse;

public class MapUtils {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, String> getParamterMap(Object o) {
		Map<String, String> params = new HashMap();
		Class cls = o.getClass();
		List<Field> fields = new ArrayList<Field>() ;
		while (cls != null) {
			fields.addAll(Arrays.asList(cls .getDeclaredFields()));
			cls = cls.getSuperclass();
		}
		//Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			ApiField af = (ApiField) f.getAnnotation(ApiField.class);
			if (af != null) {
				try {
					Object value = f.get(o);
					if ((value != null) && (!String.valueOf(value).isEmpty())) {
						params.put(af.value(), String.valueOf(value));
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return params;
	}
	
	public static void main(String[] args){
		WxpayUnifiedorderResponse rsp = new WxpayUnifiedorderResponse();
		rsp.setAppid("wx628bb5f71f06cc1b");
		rsp.setReturn_code("aaa");
		Map<String, String> map = getParamterMap(rsp);
		System.out.println(map);
	}
}
