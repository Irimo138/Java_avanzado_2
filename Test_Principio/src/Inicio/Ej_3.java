package Inicio;

public class Ej_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int seg = 5;
		int sum = 6;
		int sum2 = 12;
		int num = 2;
		for(int i = 1; i <= seg; i++) {
			System.out.println(num);
			num += sum;
			
			sum = sum + 6 * (i+1);
			
		}
	}

}