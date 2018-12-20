package com.lc.web.util;

import java.util.HashMap;
import java.util.Map;

public class JsonMsg {

	private int code;
	private int count;
	private String msg;
	private final Map<String, Object> extend = new HashMap<String, Object>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public static JsonMsg success() {
		JsonMsg result = new JsonMsg();
		result.setCode(100);
		result.setCount(100);
		result.setMsg("处理成功！");
		return result;

	}

	public static JsonMsg fail() {
		JsonMsg result = new JsonMsg();
		result.setCode(200);

		result.setMsg("处理失败！");
		return result;

	}

	public JsonMsg add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
