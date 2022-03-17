package Try_catch;

public class main {

	public static void main(String[] args) throws FractionException {
		Fraccion f1 = new Fraccion(1,2);
		Fraccion f2 = new Fraccion(1,4);
		//System.out.println(f1.restar(f2).zatikia);
		try {
			Fraccion f3 = new Fraccion(1,0);
		}catch (FractionException e){
			System.out.println(e);
		}

	}

}
