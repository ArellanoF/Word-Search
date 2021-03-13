package com.sopa.clases;

public class user {
	private int idUsername;
	private String username;
	private String password;
	
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

	public synchronized String getPassword() {
		return password;
	}

	public synchronized void setPassword(String password) {
		this.password = password;
	}

	public user(int idUsername, String username, String password) {
		super();
		this.idUsername = idUsername;
		this.username = username;
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "user [idUsername=" + idUsername + ", username=" + username + ", password=" + password + "]";
	}
	
}
