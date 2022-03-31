package com.example.demo.beans;

public class Profesor {
	int edad;
	String nombre;
	
	public Profesor(int edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}
	public Profesor() {
		
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
