package com.example.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Pojo;

@SpringBootTest
class DemoStartSpringApplicationTests {

	private Pojo pojo;

	@Autowired
	public void setPojo(Pojo pojo) {
		this.pojo = pojo;
	}
	
	@Test
	public void whenAutowiringProject_thenPropertyNotNull() {
		System.out.println("pojo:"+pojo);
		assertNotNull(pojo);
	}

}
