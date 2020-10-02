package com.umang.sporty.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue
	private int uid;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String address;
	private String mobile;
	
	public User() {
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", address=" + address + ", mobile=" + mobile + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
