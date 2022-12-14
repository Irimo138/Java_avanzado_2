package com.zubiri.app.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
@Table(name = "Juegos")
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Size(min = 3, message = "No cumple con los minimos caracteres necesarios (3)")
	private String nombre;

	@NotNull(message = "Minimo debe de ser 0")
	@Min(value = 0, message = "Minimo debe de ser 0")
	private int puntuacionMax;

	@Nullable
	private int partidasJugadas;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "id_jugador", nullable = true)
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Jugador j;

	@JsonIgnore
	@OneToMany(mappedBy = "juego")
	Set<Partida> Partidas;

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

	public Jugador getJ() {
		return j;
	}

	public void setJ(Jugador j) {
		this.j = j;
	}

	public Set<Partida> getPartidas() {
		return Partidas;
	}

	public void setPartidas(Set<Partida> partidas) {
		this.Partidas = partidas;
	}

}
