package com.example.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.controllers.ProfeController;

@SpringBootApplication
@PropertySource("classpath:application.properties")
//ImportResource()
public class DemoStartSpringApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoStartSpringApplication.class, args);
		
	}
	
}
