package Arrays;

import java.util.Arrays;

public class Ejercicio_9_Sort {

	public static void main(String[] args) {
		//9 Sort
		int numeros[] = new int [10];
		
		//Randomizo el array
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random()*20+1);
		}
		
		//Ordeno Array
		Arrays.sort(numeros);
		
		//Print array
		for(int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		
		

}
}
