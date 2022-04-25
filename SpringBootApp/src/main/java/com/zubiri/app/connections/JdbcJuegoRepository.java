package com.zubiri.app.connections;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zubiri.app.Interfaces.DBJuegosInterface;
import com.zubiri.app.beans.Juego;

@Repository
public class JdbcJuegoRepository implements DBJuegosInterface{
	
	private JdbcTemplate jdbc;
	
	@Inject
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<Juego> mostrarJuego() {
		
		return jdbc.query("select * from juegos", this::mapRowToJuego);
	}
	
	@Override
	public void editarJuego(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Juego buscarJuego(int i) {
		return jdbc.queryForObject("select * from juegos where id=?",this::mapRowToJuego, i);
	}
	
	
	private Juego mapRowToJuego(ResultSet rs, int rowNum) {
		Juego j = new Juego();
		try {
			j.setId(rs.getInt("id"));
			j.setNombre(rs.getString("nombre"));
			j.setPartidasJugadas(rs.getInt("partidasJugadas"));
			j.setPuntuacionMax(rs.getInt("puntuacionMax"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
		
	}
	
}
