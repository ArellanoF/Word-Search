package com.sopa.DAO;

import java.util.List;

public interface DAO<T>{
	
	T get(int id) throws DAOException;

    List<T> getAll() throws DAOException;

    void save(T t) throws DAOException;

    void update(T t) throws DAOException;

    void delete(T t) throws DAOException;
    
    void deleteAll() throws DAOException;
    
    T getLast() throws DAOException;
    
}
