package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import POO.Banco;

class TestCuenta {

	@Test
	void TestDeposito() {
		Banco B = new Banco("Iriarte");
		B.deposito(new BigDecimal("400"));
	}

}