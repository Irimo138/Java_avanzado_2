package Arrays;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejemplo_Arraylist {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Integer num1 = new Integer(10);
		Integer num2 = new Integer(20);
		Integer num3 = new Integer(30);
		Integer num4 = new Integer(40);
		numbers.add(num1);
		numbers.add(num2);
		numbers.add(num3);
		numbers.add(num4);
		int sum=0;
		Iterator<Integer> it = numbers.iterator();
		while(it.hasNext()) {
			int valor = it.next();
			sum += valor;
		}
		sum = 0;
		for(int valor : numbers) {
			sum += valor;
		}
		System.out.println(sum);

	}

}
