package com.java.di13;

public class AdminImpl implements Admin{
	private String id,pw,sub_id,sub_pw;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}

	public void setSub_pw(String sub_pw) {
		this.sub_pw = sub_pw;
	}

	@Override
	public String toDisp() {
		return "id : " + id + "\t  pw : " + pw + "\nsub_id : " + sub_id + "\t sub_pw : " + sub_pw;
	}
	
}
