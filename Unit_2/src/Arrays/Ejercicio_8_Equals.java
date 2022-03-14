package Arrays;

import java.util.Arrays;

public class Ejercicio_8_Equals {
		public static void main(String[] args) {
			//8 Copy of e Equals
			//Si usas el metodo comentado sale true, sino false
			int numeros[] = new int [10];
			int copia[] = new int [10];
			Arrays.fill(numeros, 10);
			
			for(int i = 0; i < numeros.length; i++) {
				System.out.println(i +" "+ numeros[i]);
			}
			
			//int copia[] = Arrays.copyOf(numeros, 10);
			
			for(int i = 0; i < copia.length; i++) {
				copia[i] = i;
			}
			
			System.out.println(Arrays.equals(numeros, copia));

	}

}
