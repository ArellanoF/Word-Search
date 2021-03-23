package com.sopa.models;

import java.time.LocalDate;

public class Game {
	
	private int idGame;
	private LocalDate date;
	private int duration;
	private int score;
	private User user;

	

	public Game(int idGame, LocalDate date,int duration,  int score, User user) {
		super();
		this.idGame = idGame;
		this.date = date;
		this.duration = duration;
		this.score = score;
		this.user = user;
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

	public synchronized LocalDate getDate() {
		return date;
	}

	public synchronized void setDate(LocalDate date) {
		this.date = date;
	}

	public synchronized User getUser() {
		return user;
	}

	public synchronized void setUser(User user) {
		this.user = user;
	}

	public synchronized int getDuration() {
		return duration;
	}

	public synchronized void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Game [idGame=" + idGame + ", date=" + date + ", duration=" + duration + ", score=" + score + ", user="
				+ user + "]";
	}



	
}
