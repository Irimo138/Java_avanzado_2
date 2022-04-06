package com.zubiri.app.Interfaces;

import com.zubiri.app.beans.Juego;

public interface JuegosInterface {

	public abstract void crearJuego(Juego j);
	public abstract void mostrarJuegos();
	public abstract void borrarJuego(Juego j);
	public abstract void editarJuego(Juego j);
}
