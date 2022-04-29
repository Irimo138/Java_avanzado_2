package com.zubiri.app.controllers;

import org.springframework.stereotype.Controller;

import com.zubiri.app.Interfaces.JDBC_Interface;
import com.zubiri.app.beans.Juego;
import com.zubiri.app.beans.Jugador;

@Controller
public class JDBC_Controller implements JDBC_Interface{

	
	@Override
	public Juego saveGame(Juego j) {
		/*
		j.setId_jugador(new Jugador().getId());
		*/
		return null;
	}
	

	@Override
	public Jugador save(Jugador j) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
