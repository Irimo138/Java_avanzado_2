package com.zubiri.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.services.JuegoService;
import com.zubiri.app.beans.Juego;


@Controller
public class HomeController {

	private JuegoService juegoService;
	
	@Autowired
	public void setJuegoService(JuegoService juegoService) {
		this.juegoService = juegoService;
	}


	@GetMapping("/")
	public String home() {
		return "index";
	}
	

	@GetMapping("/insertJuego")
	public String introducirJuego() {
		return "form";
	}
	
	@GetMapping("/mostrarJuegos")
	public String showjuegos() {
		juegoService.obtenerJuegos();
		return "showJuegos";	
	}
	
	//Funciona si pones RestController
	@PostMapping("/guardaJuego")
	public String guardaJuego(@ModelAttribute Juego J) {
		juegoService.insertarJuego(J);
		return "index";
	}

}
