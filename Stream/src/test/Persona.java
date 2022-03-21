package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Persona {

	String nombre;
	int numero;
	String lugar;
	
	
	
	public Persona(String nombre, int numero, String lugar) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.lugar = lugar;
	}

	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", numero=" + numero + ", lugar=" + lugar + "]";
	}
	}
