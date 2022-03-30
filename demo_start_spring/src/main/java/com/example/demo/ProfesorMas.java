package com.example.demo;

public class ProfesorMas {
	int curso;
	private Profesor p;
	
	public ProfesorMas(int curso,Profesor p) {

		this.curso = curso;
		this.p = p;
	}
	
	public int getcurso() {
		return curso;
	}
	public void setcurso(int curso) {
		this.curso = curso;
	}

	public Profesor getP() {
		return p;
	}

	public void setP(Profesor p) {
		this.p = p;
	}

}
