package com.sopa.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sopa.entities.Game;
import com.sopa.repositories.UserRepository;
import com.sopa.repositories.WordRepository;
import com.sopa.services.GameService;
import com.sopa.services.UserService;
import com.sopa.services.WordService;

@Controller
@RequestMapping("/all-games")
@SessionAttributes("allgames")

public class PointsController {
	
	@Autowired
	WordRepository wordRepo;
	@Autowired
	WordService wordServ;
	@Autowired
	UserRepository userRepo;
	@Autowired
	UserService userServ;
	@Autowired
	GameService gameServ;
	      
	@RequestMapping(method = RequestMethod.GET)
    public void games(ModelMap model) throws SQLException {         
		List<Game> lista = gameServ.getAllGames();	
		model.addAttribute("scores", lista);	
	 
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public RedirectView RedirectView (ModelMap model) throws SQLException { 
		return new RedirectView("/new-game");
    }

}