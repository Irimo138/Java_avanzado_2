package com.zubiri.app.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Partidas")
@org.hibernate.annotations.Immutable
public class Partida {

	@Embeddable
	public static class Id implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Column(name = "jugador_id")
		private int jugador_id;
		
		@Column(name = "juego_id")
		private int juego_id;
		
		@Column(updatable = false)
		@NotNull
		@CreationTimestamp
		private LocalDateTime addedOn;

		public Id() {}

		public Id(int jugador_id, int juego_id, LocalDateTime addedOn) {
			this.jugador_id = jugador_id;
			this.juego_id = juego_id;
			this.addedOn = addedOn;
		}
	}

	@EmbeddedId
	private Id id = new Id();

	@Column
	@NotNull
	private int puntuacion;

	@ManyToOne
	@JoinColumn(name = "jugador_id", insertable = false, updatable = false)
	private Jugador jugador;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "juego_id", insertable = false, updatable = false)
	private Juego juego;

	public Partida() {
	}

	public Partida(Juego juego, Jugador jugador) {
		this.jugador = jugador;
		this.juego = juego;
		this.id.jugador_id = jugador.getId();
		this.id.juego_id = juego.getId();
		juego.getPartidas().add(this);
		jugador.getPartidas().add(this);
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
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