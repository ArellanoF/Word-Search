package com.sopa.models;


public class User {

	private String username;
		
	
	public User(String username) {
		super();
		this.username = username;
	}


	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
}
