package Inicio;

public class MKT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y = 36;
		int x = 48;
		
		
		for(int i = 0; i <= x; i++) {			
			int resto1 = (x % y);
			int val2 = y % resto1;
			
			if(resto1 % val2 == 0) {
				System.out.println("El mcd es:"+val2);
				break;
			}else {
				x = resto1;
				y = val2;
			}
			
		}
		
		/*
		 * System.out.println(val2);
		 * System.out.println(resto1);
		 */
		
	}

}
