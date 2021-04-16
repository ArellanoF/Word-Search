package com.sopa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idGame;
	private String gameDate;
	private int duration;
	private int score;
	private String username;
	
	public Game() {
		
	}
	
	public Game(String gameDate, int duration, int score, String username) {
		super();
		this.gameDate = gameDate;
		this.duration = duration;
		this.score = score;
		this.username = username;
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Game [idGame=" + idGame + ", gameDate=" + gameDate + ", duration=" + duration + ", score=" + score
				+ ", username=" + username + "]";
	}
}