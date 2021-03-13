package com.sopa.clases;

public class game {
	private int idGame;
	private int score;
	private int times;
	
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

	public synchronized int getTimes() {
		return times;
	}

	public synchronized void setTimes(int times) {
		this.times = times;
	}

	public game(int idGame, int score, int times) {
		super();
		this.idGame = idGame;
		this.score = score;
		this.times = times;
	}

	@Override
	public String toString() {
		return "game [idGame=" + idGame + ", score=" + score + ", times=" + times + "]";
	}
	
	
}
