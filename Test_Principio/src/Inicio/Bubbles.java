package Inicio;

public class Bubbles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArray = new int[]{ 5,9,3,4,6,2,8 }; 
		int y = 0;
		while(y <= intArray.length-1) {
		for(int i = 0; i < intArray.length-1; i++) {
			if(intArray[i] > intArray[i + 1]) {
				int val1 = intArray[i];
				int val2 = intArray[i+1];
				intArray[i] = val2;
				intArray[i+1] = val1;
			}
		}
		y++;
		}
		for(int i = 0; i < intArray.length-1; i++) {
			System.out.println(intArray[i]);
		}
	}

}
