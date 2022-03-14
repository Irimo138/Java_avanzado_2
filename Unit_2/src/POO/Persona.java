package POO;

import lombok.Getter;

@Getter
public class Persona {
	private String nombre;
	private String genero;
	private int edad;
	
	public Persona(String nombre, String genero, int edad) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
	}
	

}
