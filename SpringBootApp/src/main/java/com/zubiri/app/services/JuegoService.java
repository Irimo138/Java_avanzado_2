package com.zubiri.app.services;

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
	

	public boolean insertarJuego(Juego j) {
		dBManagerJuegos.insertarJuegoDB(j);
		return false;		
	}

	public List<Juego> obtenerJuegos() {	
		return dBManagerJuegos.mostrarJuegos();
		
	}
	
	public boolean editarJuego(Juego j) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean borrarJuego(int i) {
		dBManagerJuegos.borrarJuego(i);
		return false;
	}
	
}
