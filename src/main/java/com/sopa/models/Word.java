package com.sopa.models;

public class Word {
	
	private String word;
	
	

	public Word(String word) {
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
		return "Word [word=" + word + "]";
	}
	
}
