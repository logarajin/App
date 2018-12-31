package com.springboot.microservices.stocktradingapp.domain;

import java.io.Serializable;

public class User implements Serializable {
	
		
	private Long id;
	private String userId;
	private String email;
	private String password;
	
	public User() {
	
	}

	public User(Long id, String userId, String password, String email) {
	
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.email = email;
	}

		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", email=" + email + "]";
	}
	
	
}