package com.zubiri.app.Interfaces;

import java.util.ArrayList;

import com.zubiri.app.beans.Juego;

public interface DBJuegosInterface {
	Iterable<Juego> mostrarJuego();
	Juego buscarJuego(int i);
	Juego insertJuego(Juego j);
	void editJuego(Juego j);
	void eliminarJuego(int idJuego);
}
