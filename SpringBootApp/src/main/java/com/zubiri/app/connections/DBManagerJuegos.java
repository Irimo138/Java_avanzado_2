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
				j.setPuntuacionMax(rs.getInt(3));
				j.setPartidasJugadas(rs.getInt(4));
				lista.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	public void editarJuego(Juego j) {
		String query = "UPDATE juegos set Nombre = ?, puntuacionMax = ?, partidasJugadas= ? WHERE id = ?;";
		
		try(
				PreparedStatement stmt = c1.prepareStatement(query);
				){
			stmt.setString(1, j.getNombre());
			stmt.setInt(2, j.getPuntuacionMax());
			stmt.setInt(3, j.getPartidasJugadas());
			stmt.setInt(4, j.getId());
			int updated = stmt.executeUpdate();	
			System.err.println(j.getNombre());
			System.err.println(j.getId());
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertarJuegoDB(Juego j) {
		try (PreparedStatement stmt = c1.prepareStatement("insert into juegos (Nombre, puntuacionMax, partidasJugadas) values(?,?,?)");){			
			stmt.setString(1, j.getNombre());
			stmt.setInt(2, j.getPuntuacionMax());
			stmt.setInt(3, j.getPartidasJugadas());
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
					j.setPartidasJugadas(rs.getInt(3));
					j.setPuntuacionMax(rs.getInt(4));
					return j;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
		
	}

	public ArrayList<Juego> buscarJuegoNombre(String nombre) {
		ArrayList<Juego> lista = new ArrayList<Juego>();
		try (
				PreparedStatement stmt = c1.prepareStatement("Select * from juegos where nombre like '%"+nombre+"%'");
				ResultSet rs = stmt.executeQuery();) { 
				while (rs.next()) {
					Juego j = new Juego();
					j.setId(rs.getInt(1));
					j.setNombre(rs.getString(2));
					j.setPuntuacionMax(rs.getInt(3));
					j.setPartidasJugadas(rs.getInt(4));
					lista.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lista;
	}

	public void anadirPartida(int juego, int p, int jugador_id) {
		Juego j = buscarJuego(juego);
		System.err.println(j.getNombre());
		System.err.println("Partidas: "+j.getPartidasJugadas());
		String query = "UPDATE juegos set  partidasJugadas= ?, puntuacionMax = ?, id_jugador =? WHERE id = ?;";
		
		try(PreparedStatement stmt = c1.prepareStatement(query);){
			stmt.setInt(1, j.getPartidasJugadas()+1);
			if(p > j.getPuntuacionMax() ) {
				stmt.setInt(2, p);
				stmt.setInt(3, jugador_id);
			}else {
				stmt.setInt(2, j.getPuntuacionMax());
				stmt.setObject(3, j.getJ());
			}
			stmt.setInt(4, j.getId());
			
			
			int updated = stmt.executeUpdate();	
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}