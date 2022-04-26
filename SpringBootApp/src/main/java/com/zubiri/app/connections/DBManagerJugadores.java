package com.zubiri.app.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.zubiri.app.beans.Jugador;
import com.zubiri.app.beans.Juego;

@Repository
public class DBManagerJugadores {

	private Connection c1;
	PreparedStatement stmt;

	public DBManagerJugadores(@Value("${conection.driverClassName}") String driverClassName,
			@Value("${conection.url}") String url, @Value("${conection.username}") String username,
			@Value("${conection.password}") String password) {

		try {
			Class.forName(driverClassName);
			c1 = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public ArrayList<Jugador> mostrarJugadores() {
		ArrayList<Jugador> lista = new ArrayList<Jugador>();
		try (
			PreparedStatement stmt = c1.prepareStatement("Select * from jugador");
			ResultSet rs = stmt.executeQuery();) { 
			while (rs.next()) {
				Jugador c = new Jugador();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setPartidasGanadas(rs.getInt(3));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public void insertarJugadorDb(Jugador c) {
		try (PreparedStatement stmt = c1.prepareStatement("insert into jugador (Nombre) values(?)");){			
			stmt.setString(1, c.getNombre());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Jugador buscarJugador(int idCreador) {
		
		Jugador c = new Jugador();
		try( 
			PreparedStatement stmt = c1.prepareStatement("Select * from jugador");
			ResultSet rs = stmt.executeQuery();){
			while (rs.next()) {
				if(rs.getInt(1) == idCreador) {
					c.setId(rs.getInt(1));
					c.setNombre(rs.getString(2));
					c.setPartidasGanadas(rs.getInt(3));
					return c;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public void editarJugador(Jugador j) {
		String query = "UPDATE jugador set nombre = ?, partidasGanadas= ? WHERE id = ?;";
		
		try(PreparedStatement stmt = c1.prepareStatement(query)){	
				stmt.setString(1, j.getNombre());			
				stmt.setInt(2, j.getPartidasGanadas());
				stmt.setInt(3, j.getId());
			
			int updated = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarJugador(int i) {
		try (PreparedStatement stmt = c1.prepareStatement("delete from jugador where id="+i);){			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void ganaJuego(int jugador) {
		String query = "UPDATE jugador set nombre = ?, partidasGanadas= ? WHERE id = ?;";
		
		Jugador j = buscarJugador(jugador);
		try(PreparedStatement stmt = c1.prepareStatement(query)){	
			int sum = j.getPartidasGanadas();
			sum++;
			System.err.println(sum);
			stmt.setString(1, j.getNombre());
			stmt.setInt(2, sum);
			stmt.setInt(3, j.getId());
		
		int updated = stmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
