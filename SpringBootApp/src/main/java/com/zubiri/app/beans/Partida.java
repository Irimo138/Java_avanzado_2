package com.zubiri.app.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

@Entity
@Table(name = "Partidas")
@org.hibernate.annotations.Immutable   
public class Partida {
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Nullable
	@Min(value = 0, message = "El valor minimo debe de ser de 0")
	private int Puntuacion;
	
	@ManyToOne
    @JoinColumn(name = "jugador_id")
    Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    Juego juego;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPuntuacion() {
		return Puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		Puntuacion = puntuacion;
	}


	public Jugador getJugador() {
		return jugador;
	}


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public Juego getJuego() {
		return juego;
	}


	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	

}
