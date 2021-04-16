package com.sopa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sopa.entities.Word;

public interface WordRepository extends CrudRepository<Word, Integer> {

}