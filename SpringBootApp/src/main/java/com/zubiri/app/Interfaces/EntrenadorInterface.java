package com.zubiri.app.Interfaces;

import java.util.List;

import com.zubiri.app.beans.Entrenador;
import com.zubiri.app.beans.Equipo;

public interface EntrenadorInterface {
	
	Equipo mostrarEquipo(int i);
	void editarEntrenador(Entrenador e);
	Entrenador buscarEntrenadorId(int i);
	List<Entrenador> mostrarTodosLosEntrenadors();
	void borrarEntrenador(int i);
	void añadirEntrenador(Entrenador e);
}
