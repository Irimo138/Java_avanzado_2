package com.zubiri.app.Interfaces;

import java.util.ArrayList;

import com.zubiri.app.beans.Juego;

public interface DBJuegosInterface {
	Iterable<Juego> mostrarJuego();
	void editarJuego(int i);
	Juego buscarJuego(int i);
	
}
