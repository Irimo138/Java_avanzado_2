package Ejercicio_cinema;

import org.junit.jupiter.api.Test;
import java.util.*;

public class Movie {
	private String name;
	private int minutos;
	private int a�o;
	public Movie(String name, int minutos, int a�o) {
		super();
		this.name = name;
		this.minutos = minutos;
		this.a�o = a�o;
	}	
	
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", minutos=" + minutos + ", a�o=" + a�o + "]";
	}

	public String getName() {
		return name;
	}
	public int getMinutos() {
		return minutos;
	}
	public int getA�o() {
		return a�o;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return a�o == other.a�o && (minutos >= other.minutos-5 && minutos <= other.minutos+5) && Objects.equals(name, other.name);
	}
	
}
