package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import POO.Palindromo;

class PalindromoTest {

	@Test
	void testConstructor() {
		Palindromo p = new Palindromo(24L);
		assertEquals(24L, p.getNum());
	}
	
	@Test
	void testContarCifras() {
		Palindromo p = new Palindromo(24L);
		p.contarCifras();
	}
	
	@Test
	void testDigito() {
		Palindromo p = new Palindromo(24L);
		p.digito(2);
	}
	
		

}
 