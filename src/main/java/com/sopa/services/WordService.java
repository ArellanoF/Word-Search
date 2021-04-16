package com.sopa.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sopa.entities.Word;
import com.sopa.repositories.WordRepository;


@Component
public class WordService {
	
	@Autowired
	WordRepository wordRepo;
	
	protected EntityManager em;
	
	public WordService(EntityManager em) {
	    this.em = em;
	  }
	
	public List<Word> getAllWords(){
		List<Word> wordList = new ArrayList<>();
		wordRepo.findAll().forEach(wordList::add);
		return wordList;
	}
	
	public Word addWord(Word word) {
		word = wordRepo.save(word);
		return word;
	}

}