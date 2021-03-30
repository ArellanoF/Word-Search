package com.sopa.app;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import com.sopa.DAO.DAOException;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class SopaLetras1Application {

	public static void main(String[] args) throws SQLException, DAOException {
		SpringApplication.run(SopaLetras1Application.class, args);
		
	}
}
