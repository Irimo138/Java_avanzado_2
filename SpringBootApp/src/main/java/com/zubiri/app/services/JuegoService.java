package com.zubiri.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBJuegosInterface;
import com.zubiri.app.Interfaces.JuegosInterface;
import com.zubiri.app.beans.Juego;
import com.zubiri.app.connections.JdbcJuegoRepository;

@Service 
public class JuegoService implements JuegosInterface{
	
	private JdbcJuegoRepository jdbc;
	
	public JuegoService (JdbcJuegoRepository jdbc) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrarJuego(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void editarJuego(Juego j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Juego buscarJuego(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Juego> buscarJuegoNombre(String n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void jugarPartida(int juego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jugarPartida(int juego, int puntuacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insertarJuegoJDBC(Juego j) {
		jdbc2.save(j);
		return false;
	}

	@Override
	public void editarJuegoJDBC(Juego juego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminaJuegoJDBC(int idJuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Juego> mostrarJuego() {
		// TODO Auto-generated method stub
		return null;
	}

}
