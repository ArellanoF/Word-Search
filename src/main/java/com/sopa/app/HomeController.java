package com.sopa.app;





import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;




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
	    public String game() {
			return "game";
	    } 
	  @RequestMapping("/all-games")
	    public String allGames() {         
	        return "all-games";
	    }

}