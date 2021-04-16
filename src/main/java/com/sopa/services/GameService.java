package com.sopa.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.sopa.entities.Game;
import com.sopa.repositories.GameRepository;


@Component
public class GameService {

	@Autowired
	GameRepository gameRepo;
	
	protected EntityManager em;
	
	public GameService(EntityManager em) {
	    this.em = em;
	  }
	
	public List<Game> getAllGames(){
		List<Game> gameList = new ArrayList<>();
		gameRepo.findAll().forEach(gameList::add);
		return gameList;
	}
	
	public Game addGame(Game game) {
		game = gameRepo.save(game);
		return game;
	}
}
