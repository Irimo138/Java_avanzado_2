package com.example.demo.connections;

import java.sql.*;
import java.util.ArrayList;

import com.example.demo.beans.Profesor;
public class DBconection {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private Connection c1;
	ArrayList<Profesor> listaProfesores;
	PreparedStatement stmt;
	
	
	public DBconection(String driverClassName, String url, String username, String password) {
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	
	
	try {
		Class.forName(driverClassName);
		this.c1 = DriverManager.getConnection(url, username, password);
		//System.err.println("realizado");
		
		}catch(Exception e) {
			e.getMessage();
			
		}
	}	
	public void close() throws SQLException {
		this.c1.close();
	}
	
	public ArrayList<Profesor> enseñarProfesores() throws SQLException{
		listaProfesores = new ArrayList<Profesor>();
		stmt = c1.prepareStatement("Select * from profesor");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Profesor addp = new Profesor();
			addp.setNombre(rs.getString(1));
			addp.setEdad(rs.getInt(2));

			listaProfesores.add(addp);
		}
		
		return listaProfesores;
		
	}
	
	
}