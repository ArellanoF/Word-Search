package com.sopa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sopa.entities.Game;

public interface GameRepository extends CrudRepository<Game, Integer>{

}