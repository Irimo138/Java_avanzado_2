package com.zubiri.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBJugadorRepository;
import com.zubiri.app.Interfaces.JugadorInterface;
import com.zubiri.app.beans.Jugador;
import com.zubiri.app.connections.DBManagerJugadores;

@Service
public class JugadorService implements JugadorInterface{

	private DBManagerJugadores dbManagerCreadores;
	
	public JugadorService(DBManagerJugadores dbManagerCreadores) {
		this.dbManagerCreadores = dbManagerCreadores;
	}
	
	@Autowired
	private DBJugadorRepository jpa;

	@Override
	public boolean insertarJugador(Jugador j) {
		jpa.save(j);
		return false;
	}

	@Override
	public ArrayList<Jugador> mostrarJugador() {
		
		return dbManagerCreadores.mostrarJugadores();
	}

	@Override
	public void eliminarJugador(int i) {
		dbManagerCreadores.eliminarJugador(i);
	}

	@Override
	public void editarJugador(Jugador c) {
		
		dbManagerCreadores.editarJugador(c);
	}

	public Jugador buscarCreador(int idCreador) {
		
		return dbManagerCreadores.buscarJugador(idCreador);
	}

	public void editarJuego(Jugador j) {
		dbManagerCreadores.editarJugador(j);
		
	}
	@Override
	public void ganaJuego(int jugador) {
		dbManagerCreadores.ganaJuego(jugador);
		
	}

}
