package com.zubiri.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.JuegosInterface;
import com.zubiri.app.beans.Juego;
import com.zubiri.app.connections.DBManagerJuegos;

@Service 
public class JuegoService implements JuegosInterface{
	
	
	private DBManagerJuegos dBManagerJuegos;

	public JuegoService(DBManagerJuegos dBManagerJuegos) {
		this.dBManagerJuegos = dBManagerJuegos;
		System.err.println("JuegoService creado");
	}
	
	@Override
	public boolean insertarJuego(Juego j) {
		dBManagerJuegos.insertarJuegoDB(j);
		return false;		
	}

	@Override
	public List<Juego> obtenerJuegos() {	
		return dBManagerJuegos.mostrarJuegos();
		
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
	public void jugarPartida(int juego, int puntuacion) {
		dBManagerJuegos.jugarPartida(juego, puntuacion);
		
		
	}

	@Override
	public void jugarPartida(int juego) {
		// TODO Auto-generated method stub
		
	}
	
}
