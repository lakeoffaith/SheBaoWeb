package com.ijoy.common.util;

public class Msg {
	private String key;
	private String value;
	private Object data;

	public Msg() {
		super();
	}

	public Msg(String string, Object msgData) {
		this.key = string;
		this.data = msgData;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
