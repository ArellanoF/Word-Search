package com.sopa.app;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"boot.registration"} , exclude = JpaRepositoriesAutoConfiguration.class)
@ComponentScan("com.sopa")
@EnableJpaRepositories("com.sopa.repositories")
@EntityScan("com.sopa.entities")
public class SopaLetras1Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SopaLetras1Application.class, args);
		
	}
}
