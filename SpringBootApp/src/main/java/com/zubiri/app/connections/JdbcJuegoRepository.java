package com.zubiri.app.connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.Id;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.zubiri.app.Interfaces.DBJuegosInterface;
import com.zubiri.app.Interfaces.JuegosInterface;
import com.zubiri.app.beans.Juego;

@Repository
public class JdbcJuegoRepository{
	
	private JdbcTemplate jdbc;
	
	@Inject
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	public Iterable<Juego> mostrarJuego() {
		
		return jdbc.query("select * from juegos", this::mapRowToJuego);
	}

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

	public boolean insertarJuego(Juego j) {
		jdbc.update(
				"insert into Juego (id, nombre, puntuacionMax, partidasJugadas) values (?, ?, ?,?)",
				j.getId(),
				j.getNombre(),
				j.getPuntuacionMax(),
				j.getPartidasJugadas());
				return true;

	}

	
}
