package Try_catch;

public class Fraccion {
	int zatikia;
	int zatitzailea;
	
	public Fraccion(int num, int cod) throws FractionException {
		super();
		this.zatikia = num;		
		if(cod == 0) {
			String str = "La fraccion tiene un formato erroneo.";
			throw new FractionException(str);
		}else {
			this.zatitzailea = cod;
		}
	}
	
	
	public Fraccion sumar(Fraccion f2) throws FractionException {
		Fraccion resultado = (new Fraccion(0,0));
		resultado.zatitzailea = this.zatitzailea * f2.zatitzailea;
		resultado.zatikia = (this.zatikia *(resultado.zatitzailea/ this.zatitzailea) + f2.zatikia *(resultado.zatitzailea/ f2.zatitzailea));
		
		return resultado;
	}
	
	public Fraccion restar(Fraccion f2) throws FractionException {
		Fraccion resultado = (new Fraccion(0,0));
		resultado.zatitzailea = this.zatitzailea * f2.zatitzailea;
		resultado.zatikia = (this.zatikia *(resultado.zatitzailea/ this.zatitzailea) - f2.zatikia *(resultado.zatitzailea/ f2.zatitzailea));
		
		return resultado;
	}

	public void dividir(Fraccion f2) {
		
		
	}
	
	
}
