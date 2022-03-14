package Ejercicios;

public class Figura {

	private double perimetro;
	private double area;
	
	private static int contFiguras = 0;
	
	
	public Figura(double perimetro, double area) {
		super();
		this.perimetro = perimetro;
		this.area = area;
		contFiguras++;
	}
	
	
	
	public double getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}
	public double getArea() {
		return area;
	}
	public static int getcontFiguras() {
		return contFiguras;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	
	public static void main(String[] args) {
		Figura f1 = new Figura(2.5, 4.0);
		System.out.println(f1.getArea());
		System.out.println(f1.getcontFiguras());
		
		Figura f2 = new Figura(1.7, 4.9);
		System.out.println(Figura.getcontFiguras());
		
	}
	
}
