package com.zubiri.app.services;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zubiri.app.Interfaces.DBJuegosRepository;
import com.zubiri.app.Interfaces.JuegosInterface;
import com.zubiri.app.beans.Juego;
import com.zubiri.app.connections.DBManagerJuegos;

@Service 
public class JuegoService implements JuegosInterface{
	
	private DBManagerJuegos jdbc;
	
	public JuegoService (DBManagerJuegos jdbc) {
		this.jdbc = jdbc;
		System.err.println("JuegoService creado");
	}
	@Autowired
	DBJuegosRepository jdbc2;

	@Override
	public boolean insertarJuego(Juego j) {
		jdbc2.save(j);
		return true;
	}


	@Override
	public List<Juego> obtenerJuegos() {
		
		return (List<Juego>) jdbc2.findAll();
	}

	@Override
	public void borrarJuego(int i) {
		jdbc2.deleteById(i);
	}

	@Override
	public void editarJuego(Juego j) {
		jdbc.editarJuego(j);
		
	}

	@Override
	public Juego buscarJuego(int i) {
		Juego j = jdbc.buscarJuego(i);
		return j;
	}

	@Override
	public ArrayList<Juego> buscarJuegoNombre(String n) {
		return jdbc.buscarJuegoNombre(n);
		 
}

	@Override
	public void jugarPartida(int juego, int puntuacion, int jugador) {
		jdbc.anadirPartida(juego, puntuacion, jugador);
		
	}

	@Override
	public Iterable<Juego> mostrarJuego() {
		// TODO Auto-generated method stub
		return null;
	}


	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Serializable obtenerTodosPorNombre() {
		
		return (Serializable) jdbc2.findAll();
	}
}
