package com.zubiri.app.Interfaces;

import java.util.List;

import com.zubiri.app.beans.Jugador;
import com.zubiri.app.beans.Partida;

public interface JugadorInterface {
	void insertarJugador(Jugador c);
	List<Jugador> mostrarJugador();
	void eliminarJugador(int i);
	void editarJugador(Jugador c);
	void ganaJuego(Partida p);
}
