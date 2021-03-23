package com.sopa.app;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.WordDAO;
import com.sopa.DAO.mysql.SQLWordDAO;
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
			WordDAO dao = new SQLWordDAO(conn);
			Word wordSave = new Word(3, "hola");
			
			//Word Persistence
			dao.save(wordSave);	
			List<Word> words = dao.getAll();
			for(Word word1: words) {
				System.out.println(word1.toString());
			}
						
				
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}


}
