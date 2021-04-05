package com.sopa.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.WordDAO;
import com.sopa.DAO.mysql.SQLWordDAO;
import com.sopa.models.Word;

import connection.connectionSQL;

public class GameController {

	@RequestMapping(value = "/game", method = RequestMethod.GET)
    public String words(ModelMap model) throws SQLException, DAOException {         
	  Connection conn = null;
		connectionSQL connection = new connectionSQL();
		try {
			conn = connection.connect();
			WordDAO daoWord = new SQLWordDAO(conn);
			List<Word> palabras = daoWord.getAll();
			for(Word word : palabras) {
	            System.out.println(word.getWord());
	        }
			model.addAttribute("palabras", palabras);	
		}
		finally{
			if(conn != null) {
				conn.close();
			}
		} 
		return "/game";
    }
}
