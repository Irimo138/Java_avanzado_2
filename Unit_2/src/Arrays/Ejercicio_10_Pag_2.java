package Arrays;

import java.util.Scanner;
import java.util.*;

//INCOMPLETO
public class Ejercicio_10_Pag_2 {
	
	
	
	/*
	Leer 5 elementos num�ricos que se introducir�n ordenados de forma creciente. �stos los
	guardaremos en una tabla de tama�o 5. Leer un n�mero N, e insertarlo en el lugar adecuado
	para que la Array contin�e ordenada
	*/
	static int numeros[];
	public static void main(String[] args) {

	Scanner t = new Scanner(System.in);
	numeros = new int[5];
	
	//Creo el array y lo relleno
	for(int i = 0; i < numeros.length; i++) {
		System.out.print("El N�"+i+": ");
		numeros[i] = t.nextInt();
	}
	
	int intro = t.nextInt();
	
	for(int i = 1; i < numeros.length; i++) {
		if(numeros[i] > intro) {
			desplazar(i);
			numeros[i] = intro;
		}
	}
	
	for(int i = 0; i < numeros.length; i++) {
		System.out.println(numeros[i]);
	}
	
	}
	public static void desplazar(int i) {
		for(int rec = numeros.length - 1; rec > i ; rec--) {
		numeros[rec] = numeros[rec-1];
		}
	}
	
	
}
