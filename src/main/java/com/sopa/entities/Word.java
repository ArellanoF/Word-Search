package com.sopa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "word")
public class Word {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idWord;
	private String word;
	
	public Word() {
		
	}

	public Word(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public int getIdWord() {
		return idWord;
	}

	public void setIdWord(int idWord) {
		this.idWord = idWord;
	}
	
	@Override
	public String toString() {
		return "Word [idWord=" + idWord + ", word=" + word + "]";
	}	
}