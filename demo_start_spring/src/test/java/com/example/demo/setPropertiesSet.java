package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.ProfesorMas;
@SpringBootTest
class setPropertiesSet {

	@Autowired
	ProfesorMas profe;
	
	@Test
	public void profeAllNullTest() {
		//System.out.println("profe: "+profe);
		assertAll(
				()->assertNotNull(profe.getcurso()),
				()->assertNotNull(profe.getP())
				);
	}


}