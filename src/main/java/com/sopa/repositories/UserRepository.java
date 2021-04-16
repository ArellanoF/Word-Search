package com.sopa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sopa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}