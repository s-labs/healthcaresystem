package com.healthcare.form;

public class UserForm {
	
	String  role;
	long healthcenterId;
	String username;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getHealthcenterId() {
		return healthcenterId;
	}
	public void setHealthcenterId(long healthcenterId) {
		this.healthcenterId = healthcenterId;
	} 

}
