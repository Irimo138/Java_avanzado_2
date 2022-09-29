package com.zubiri.app.Interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import com.zubiri.app.beans.Juego;

public interface JuegosInterface{

	boolean insertarJuego(Juego j);
	List<Juego> obtenerJuegos();
	void borrarJuego(int i);
	void editarJuego(Juego j);
	Juego buscarJuego(int i);
	ArrayList<Juego> buscarJuegoNombre(String n);
	Iterable<Juego> mostrarJuego();
	void jugarPartida(int juego, int puntuacion, int jugador);	
}
