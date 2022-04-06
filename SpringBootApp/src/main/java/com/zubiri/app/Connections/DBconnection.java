package com.zubiri.app.Connections;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.zubiri.app.beans.Juego;

@Repository
public class DBconnection {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private Connection c1;
	PreparedStatement stmt;
	
	
	public DBconnection(@Value("${conection.driverClassName}") String driverClassName,@Value("${conection.url}")String url, @Value("${conection.username}")String username,@Value("${conection.password}") String password) {
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	
	
	try {
		Class.forName(driverClassName);
		c1 = DriverManager.getConnection(url, username, password);
		
		}catch(Exception e) {
			e.getMessage();
			
		}
	}	
	
	public ArrayList<Juego> mostrarJuegos() throws SQLException{
		ArrayList<Juego> lista= new ArrayList<Juego>();
		stmt = c1.prepareStatement("Select * from juegos");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Juego j = new Juego();
			j.setNombre(rs.getString(2));
			j.setGenero(rs.getString(3));
			j.setPrecio(rs.getInt(4));
			j.setCreador_id(rs.getInt(5));
			lista.add(j);
		}
		
		return lista;
		
	}
	public void close() throws SQLException {
		this.c1.close();
	}
	
}