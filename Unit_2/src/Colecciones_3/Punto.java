package Colecciones_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Punto {

	private int X;
	private int Y;
	static ArrayList<Punto> puntoList;
		
	public Punto(int x, int y) {
		super();
		this.X = x;
		this.Y = y;
	}
	public Punto() {
		
	}
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}
	
	public double getDistancia(Punto p) {
		double h = Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
        return h;
	}

	public void setY(int y) {
		Y = y;
	}

	@Override
	public String toString() {

		return "Punto [X=" + X + ", Y=" + Y + "]";
	}
	
	public static void mostrar(ArrayList<Punto> ArrayList) {
		Iterator <Punto> s1 = ArrayList.iterator();	
		while(s1.hasNext()){
			System.out.println(s1.next().toString());
		}
	}
	
	public static Punto primeroCuadrante2() {
		Iterator<Punto> it = puntoList.iterator();
		while(it.hasNext()) {
			Punto p = it.next();
			if(p.getX() < 0 && p.getY() > 0) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(X, Y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return X == other.X && Y == other.Y;
	}
	
	//Esta mal, hay que usar la funcion reverse
	public static ArrayList<Punto> mostrarDelReves(ArrayList<Punto> ArrayList) {
		ArrayList<Punto> delReves = new ArrayList<Punto>();
		
		Iterator <Punto> s1 = ArrayList.iterator();	
		while(s1.hasNext()){
			Punto a�adir = ArrayList.get(2);
			delReves.add(a�adir);
			//ArrayList.remove(a�adir);
		}
		
		return delReves;
		
	}
	
	public static boolean existePunto11() {
		Punto comp = new Punto (1,1);
		return puntoList.contains(comp);
	}
	
	public static void eliminaDistancia() {
        boolean encontrado=false;
        Iterator<Punto> it = puntoList.iterator();
        while(it.hasNext() && !encontrado) {
            Punto p  = it.next();
            if(p.getDistancia(p)<10) {
                puntoList.remove(p);
                System.out.println("se ha eliminado "+p);
                encontrado=true;

            }

        }

    }
	
	public static void eliminaCuatro() {
		Iterator<Punto> it = puntoList.iterator();
        while(it.hasNext()) {
        	Punto p = it.next();
        	if(p.getX() > 0 && p.getY() < 0) {
        		System.out.println("Se ha eliminado"+ p);
        	 puntoList.remove(p);
        	}
        }
	}
	
	public static void ordenar() {
		Punto p = new Punto(0,0);
		//Collections.sort(puntoList, p);
		//Usar set para cambiar la posici�n
	}
	
	public static void main(String[] args) {
		puntoList = new ArrayList<Punto>();
		Punto p1 = new Punto(1,2);
		Punto p4 = new Punto(1,1);
		Punto p2 = new Punto(3,2);
		Punto p3 = new Punto(1,-4);
		puntoList.add(p3);
		puntoList.add(p1);
		puntoList.add(p2);
		puntoList.add(p4);
		mostrar(puntoList);
		System.out.println(existePunto11());
		System.out.println(primeroCuadrante2());
		eliminaDistancia();
		eliminaCuatro();
		mostrar(puntoList);
		
		//System.out.println(mostrarDelReves(puntoList));
		
	}
}
