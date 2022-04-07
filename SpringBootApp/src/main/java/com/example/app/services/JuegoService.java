package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubiri.app.Connections.DBManagerJuegos;
import com.zubiri.app.Interfaces.JuegosInterface;
import com.zubiri.app.beans.Juego;

@Service
public class JuegoService implements JuegosInterface{
	
	private DBManagerJuegos dBManagerJuegos;
	
	@Autowired
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
		return null;
		
	}

	@Override
	public boolean borrarJuego(Juego j) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean editarJuego(Juego j) {
		return false;
		// TODO Auto-generated method stub
		
	}
	
}
