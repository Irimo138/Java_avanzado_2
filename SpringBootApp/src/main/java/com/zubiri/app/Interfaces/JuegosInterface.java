package com.zubiri.app.Interfaces;

import java.util.List;


import com.zubiri.app.beans.Juego;

public interface JuegosInterface {

	boolean insertarJuego(Juego j);
	List<Juego>  obtenerJuegos();
	boolean borrarJuego(Juego j);
	boolean editarJuego(Juego j);
}
