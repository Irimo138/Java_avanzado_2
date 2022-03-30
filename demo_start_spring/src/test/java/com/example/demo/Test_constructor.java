package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test_constructor {

	@Autowired
	private Profesor profe;

	
	
	@Test
	public void profeNullTest() {
		//System.out.println("profe: "+profe);
		assertNotNull(profe);
	}
	
	@Test
	public void profeAllNullTest() {
		//System.out.println("profe: "+profe);
		assertAll(
				()->assertNotNull(profe.getNombre()),
				()->assertNotNull(profe.getEdad())
				);
	}

}

