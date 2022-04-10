package com.zubiri.app.beans;

import javax.validation.constraints.NotNull;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

public class Juego {
	
	@NotNull
	int id;
	@NotNull
	String nombre;
	@NotNull
	String genero;
	@NotNull
	int precio;
	@Nullable
	int creador_id;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
