package com.zubiri.app.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

public class Juego {
	
	@NotNull
	int id;
	@NotNull
	@Size(min = 3, message ="No cumple con los minimos caracteres necesarios (3)")
	String nombre;
	
	@NotNull(message="Minimo debe de ser 0")
	@Min(value = 0, message="Minimo debe de ser 0")
	int puntuacionMax;
	
	@Nullable
	int partidasJugadas;
	
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
	public int getPuntuacionMax() {
		return puntuacionMax;
	}
	public void setPuntuacionMax(int puntuacionMax) {
		this.puntuacionMax = puntuacionMax;
	}
	public int getPartidasJugadas() {
		return partidasJugadas;
	}
	public void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}	
}
