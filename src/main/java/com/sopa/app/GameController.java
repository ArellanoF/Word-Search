package com.sopa.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.TransformerUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.GameDAO;
import com.sopa.DAO.UserDAO;
import com.sopa.DAO.WordDAO;
import com.sopa.DAO.mysql.SQLGameDAO;
import com.sopa.DAO.mysql.SQLUserDAO;
import com.sopa.DAO.mysql.SQLWordDAO;
import com.sopa.models.Game;
import com.sopa.models.User;
import com.sopa.models.Word;

import connection.connectionSQL;

@Controller
@RequestMapping("/game")
@SessionAttributes("game")

public class GameController {

	@RequestMapping(method = RequestMethod.GET)
    public void words(ModelMap model) throws SQLException, DAOException {         
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
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public RedirectView gameData(Game game) throws SQLException, DAOException { 
	  	
	  	Connection conn = null;
		connectionSQL connection = new connectionSQL();
		try {
			conn = connection.connect();
			WordDAO daoWord = new SQLWordDAO(conn);
			daoWord.deleteAll();
			UserDAO daoUser = new SQLUserDAO(conn);
			User userGame = daoUser.getLast();
			String nameGame = userGame.getUsername();
			daoUser.deleteAll();
		
			int duration = game.getDuration();
		
			int score = game.getScore();
	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");  
	   	    LocalDateTime now = LocalDateTime.now();  
	   	    String gameDate = dtf.format(now); 

	   	    Game lastGame = new Game(gameDate, duration, score, nameGame);

	   	    GameDAO daoGame = new SQLGameDAO(conn);
		    daoGame.save(lastGame);
		}
		finally{
			if(conn != null) {
				conn.close();
				return new RedirectView("/all-games");
			}
		}
		
		return null;  
    }
}
