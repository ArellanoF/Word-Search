package com.sopa.clases;

public class word {
	
	private int idWord;

	private String word;
	

	public word(String word, int idWord) {
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
		return "word [idWord=" + idWord + ", word=" + word + "]";
	}



	
	
	
}
