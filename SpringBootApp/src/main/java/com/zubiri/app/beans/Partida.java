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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

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

		public Id() {
		}

		public Id(int jugador_id, int juego_id) {
			this.jugador_id = jugador_id;
			this.juego_id = juego_id;
		}
	}

	@EmbeddedId
	private Id id = new Id();

	@Column
	@NotNull
	private int puntuacion;

	@Column(updatable = false)
	@NotNull
	@CreationTimestamp
	private LocalDateTime addedOn;

	@ManyToOne
	@JoinColumn(name = "jugador_id", insertable = false, updatable = false)
	private Jugador jugador;

	@ManyToOne
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

	public LocalDateTime getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
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