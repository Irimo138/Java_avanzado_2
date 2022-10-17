package com.zubiri.app.beans;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
@Entity
@Table(name = "Equipo")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	@Size(min = 3, max = 50, message ="No cumple con los minimos caracteres necesarios (3)")
	private String nombre;
	
	@Nullable
	@Min(value = 0, message = "El valor minimo debe de ser de 0")
	private int partidasGanadas;
	
	@OneToMany
	@JoinColumn(
			name = "Equipo_Id",
			nullable = true
	)
	Set<Jugador> listaJugadores;
	
	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
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

	
	
}
