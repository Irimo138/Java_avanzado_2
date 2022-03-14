package POO;

import java.util.Objects;

public class Punto {

	private int X;
	private int Y;
	
	
	public Punto(int x, int y) {
		super();
		this.X = x;
		this.Y = y;
	}


	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		Y = y;
	}

	public int cuadrante() {
		if(this.X >0 && this.Y > 0) {
			return 1;
		}else if(this.X <0 && this.Y > 0) {
			return 2;
		}else if(this.X <0 && this.Y < 0) {
			return 3;
		}else {
			return 4;
		}
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(X, Y);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return X == other.X && Y == other.Y;
	}
	
	
	public double longitud() {
		double sqr = Math.sqrt(X);
			return sqr;
	}


	public static void main(String[] args) {
		

	}

}