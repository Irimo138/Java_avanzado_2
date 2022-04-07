package com.zubiri.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.services.JuegoService;
import com.zubiri.app.Interfaces.JuegosInterface;
import com.zubiri.app.beans.Juego;


@Controller
public class HomeController {
	
	@Autowired
	private JuegosInterface JuegoService;

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
		JuegoService.obtenerJuegos();
		return "showJuegos";	
	}
	
	//Funciona si pones RestController
	@PostMapping("/guardaJuego")
	public String guardaJuego(@ModelAttribute Juego J) {
		JuegoService.insertarJuego(J);
		return "index";
	}

}
