package Beans;

import Interfaces.Interfaz_escuela;

public class Escuela{
	private String nombre;
	private int añoInicio;
	private int cantidadAlumno;
	private int cantidadProfesor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAñoInicio() {
		return añoInicio;
	}
	public void setAñoInicio(int añoInicio) {
		this.añoInicio = añoInicio;
	}
	public int getCantidadAlumno() {
		return cantidadAlumno;
	}
	public void setCantidadAlumno(int cantidadAlumno) {
		this.cantidadAlumno = cantidadAlumno;
	}
	public int getCantidadProfesor() {
		return cantidadProfesor;
	}
	public void setCantidadProfesor(int cantidadProfesor) {
		this.cantidadProfesor = cantidadProfesor;
	}

	

}
