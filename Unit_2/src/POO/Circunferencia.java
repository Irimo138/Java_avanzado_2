package POO;

import org.junit.jupiter.api.Test;

public class Circunferencia {
	private int radio;
	private String color;
	
	public Circunferencia(int radio, String color) {
		super();
		this.radio = radio;
		this.color = color;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public double printPerimeter() {
		double perimeter = 2 * 3.14  * this.radio;
		//System.out.println(perimeter);
		return perimeter;
	}
	
	public boolean isBig() {
		boolean isBig;
		double big = 3.14  * this.radio * this.radio;
		if(big > 20) {
			isBig = true;
		}else {
			isBig = false;
		}
		return isBig;
	}
	
	public static boolean isEqual(Circunferencia real) {
		boolean isEqual;
		Circunferencia comp = new Circunferencia(2,"rojo");
		
		if(comp.radio == real.radio && comp.color.equals(real.color)) {
			isEqual = true;
		}else {
			isEqual = false;
		}
		return isEqual;
	}
	
	public String toString() {
		String str = "";
		System.out.println(this.getRadio());
		System.out.println(this.getColor());
		System.out.println(this.isBig());
		System.out.println(this.printPerimeter());
		System.out.println(isEqual(this));
		return str;
	}
	
	
	
	
	public static void main(String[] args) {
		Circunferencia c1 = new Circunferencia(2,"rojo");
		System.out.println(c1.isBig());
		c1.printPerimeter();
		System.out.println(isEqual(c1));
		c1.toString();
	}
}
