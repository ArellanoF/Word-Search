package com.sopa.app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class SopaLetras1Application {

	public static void main(String[] args) {
		SpringApplication.run(SopaLetras1Application.class, args);
		
	}


}
