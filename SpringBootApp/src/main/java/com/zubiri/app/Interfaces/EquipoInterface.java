package com.zubiri.app.Interfaces;

import java.util.List;
import java.util.Optional;

import com.zubiri.app.beans.Equipo;
import com.zubiri.app.beans.Jugador;

public interface EquipoInterface {

	Equipo buscarEquipoId(int i);
	void editarEquipo(Equipo e);
	List<Jugador> mostrarJugadoresIdEqupo(int i);
	List<Equipo> mostrarTodosLosEquipos();
	void borrarEquipo(int i);
	void añadirEquipo(Equipo e);
	
	
}
