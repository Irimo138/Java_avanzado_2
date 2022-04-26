package com.zubiri.app.connections;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class jdbcJugadorRepository {
	private SimpleJdbcInsert jugadorInserter;
	private SimpleJdbcInsert juegoJugadorInserter;
	private ObjectMapper objectMapper;
	private JdbcTemplate jdbc;
	
	@Inject
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	public jdbcJugadorRepository(JdbcTemplate jdbc) {
		this.jugadorInserter = new SimpleJdbcInsert(jdbc)
							.withTableName("jugador")
							.usingGeneratedKeyColumns("id");
		
		this.juegoJugadorInserter = new SimpleJdbcInsert(jdbc)
							.withTableName("juegos");
		
		this.objectMapper = new ObjectMapper();
	}
}
