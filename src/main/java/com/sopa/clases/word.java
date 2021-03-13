package com.sopa.clases;

public class word {
	private String word;

	public word(String word) {
		super();
		this.word = word;
	}

	public synchronized String getWord() {
		return word;
	}

	public synchronized void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "word [word=" + word + "]";
	}
	
	
	
}
