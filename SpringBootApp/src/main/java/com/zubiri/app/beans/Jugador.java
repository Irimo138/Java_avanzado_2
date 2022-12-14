package com.zubiri.app.beans;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force=true)
@Entity
@Table(name = "Jugadores")
public class Jugador extends Persona{

	public Jugador() {}
	public Jugador(@NotNull int id,
			@NotBlank @Size(min = 3, max = 50, message = "No cumple con los minimos caracteres necesarios (3)") String nombre,
			@NotNull String dNI, @NotNull String nombre2) {
		super(id, nombre, dNI);
	}	

	@Nullable
	@Min(value = 0, message = "El valor minimo debe de ser de 0")
	private int partidasGanadas;
	
	@OneToMany(mappedBy = "jugador")
	@JsonIgnore
    Set<Partida> partidas;
	
	@ManyToOne
    @JoinColumn(name="Equipo_Id")
    private Equipo equipo;
	
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	

	@Embedded
	private Direccion direccion;
	
	public Direccion getDireccion() { 
		return direccion; 
	}
	
	public void setDireccion(Direccion direccion) { 
		this.direccion = direccion; 
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasJugadas) {
		this.partidasGanadas = partidasJugadas;
	}

	public Set<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(Set<Partida> partidas) {
		this.partidas = partidas;
	}
	
	
	
	
}
