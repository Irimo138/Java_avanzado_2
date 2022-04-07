package com.zubiri.app.Interfaces;

import java.util.List;

import com.zubiri.app.beans.Creador;

public interface CreadoresInterface {
	boolean insertarCreador(Creador c);
	List<Creador> mostrarCreadores();
	boolean eliminarCreador(Creador c);
	boolean editarCreador(Creador c);
}
