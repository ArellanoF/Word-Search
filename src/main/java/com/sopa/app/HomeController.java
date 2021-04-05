package com.sopa.app;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.TransformerUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	  @RequestMapping("/game")
	    public String Game(ModelMap model) throws SQLException, DAOException {         
	  	  Connection conn = null;
			connectionSQL connection = new connectionSQL();
			try {
				conn = connection.connect();
				WordDAO daoWord = new SQLWordDAO(conn);
				List<Word> lista = daoWord.getAll();
				Collection<String> words = CollectionUtils.collect(lista, TransformerUtils.invokerTransformer("getWord"));
				for(String string : words ) {
		            System.out.println(string);
		        }
				String palabras[] = (String[]) words.toArray(new String[0]);
				model.addAttribute("palabras", palabras);	
			}
			finally{
				if(conn != null) {
					conn.close();
				}
			} 
			return "game";
	    } 
	  @RequestMapping("/all-games")
	    public String allGames() {         
	        return "all-games";
	    }

}