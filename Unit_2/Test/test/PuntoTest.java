package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import POO.Punto;
import junit.framework.TestCase;

class PuntoTest extends TestCase{

	@Test
	public void testCuadrante() {
		Punto p = new Punto(2, -3);
		System.out.println(p.cuadrante());
	}

}
