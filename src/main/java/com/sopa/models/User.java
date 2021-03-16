package com.sopa.models;

import java.util.List;

public class User {
	private int idUsername;
	private String username;
	private List<Game> games;
	
	
	
	public User(int idUsername, String username, List<Game> games) {
		super();
		this.idUsername = idUsername;
		this.username = username;
		this.games = games;
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

	public synchronized List<Game> getGames() {
		return games;
	}

	public synchronized void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "User [idUsername=" + idUsername + ", username=" + username + ", games=" + games + "]";
	}




	
}
