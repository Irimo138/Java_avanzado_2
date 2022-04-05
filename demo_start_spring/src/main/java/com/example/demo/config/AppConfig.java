package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.beans.*;
import com.example.demo.connections.*;

@Configuration
public class AppConfig {
	
	@Bean
	public Profesor Profesor(@Value("${Profesor.nombre}") String nombre) {
		return new Profesor();
	}
	
	@Bean
	public DBconection DBconection(@Value("${conection.driverClassName}") String driverClassName,@Value("${conection.url}")String url, @Value("${conection.username}")String username,@Value("${conection.password}") String password) {
		
		return new DBconection(driverClassName, url, username, password);
	}
	
	
}
