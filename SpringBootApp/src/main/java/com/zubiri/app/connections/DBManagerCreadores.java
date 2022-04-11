package com.zubiri.app.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.zubiri.app.beans.Creador;
import com.zubiri.app.beans.Juego;

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
	
	public ArrayList<Creador> mostrarCreadores() {
		ArrayList<Creador> lista = new ArrayList<Creador>();
		try (
			PreparedStatement stmt = c1.prepareStatement("Select * from creador");
			ResultSet rs = stmt.executeQuery();) { 
			while (rs.next()) {
				Creador c = new Creador();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setEmpresa(rs.getString(3));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
}
