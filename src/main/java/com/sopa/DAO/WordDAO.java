package com.sopa.DAO;

import com.sopa.models.Word;

public interface WordDAO extends DAO<Word>{
	  void deleteAll() throws DAOException;
}
