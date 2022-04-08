package com.zubiri.app.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DBManagerCreadores {

	private Connection c1;
	PreparedStatement stmt;

	public DBManagerCreadores(@Value("${conection.driverClassName}") String driverClassName,
			@Value("${conection.url}") String url, @Value("${conection.username}") String username,
			@Value("${conection.password}") String password) {

		try {
			Class.forName(driverClassName);
			c1 = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
