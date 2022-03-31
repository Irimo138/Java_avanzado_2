package com.example.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.example.demo.controllers.ProfeController;

@SpringBootApplication
@ImportResource("classpath:config/beans.xml")
//ImportResource()
public class DemoStartSpringApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoStartSpringApplication.class, args);
		
		
	}
	
}
