package ejemplos;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class Ej_4_Test extends TestCase{
	public static void main(String[] args) {
		
			
		
		Scanner t = new Scanner(System.in);
		int sum = 0;
		int num = t.nextInt();
		
		for(int i = 1; i < num; i++) {
			if(num % i == 0) {
				sum += i;
				//System.out.println(sum);
			}
		}
		if(num == sum) {
			System.out.println("El numero "+num+" es perfecto");
		}else {
			System.out.println("Kk");
		}
		
		
	}

}
