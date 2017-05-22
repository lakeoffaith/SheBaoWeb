package com.ijoy.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxResult {
	private Map message=new HashMap();
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
		this.message.put(b?"success":"error", msgData);
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
	public Map getMessage() {
		return message;
	}
	public void setMessage(Map message) {
		this.message = message;
	}
	
}

