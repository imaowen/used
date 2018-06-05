package com.imao.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
/**
 * 实体类和json转换
 */
public class JsonUtil {

	static Gson gson = new Gson();
	static Gson gson1 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation() // <---
			.create();

	public static String objectToJson(Object obj) {
		if (obj == null) {
			return null;
		}
		String jsonString = gson.toJson(obj);
		return jsonString;
	}

	public static Object JsonToObject(String jsonString, Class<?> objClass) throws JsonSyntaxException {
		if (jsonString == null || "".equals(jsonString)) {
			return null;
		}
		return gson.fromJson(jsonString, objClass);
	}

}
