package com.zubiri.app.beans;

public class Juego {
	String nombre;
	String genero;
	int precio;
	int creador_id;
	
	public Juego() {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCreador_id() {
		return creador_id;
	}
	public void setCreador_id(int creador_id) {
		this.creador_id = creador_id;
	}
}
