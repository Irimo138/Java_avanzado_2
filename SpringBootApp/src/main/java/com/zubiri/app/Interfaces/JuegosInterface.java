package com.zubiri.app.Interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.zubiri.app.beans.Juego;

public interface JuegosInterface {

	boolean insertarJuego(Juego j);
	List<Juego>  obtenerJuegos();
	boolean borrarJuego(int i);
	void editarJuego(Juego j);
	Juego buscarJuego(int i);
	ArrayList<Juego> buscarJuegoNombre(String n);
	void jugarPartida(int juego);
	void jugarPartida(int juego, int puntuacion);
	boolean insertarJuegoJDBC(Juego j);
	void editarJuegoJDBC(Juego juego);
	void eliminaJuegoJDBC(int idJuego);
}
