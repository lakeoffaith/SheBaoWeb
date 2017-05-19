package com.ijoy.common.util;

import java.util.ArrayList;
import java.util.List;

public class AjaxResult {
	private List<Msg> message=new ArrayList();
	private Boolean success;
	private List data=new ArrayList();
	private int total=0;
	
	
	public AjaxResult(Boolean success, List data,int total) {
		super();
		this.success = success;
		this.data = data;
		this.total=total;
	}
	public AjaxResult(boolean b, List result) {
		this.success=b;
		this.data=result;
	}
	public AjaxResult(boolean b, Object msgData) {
		this.success=b;
		this.message.add(new Msg(b?"success":"error",msgData));
	
	}
	
	public List getMessage() {
		return message;
	}
	public void setMessage(List message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
	class Msg{
		private String key;
		private String value;
		private Object data;
		
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public Msg(String key, Object data) {
			super();
			this.key = key;
			this.data=data;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return key=="success"?"操作成功":"操作失败";
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}

