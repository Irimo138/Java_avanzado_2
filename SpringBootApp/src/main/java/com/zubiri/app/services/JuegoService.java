package com.zubiri.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBJuegosInterface;
import com.zubiri.app.Interfaces.JuegosInterface;
import com.zubiri.app.beans.Juego;
import com.zubiri.app.connections.DBManagerJuegos;
import com.zubiri.app.connections.JdbcJuegoRepository;

@Service 
public class JuegoService implements JuegosInterface{
	
	
	private DBManagerJuegos dBManagerJuegos;
	private DBJuegosInterface jdbc;

	public JuegoService(DBManagerJuegos dBManagerJuegos, JdbcJuegoRepository jdbc) {
		this.dBManagerJuegos = dBManagerJuegos;
		this.jdbc = jdbc;
		System.err.println("JuegoService creado");
	}
	
	@Override
	public boolean insertarJuego(Juego j) {
		dBManagerJuegos.insertarJuegoDB(j);
		return false;		
	}
	
	@Override
	public boolean insertarJuegoJDBC(Juego j) {
		jdbc.insertJuego(j);
		return false;		
	}

	@Override
	public List<Juego> obtenerJuegos() {	
		return dBManagerJuegos.mostrarJuegos();
		
	}
	
	public Iterable<Juego> obtenerJuegosJDBC(){
		return jdbc.mostrarJuego();
	}
	@Override
	public void editarJuego(Juego j) {
		dBManagerJuegos.editarJuego(j);
		
	}

	@Override
	public boolean borrarJuego(int i) {
		dBManagerJuegos.borrarJuego(i);
		return false;
	}

	@Override
	public Juego buscarJuego(int i) {
		return dBManagerJuegos.buscarJuego(i);
	}

	public ArrayList<Juego> buscarJuegoNombre(String nombre) {
		return dBManagerJuegos.buscarJuegoNombre(nombre);
		// TODO Auto-generated method stub
		
	}
	public void jugarPartida(int juego, int puntuacion, int jugador) {
		dBManagerJuegos.jugarPartida(juego, puntuacion, jugador);
		
		
	}

	@Override
	public void jugarPartida(int juego) {
		// TODO Auto-generated method stub
		
	}

	public Juego buscarJuegoJDBC(int idJuego) {
		return jdbc.buscarJuego(idJuego);
	}
	
	@Override
	public void editarJuegoJDBC(Juego juego) {
		jdbc.editJuego(juego);
		
	}
	
	@Override
	public void eliminaJuegoJDBC(int idJuego) {
		jdbc.eliminarJuego(idJuego);
		
	}

	@Override
	public void jugarPartida(int juego, int puntuacion) {
		// TODO Auto-generated method stub
		
	}

	
	
}
