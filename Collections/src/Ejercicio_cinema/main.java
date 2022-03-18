package Ejercicio_cinema;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		Movie p1 = new Movie("Batman",180,2022);
		Movie p2 = new Movie("Spiderman",183,2022);
		Movie p3 = new Movie("Dune",120,2022);
		Cinema urbil = new Cinema("Urbil", 8);
		urbil.addMovie(p1);
		urbil.addMovie(p1);
		urbil.addMovie(p2, 4);
		urbil.addMovie(p3, 4);
		urbil.mostrarCine();
		urbil.removeMovie("Bat");
		urbil.showLibres();
		System.out.println(urbil.roomOfMovie(p2));
		System.out.println(urbil.toString());
	}

}
