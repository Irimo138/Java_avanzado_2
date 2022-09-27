package com.zubiri.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

	@Configuration
	public class appConfig {
		@Bean
		public DataSource mysqlDataSource() {
	    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    	dataSource.setUrl("jdbc:mysql://localhost:3306/gestorJuegos");
	    	dataSource.setUsername("root");
	    	dataSource.setPassword("root");
	    	return dataSource;
		}

		
		
	}

