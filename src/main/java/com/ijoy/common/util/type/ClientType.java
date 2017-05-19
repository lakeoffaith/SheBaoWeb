package com.ijoy.common.util.type;

public enum ClientType {
	Phone(0),Web(1),;
	public  int code;

	private ClientType(int i){
		this.code=i;
	}

	public int getCode() {
		return code;
	}

	
}
