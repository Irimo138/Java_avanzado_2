package com.zubiri.app.Interfaces;

import java.util.List;


import com.zubiri.app.beans.Juego;

public interface JuegosInterface {

	boolean insertarJuego(Juego j);
	List<Juego>  obtenerJuegos();
	boolean borrarJuego(int i);
	void editarJuego(Juego j);
	Juego buscarJuego(int i); 
}
