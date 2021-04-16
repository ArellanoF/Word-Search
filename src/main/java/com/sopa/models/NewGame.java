package com.sopa.models;

public class NewGame {
	public String user;
	public String word1;
	public String word2;
	public String word3;
	public String word4;
	public String word5;
	
	public NewGame() {
		
	}
	
	public NewGame(String user, String word1, String word2, String word3, String word4, String word5) {
		this.user = user;
		this.word1 = word1;
		this.word2 = word2;
		this.word3 = word3;
		this.word4 = word4;
		this.word5 = word5;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getWord1() {
		return word1;
	}
	public void setWord1(String word1) {
		this.word1 = word1;
	}
	public String getWord2() {
		return word2;
	}
	public void setWord2(String word2) {
		this.word2 = word2;
	}
	public String getWord3() {
		return word3;
	}
	public void setWord3(String word3) {
		this.word3 = word3;
	}
	public String getWord4() {
		return word4;
	}
	public void setWord4(String word4) {
		this.word4 = word4;
	}
	public String getWord5() {
		return word5;
	}
	public void setWord5(String word5) {
		this.word5 = word5;
	}

}