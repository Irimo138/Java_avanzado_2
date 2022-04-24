package com.zubiri.app.Interfaces;

import java.util.List;

import com.zubiri.app.beans.Jugador;

public interface JugadorInterface {
	boolean insertarJugador(Jugador c);
	List<Jugador> mostrarJugador();
	void eliminarJugador(int i);
	void editarJugador(Jugador c);
	void ganaJuego(int jugador);
}
