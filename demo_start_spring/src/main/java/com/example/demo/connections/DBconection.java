package com.example.demo.connections;

import java.sql.*;
public class DBconection {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private Connection c1;
	
	
	public DBconection(String driverClassName, String url, String username, String password) {
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	
	
	try {
		Class.forName(driverClassName);
		this.c1 = DriverManager.getConnection(url, username, password);
		System.err.println("realizado");
		
		}catch(Exception e) {
			e.getMessage();
			
		}
	}	
	public void close() throws SQLException {
		this.c1.close();
	}
	
}