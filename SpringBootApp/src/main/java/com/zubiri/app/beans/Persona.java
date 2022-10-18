package com.zubiri.app.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Persona {
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank
	@Size(min = 3, max = 50, message ="No cumple con los minimos caracteres necesarios (3)")
	private String nombre;
	
	@NotNull
	@Column(nullable = false)   						
	private String DNI;

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona() {}
	public Persona(@NotNull int id,
			@NotBlank @Size(min = 3, max = 50, message = "No cumple con los minimos caracteres necesarios (3)") String nombre,
			@NotNull String dNI) {
		super();
		this.id = id;
		this.nombre = nombre;
		DNI = dNI;
	}
	
	


}
