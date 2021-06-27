package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@Column(length = 20)
	private String userName;
	@Column(length = 20)
	private String password;
	
	
	public Admin() {
		super();
	}
	
	public Admin(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}