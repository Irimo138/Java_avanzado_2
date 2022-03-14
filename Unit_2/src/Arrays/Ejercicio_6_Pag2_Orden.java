package Arrays;

import java.util.Scanner;
public class Ejercicio_6_Pag2_Orden {

	public static void main(String[] args) {
		//Leer por teclado una serie de 10 n�meros enteros. La aplicaci�n debe indicarnos si los
		//n�meros est�n ordenados de forma creciente, decreciente, o si est�n desordenados.
		Scanner t = new Scanner(System.in);
		int numeros[] = new int [10];
		
		//Creo el array
		for(int i = 0; i < numeros.length; i++) {
			System.out.print("El N�"+i+": ");
			numeros[i] = t.nextInt();
		}
		
		//Booleans para comprobar
		boolean creciente = true;
		boolean decreciente = true;
		
		//Comprobaci�n
		for(int i = 1; i < numeros.length; i++) {
			if(numeros[i] > numeros[i-1]) {
				decreciente = false;
			}else if (numeros[i] < numeros[i-1]){
				creciente = false;
			}
		}
		//Imprimir resultado
		if(creciente == true) {
			System.out.println("Es creciente");
		}else if(decreciente == true) {
			System.out.println("Es decreciente");
		}else {
			System.out.println("Esta desordenado");
		}
		
		
}
}
