package Ejercicio_cinema;

import java.util.ArrayList;
import java.util.Arrays;

public class Cinema {
	private String nombre;
	private ArrayList<Movie> Films = new ArrayList<Movie>();
	private String[] busyRooms;
	
	public Cinema(String nombre, int capacidad) {
		super();
		this.nombre = nombre;
		this.busyRooms = new String[capacidad];
	}
	
	public void addMovie(Movie pelicula) {
		if(comprobarSalaVacia()!= -1 && peliculaEnCine(pelicula)) {			
			Films.add(pelicula);
			busyRooms[comprobarSalaVacia()] = pelicula.getName();
		}
	}
	
	private boolean peliculaEnCine(Movie pelicula) {
		for(int i = 0; i < Films.size(); i++) {
			if(Films.get(i).getName().equals(pelicula.getName())) {				
				return false;
			}
		}
		return true;
	}

	public void addMovie(Movie pelicula, int pos) {
		if(comprobarSalaVacia()!= -1 && busyRooms[pos] == null) {			
			Films.add(pelicula);
			busyRooms[pos] = pelicula.getName();
		}
	}	
	
	public int roomOfMovie(Movie pelicula) {
		for(int i = 0; i < Films.size(); i++) {
			if(Films.get(i).equals(pelicula)) {
				return salaDePelicula(pelicula);
			}
		}
		return -1;
	}
	private int salaDePelicula(Movie pelicula) {
		for(int i = 0; i < busyRooms.length; i++) {
			if(busyRooms[i] != null) {
				if(busyRooms[i].equals(pelicula.getName())) {
					return i;
				}
			}
			
		}
		return -1;
		
	}

	private int comprobarSalaVacia() {
		for(int i = 0; i < busyRooms.length; i++) {
			if(busyRooms[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public void mostrarCine() {
		System.out.println(this.getNombre()+": ");
		for(int i = 0; i < busyRooms.length; i++) {
			if(busyRooms[i] != null) {
				System.out.println(busyRooms[i]+"  Sala: "+(i+1));
			}
		}
	}
	
	public void removeMovie(String cadena) {
		for(int i = 0; i < Films.size(); i++) {
			if(Films.get(i).getName().contains(cadena)) {
				Films.remove(i);
			}
		}
		
		for(int i = 0; i < busyRooms.length; i++) {
			if(busyRooms[i] != null) {
			if(busyRooms[i].contains(cadena)) {
				busyRooms[i] = null;
			}
			}
		}
	}
	
	public void showLibres() {
		ArrayList<Integer> libre = salasLibres();
		String str="[ ";
		for(int i = 0; i < libre.size(); i++) {
			str= str+""+libre.get(i)+", ";
		}
		str= str+" ]";
		System.out.println(str);
	}
	
	public ArrayList salasLibres(){
		ArrayList<Integer> salasLibres= new ArrayList<Integer>();
			for(int i = 0; i < busyRooms.length; i++) {
				if(busyRooms[i] == null) {
					salasLibres.add(i);
				}
			}
		return salasLibres;
	}
	
	@Override
	public String toString() {
		return "Cinema [nombre=" + nombre + ", Films=" + Films + ", busyRooms=" + Arrays.toString(busyRooms) + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public ArrayList<Movie> getFilms() {
		return Films;
	}
	public String[] getBusyRooms() {
		return busyRooms;
	}
}
