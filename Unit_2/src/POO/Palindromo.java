package POO;

public class Palindromo {

	private long num;
	
	public Palindromo(long num) {
		super();
		this.num = (long) (Math.random() * Long.MAX_VALUE + 1);
	}
	public Palindromo() {
		super();
	}
	


	public boolean esPalindromo(long numero) {
		this.num = numero;
		
		boolean bol = false;	
		return bol;
	}
	
	public long getNum() {
		return num;
	}
	
	public int contarCifras() {
		int cif = 0;
		long aux = num;
		while(aux != 0) {
			aux /= 10;
			cif++;
		}
		System.out.println(cif);
		return cif;
	}
	
	public int digito(int posicion) {
	
		if(posicion > 0  && posicion <= this.contarCifras()) {
			
		int pos = 1;
		int numdigitos = contarCifras();
		int digito = (int) num % 10;
		long aux = num;
		while(pos < numdigitos) {
			digito = (int) num % 10;
			aux /= 10;
			pos++;
		}
		return digito;
		}else {
			return -1;
		}
	}

	public void setNum(long num) {
		this.num = num;
	}

	public static void main(String[] args) {
		Palindromo p = new Palindromo(24L);
		p.contarCifras();

	}

}