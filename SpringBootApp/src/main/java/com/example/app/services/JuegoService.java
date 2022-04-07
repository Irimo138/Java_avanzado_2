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
	public void setDBManagerJuegos(DBManagerJuegos dBManagerJuegos) {
		try {
			this.dBManagerJuegos = dBManagerJuegos;
			System.err.println("JuegoService creado");
			
		}catch(Exception e) {
			System.err.println("err");
			e.printStackTrace();
		}
	}

	public boolean insertarJuego(Juego j) {
		dBManagerJuegos.insertarJuegoDB(j);
		return false;		
	}

	public List<Juego> obtenerJuegos() {
		return null;
		
	}
	
	public boolean editarJuego(Juego j) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean borrarJuego(Juego j) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
