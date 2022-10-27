package com.zubiri.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBJugadorRepository;
import com.zubiri.app.Interfaces.DBPartidasRepository;
import com.zubiri.app.Interfaces.JugadorInterface;
import com.zubiri.app.beans.Jugador;
import com.zubiri.app.beans.Partida;
import com.zubiri.app.connections.DBManagerJugadores;

@Service
public class JugadorService implements JugadorInterface{

	private DBManagerJugadores dbManagerCreadores;
	
	public JugadorService(DBManagerJugadores dbManagerCreadores) {
		this.dbManagerCreadores = dbManagerCreadores;
	}
	
	@Autowired
	private DBJugadorRepository jpa;
	
	@Autowired
	private DBPartidasRepository partidasJPA;

	@Override
	public void insertarJugador(Jugador j) {
		jpa.save(j);
	}

	@Override
	public List<Jugador> mostrarJugador() {
		
		return jpa.findAll();
	}

	@Override
	public void eliminarJugador(int i) {
		jpa.deleteById(i);
	}

	@Override
	public void editarJugador(Jugador j) {
		
		jpa.save(j);
	}

	public Jugador buscarCreador(int jugador) {
		
		
		Jugador j =	jpa.findById(jugador).get();
				
		return j;
	}

	public void editarJuego(Jugador j) {
		dbManagerCreadores.editarJugador(j);
		
	}
	
	@Override
	public void ganaJuego(Partida p) {
		partidasJPA.save(p);
		
	}

}
