package com.sopa.app;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.GameDAO;
import com.sopa.DAO.WordDAO;
import com.sopa.DAO.mysql.SQLGameDAO;
import com.sopa.DAO.mysql.SQLWordDAO;
import com.sopa.models.Game;
import com.sopa.models.Word;

import connection.connectionSQL;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class SopaLetras1Application {

	public static void main(String[] args) throws SQLException, DAOException {
		SpringApplication.run(SopaLetras1Application.class, args);
		Connection conn = null;
		connectionSQL connection = new connectionSQL();
		try {
			conn = connection.connect();
			// -->Word Persistence
			WordDAO dao = new SQLWordDAO(conn);
			Word wordSave = new Word(3, "hola");
			// Insert 1 word
			dao.save(wordSave);	
			// List in console all the words of the table
			List<Word> words = dao.getAll();
			for(Word word1: words) {
				System.out.println(word1.toString());
			}
			// Delete all the words
			dao.deleteAll();

			//-->User Persistence
			// -->Game Persistence
			DateFormat dateFormat = new SimpleDateFormat("dd:mm:yyyy");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			GameDAO gameDao = new SQLGameDAO(conn);
			Game gameSave = new Game(3,date,55,120,"Paco");
			// Insert 1 game
			gameDao.save(gameSave);		
			// List in console all the games of the table
			List<Game> games = gameDao.getAll();
			for(Game game1: games) {
			System.out.println(game1.toString());
			}
				
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}


}
