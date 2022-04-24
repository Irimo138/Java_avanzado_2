package com.zubiri.app.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

public class Jugador {
	@NotNull
	int id;
	@NotBlank
	@Size(min = 3, max = 50, message ="No cumple con los minimos caracteres necesarios (3)")
	String nombre;
	
	@Nullable
	@Min(value = 0, message = "El valor minimo debe de ser de 0")
	int partidasGanadas;
	
	public Jugador() {
		
	}

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

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasJugadas) {
		this.partidasGanadas = partidasJugadas;
	}
	
	
}
