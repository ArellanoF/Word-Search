package com.sopa.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.GameDAO;
import com.sopa.DAO.mysql.SQLGameDAO;
import com.sopa.models.Game;


import connection.connectionSQL;


@Controller
@RequestMapping("/all-games")
@SessionAttributes("allgames")

public class PointsController {
	      
	@RequestMapping(method = RequestMethod.GET)
    public void games(ModelMap model) throws SQLException, DAOException {         
	  Connection conn = null;
		connectionSQL connection = new connectionSQL();
		try {
			conn = connection.connect();
			GameDAO daoGame = new SQLGameDAO(conn);
			List<Game> lista = daoGame.getAll();
			for(Game game : lista ) {
	            System.out.println(game.getScore() + "" + game.getDuration());
	        }
			
			model.addAttribute("scores", lista);	
		}
		finally{
			if(conn != null) {
				conn.close();
			}
		} 
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public RedirectView RedirectView (ModelMap model) throws SQLException, DAOException { 
		return new RedirectView("/new-game");
    }

}