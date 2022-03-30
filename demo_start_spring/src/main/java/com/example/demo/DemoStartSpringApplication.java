package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config/beans.xml")
//@ImportResource("classpath:config/Profesor.xml")
public class DemoStartSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStartSpringApplication.class, args);
	}
	

}
