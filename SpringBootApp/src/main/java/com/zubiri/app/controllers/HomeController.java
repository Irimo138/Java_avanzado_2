package com.zubiri.app.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.zubiri.app.Connections.DBconnection;
import com.zubiri.app.beans.Juego;

@Controller
public class HomeController {
	
	DBconnection c1;
	public HomeController(DBconnection c) {
		c1 = c;
	}
	ArrayList<Juego> Lista;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/insertJuego")
	public String introducirJuego() {
		return "juegosForm";
	}
	
	@GetMapping("/mostrarJuegos")
	public String showjuegos() {
		try {
			Lista = c1.mostrarJuegos();
			System.out.println(Lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showJuegos";
		
	}

}
