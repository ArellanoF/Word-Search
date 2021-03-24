package com.sopa.models;

import java.util.Date;


public class Game {
	
	private int idGame;
	private Date date;
	private int duration;
	private int score;
	private String username;

	public Game(int idGame, Date date,int duration,  int score, String username) {
		super();
		this.idGame = idGame;
		this.date = date;
		this.duration = duration;
		this.score = score;
		this.username = username;
	}

	public synchronized int getIdGame() {
		return idGame;
	}

	public synchronized void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public synchronized int getScore() {
		return score;
	}

	public synchronized void setScore(int score) {
		this.score = score;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		return "Game [idGame=" + idGame + ", date=" + date + ", duration=" + duration + ", score=" + score
				+ ", username=" + username + "]";
	}

	
}
