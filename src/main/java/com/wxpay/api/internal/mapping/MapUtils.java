package com.wxpay.api.internal.mapping;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, String> getParamterMap(Object o) {
		Map<String, String> params = new HashMap();
		Class cls = o.getClass();
		Field[] fields = cls.getDeclaredFields();
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
}
