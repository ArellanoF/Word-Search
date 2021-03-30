package com.sopa.app;



import java.sql.Connection;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.sopa.DAO.DAOException;

//MODELS
import com.sopa.models.User;
import com.sopa.models.Word;
import com.sopa.models.Game;

//DAO
import com.sopa.DAO.GameDAO;
import com.sopa.DAO.WordDAO;
import com.sopa.DAO.UserDAO;

//SQL DAO
import com.sopa.DAO.mysql.SQLUserDAO;
import com.sopa.DAO.mysql.SQLGameDAO;
import com.sopa.DAO.mysql.SQLWordDAO;

//CONNECTION
import connection.connectionSQL;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class SopaLetras1Application {

	public static void main(String[] args) throws SQLException, DAOException {
		SpringApplication.run(SopaLetras1Application.class, args);
		
	}
}
