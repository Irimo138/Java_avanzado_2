package Arrays;

import java.util.Scanner;
import java.util.*;

//INCOMPLETO
public class Ejercicio_13_Pag_2 {	
	/*
	. Leer dos series de 10 enteros, que estar�n ordenados crecientemente. Copiar (fusionar) las
	dos tablas en una tercera, de forma que sigan ordenados.
	*/
	static int numeros[];
	static int numeros2[];
	static int finalNumeros[];
	public static void main(String[] args) {

	Scanner t = new Scanner(System.in);
	numeros = new int[5];
	numeros2 = new int[5];
	finalNumeros = new int[10];
	
	//Creo el array 1 y lo relleno
	for(int i = 0; i < numeros.length; i++) {
		System.out.print("El N�"+i+": ");
		numeros[i] = t.nextInt();
		}
	
	//Creo el array 2 y lo relleno
	for(int i = 0; i < numeros2.length; i++) {
		System.out.print("El N�"+i+": ");
		numeros2[i] = t.nextInt();
		}
	
	int cont1 = 0; 
	int cont2 = 0;
	for(int i = 0; i < finalNumeros.length; i++) {
		if(numeros[cont1] < numeros2[cont2] && cont1 != 4) {
			finalNumeros[i] = numeros[cont1];
			if(cont1 < 4) {
				cont1++;
			}
			//System.out.println(cont1);
		}else {
			finalNumeros[i] = numeros2[cont2];
			if(cont2 < 4) {
				cont2++;
			}
		}
		}
	
	for(int i = 0; i < finalNumeros.length; i++) {
		System.out.println(finalNumeros[i]);
	}
	}
	
	
}