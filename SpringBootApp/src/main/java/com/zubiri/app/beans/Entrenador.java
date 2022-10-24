package com.zubiri.app.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "entrenadores")
public class Entrenador extends Persona{
	
	public Entrenador() {}
	public Entrenador(@NotNull int id,
			@NotBlank @Size(min = 3, max = 50, message = "No cumple con los minimos caracteres necesarios (3)") String nombre,
			@NotNull String dNI, @NotNull String nombre2) {
		super(id, nombre, dNI);
		// TODO Auto-generated constructor stub
	}
	
	@Nullable
	@Min(value = 0, message = "El valor minimo debe de ser de 0")
	private int partidasGanadas;
	
	@Nullable
	@OneToOne
	@JoinColumn(name = "idEquipo", referencedColumnName = "id")
    private Equipo equipo;
	
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

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	
	
}
