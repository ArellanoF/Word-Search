package com.sopa.controllers;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.TransformerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sopa.entities.Game;
import com.sopa.entities.User;
import com.sopa.entities.Word;
import com.sopa.repositories.UserRepository;
import com.sopa.repositories.WordRepository;
import com.sopa.services.GameService;
import com.sopa.services.UserService;
import com.sopa.services.WordService;

@Controller
@RequestMapping("/game")
@SessionAttributes("game")

public class GameController {

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
    public void words(ModelMap model) throws SQLException{         
		List<Word> lista = wordServ.getAllWords();
		for (Word word : lista) {
            System.out.println(word.getWord());
        }
		Collection<String> words = CollectionUtils.collect(lista, TransformerUtils.invokerTransformer("getWord"));
		String palabras[] = (String[]) words.toArray(new String[0]);
		model.addAttribute("palabras", palabras);	
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public RedirectView gameData(Game game) throws SQLException { 
		wordRepo.deleteAll();
		User userGame = userServ.lastUser();
		String nameGame = userGame.getUsername();
		userRepo.deleteAll();
		
		int duration = game.getDuration();
		int score = game.getScore();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");  
	   	LocalDateTime now = LocalDateTime.now();  
	   	String gameDate = dtf.format(now); 

	   	Game lastGame = new Game(gameDate, duration, score, nameGame);
	   	gameServ.addGame(lastGame);
		
		return new RedirectView("/all-games");
			
	}	
}