package com.sopa.app;


import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.UserDAO;
import com.sopa.DAO.WordDAO;
import com.sopa.DAO.mysql.SQLUserDAO;
import com.sopa.DAO.mysql.SQLWordDAO;
import com.sopa.models.NewGame;
import com.sopa.models.User;
import com.sopa.models.Word;

import connection.connectionSQL;


@Controller
public class HomeController {

	 @RequestMapping("/")
	    public String defaultHome() {         
	        return "login";
	    }
	 @RequestMapping("/login")
	    public String login() {         
	        return "login";
	    }
	 @RequestMapping("/denied")
	    public String denied() {         
	        return "error";
	    }
	  @RequestMapping("/new-game")
	    public String newGame() {         
	        return "new-game";
	    }
	  @RequestMapping(value = "/new-game", method = RequestMethod.POST)
	    public void gameData(NewGame newGame) throws SQLException, DAOException {         
		  System.out.println("Username= " + newGame.getUser());
		  User newUser = new User(newGame.getUser());
		  Word word1 = new Word(newGame.getWord1());
		  Word word2 = new Word(newGame.getWord2());
		  Word word3 = new Word(newGame.getWord3());
		  Word word4 = new Word(newGame.getWord4());
		  Word word5 = new Word(newGame.getWord5());
		  Connection conn = null;
			connectionSQL connection = new connectionSQL();
			try {
				conn = connection.connect();
				UserDAO daoUser = new SQLUserDAO(conn);
				daoUser.save(newUser);
				WordDAO daoWord = new SQLWordDAO(conn);
				if(word1.getWord() != "") {
					daoWord.save(word1);
				}
				if(word2.getWord() != "") {
					daoWord.save(word2);
				}
				if(word3.getWord() != "") {
					daoWord.save(word3);
				}
				if(word4.getWord() != "") {
					daoWord.save(word4);
				}
				if(word5.getWord() != "") {
					daoWord.save(word5);
				}
			}
			finally{
				if(conn != null) {
					conn.close();
				}
			}
		 
		  
	    }
	  @RequestMapping("/game")
	    public String game() {         
	        return "game";
	    }
	  @RequestMapping("/all-games")
	    public String allGames() {         
	        return "all-games";
	    }

}