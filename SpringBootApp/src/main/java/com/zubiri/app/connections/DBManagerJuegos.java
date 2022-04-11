package com.zubiri.app.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.zubiri.app.beans.Juego;

@Repository
public class DBManagerJuegos {

	private Connection c1;
	
	public DBManagerJuegos(@Value("${conection.driverClassName}") String driverClassName,
			@Value("${conection.url}") String url, @Value("${conection.username}") String username,
			@Value("${conection.password}") String password) {

		try {
			//Class.forName(driverClassName);
			c1 = DriverManager.getConnection(url, username, password);
			System.err.println("Conexión creada.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Juego> mostrarJuegos() {
		ArrayList<Juego> lista = new ArrayList<Juego>();
		try (
			PreparedStatement stmt = c1.prepareStatement("Select * from juegos");
			ResultSet rs = stmt.executeQuery();) { 
			while (rs.next()) {
				Juego j = new Juego();
				j.setId(rs.getInt(1));
				j.setNombre(rs.getString(2));
				j.setGenero(rs.getString(3));
				j.setPrecio(rs.getInt(4));
				j.setCreador_id(rs.getInt(5));
				lista.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	public void editarJuego(Juego j) {
		String query = "update juegos set Nombre = "+j.getNombre()+", Genero = "+j.getGenero()+", precio = "+ j.getGenero()+", creador_id = "+ j.getCreador_id()+" where id = "+j.getId()+";";
		try(
				PreparedStatement stmt = c1.prepareStatement(query);
				){
			int updated = stmt.executeUpdate();	
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertarJuegoDB(Juego j) {
		try (PreparedStatement stmt = c1.prepareStatement("insert into juegos (Nombre, Genero, Precio) values(?,?,?)");){			
			stmt.setString(1, j.getNombre());
			stmt.setString(2, j.getGenero());
			stmt.setInt(3, j.getPrecio());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrarJuego(int i) {
		try (PreparedStatement stmt = c1.prepareStatement("delete from juegos where id="+i);){			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void close() throws SQLException {
		this.c1.close();
	}

	public Juego buscarJuego(int i) {	
		Juego j = new Juego();
		try( 
			PreparedStatement stmt = c1.prepareStatement("Select * from juegos");
			ResultSet rs = stmt.executeQuery();){
			while (rs.next()) {
				if(rs.getInt(1) == i) {
					j.setId(rs.getInt(1));
					j.setNombre(rs.getString(2));
					j.setGenero(rs.getString(3));
					j.setPrecio(rs.getInt(4));
					j.setCreador_id(rs.getInt(5));
					return j;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
		
	}
}