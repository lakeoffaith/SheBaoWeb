package com.shebao.minSys.util;

public class AjaxResult {
	private String message;
	private Boolean success;
	private Object data;
	private int total=0;
	
	
	public AjaxResult(Boolean success, Object data,int total) {
		super();
		this.success = success;
		this.data = data;
		this.total=total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
