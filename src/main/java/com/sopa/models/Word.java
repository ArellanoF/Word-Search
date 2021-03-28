package com.sopa.models;

public class Word {
	
	private int idWord;
	private String word;
	
	

	public Word(int idWord, String word) {
		super();
		this.idWord = idWord;
		this.word = word;
	}

	public synchronized int getIdWord() {
		return idWord;
	}

	public synchronized void setIdWord(int idWord) {
		this.idWord = idWord;
	}

	public synchronized String getWord() {
		return word;
	}

	public synchronized void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "Word [idWord=" + idWord + ", word=" + word + "]";
	}
	
	
}
