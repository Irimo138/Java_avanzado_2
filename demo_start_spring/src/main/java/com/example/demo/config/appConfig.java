package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.beans.*;

@Configuration
public class appConfig {
	
	@Bean
	public Profesor Profesor() {
		return new Profesor();
	}
	
	@Bean
	public ProfesorMas ProfesorMas() {
		return new ProfesorMas();
	}
	
}
