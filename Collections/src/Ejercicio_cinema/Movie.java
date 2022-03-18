package Ejercicio_cinema;

import org.junit.jupiter.api.Test;
import java.util.*;

public class Movie {
	private String name;
	private int minutos;
	private int año;
	public Movie(String name, int minutos, int año) {
		super();
		this.name = name;
		this.minutos = minutos;
		this.año = año;
	}	
	
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", minutos=" + minutos + ", año=" + año + "]";
	}

	public String getName() {
		return name;
	}
	public int getMinutos() {
		return minutos;
	}
	public int getAño() {
		return año;
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
		return año == other.año && (minutos >= other.minutos-5 && minutos <= other.minutos+5) && Objects.equals(name, other.name);
	}
	
}
