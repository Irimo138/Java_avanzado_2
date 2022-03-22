package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Persona {

	String nombre;
	String numero;
	String lugar;
	
	
	
	public Persona(String nombre, String numero, String lugar) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.lugar = lugar;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String arrayLinea) {
		this.numero = arrayLinea;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", numero=" + numero + ", lugar=" + lugar + "]";
	}
	}
