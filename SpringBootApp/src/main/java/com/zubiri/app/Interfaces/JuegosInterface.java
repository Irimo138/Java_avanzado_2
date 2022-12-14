package com.zubiri.app.Interfaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zubiri.app.beans.Juego;

public interface JuegosInterface{

	boolean insertarJuego(Juego j);
	List<Juego> obtenerJuegos();
	void borrarJuego(int i);
	void editarJuego(Juego j);
	Juego buscarJuego(int i);
	List<Juego> buscarJuegoNombre(String n);
	Iterable<Juego> mostrarJuego();
	Serializable obtenerTodosPorNombre();
	void jugarPartida(int juego, int puntuacion, int jugador);	
}
