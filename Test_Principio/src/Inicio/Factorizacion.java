package Inicio;

public class Factorizacion {

	public static void main(String[] args) {
		int num = 300;
		//int num2 = num;
		int i = 2;
		System.out.println(1);
		while(num >= i) {
			if(num % i == 0) {
				num = num / i;
				System.out.println(i);
			}else {
				
				i++;
			}
			
		}
	}

}
