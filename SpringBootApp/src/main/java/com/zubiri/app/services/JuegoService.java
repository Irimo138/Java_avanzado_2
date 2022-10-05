package com.zubiri.app.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBJuegosInterface;
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
	DBJuegosInterface jdbc2;

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
		jdbc.jugarPartida(juego, puntuacion, jugador);
		
	}

	@Override
	public Iterable<Juego> mostrarJuego() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Juego> obtenerTodosPorNombre() {
		Pageable pageable = PageRequest.of(0, 4);
		Page<Juego> page =  (Page<Juego>) jdbc2.findAll(pageable);
		return page;
	}
}
