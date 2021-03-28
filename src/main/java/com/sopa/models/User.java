package com.sopa.models;


public class User {
	private int idUsername;
	private String username;
		
	
	public User(int idUsername, String username) {
		super();
		this.idUsername = idUsername;
		this.username = username;
	}

	public synchronized int getIdUsername() {
		return idUsername;
	}

	public synchronized void setIdUsername(int idUsername) {
		this.idUsername = idUsername;
	}


	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	
	@Override
	public String toString() {
		return "User [idUsername=" + idUsername + ", username=" + username + "]";
	}




	
}
