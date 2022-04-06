package com.zubiri.app.Interfaces;

import com.zubiri.app.beans.Creador;

public interface CreadoresInterface {
	public abstract void crearCreador(Creador c);
	public abstract void mostrarCreadores();
	public abstract void eliminarCreador(Creador c);
	public abstract void editarCreador(Creador c);
}
