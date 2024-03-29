package POO;

import java.math.BigDecimal;

public class Banco {
	private BigDecimal saldo;
	private String nombre;
	private boolean rojo;
	public Banco( String nombre) {
		super();
		this.saldo = new BigDecimal(0);
		this.nombre = nombre;
		boolean rojo;
	}
	
	public Banco(BigDecimal saldo, String nombre) {
		super();
		this.saldo = saldo;
		this.nombre = nombre;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void deposito(BigDecimal ingreso) {
		this.saldo = this.saldo.add(ingreso);
		System.out.println("Tu saldo es de: "+this.saldo);
	}
	
	public void retiro(BigDecimal retiro) {
		this.saldo = this.saldo.subtract(retiro);
	}
	
	public String toString() {
		String str;
		str = "Nombre: "+this.getNombre()+", Saldo"+ this.getSaldo();
		return str;
	}
	public static void main(String[] args) {
		Banco B = new Banco( new BigDecimal("21258.2"),"Iriarte");
		B.deposito(new BigDecimal("400"));
		System.out.println(B.toString());
	}
}
