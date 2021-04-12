package com.sopa.models;


public class Game {
	
	private String gameDate;
	private int duration;
	private int score;
	private String username;


	public Game(String gameDate, int duration, int score, String username) {

		super();
		this.gameDate = gameDate;
		this.duration = duration;
		this.score = score;
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public synchronized int getDuration() {
		return duration;
	}

	public synchronized void setDuration(int duration) {
		this.duration = duration;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Game [date=" + gameDate + ", duration=" + duration + ", score=" + score + ", username=" + username + "]";
	}

}