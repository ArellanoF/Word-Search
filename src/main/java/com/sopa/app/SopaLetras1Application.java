package com.sopa.app;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.UserDAO;
import com.sopa.DAO.WordDAO;
import com.sopa.DAO.mysql.SQLUserDAO;
import com.sopa.DAO.mysql.SQLWordDAO;
import com.sopa.models.User;
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
			
			//User persistence
			UserDAO daoUser = new SQLUserDAO(conn);
			User userSave = new User(3,"pep");
			daoUser.save(userSave);
			List<User> users = daoUser.getAll();
			for(User user1: users) {
				System.out.println(user1.toString());
			}
			

		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
