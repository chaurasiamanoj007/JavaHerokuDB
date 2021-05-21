package com.java.github.model;

public class User {
	int userId;
	String userName;
	String status;
	
	public User(int userId, String userName, String status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.status = status;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}