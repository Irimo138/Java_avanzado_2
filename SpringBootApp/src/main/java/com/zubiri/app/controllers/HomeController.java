package com.zubiri.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubiri.app.beans.Juego;
import com.zubiri.app.services.JuegoService;


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
	public String showjuegos(Model j) {
		j.addAttribute("listaJuegos", juegoService.obtenerJuegos());
		//System.out.println(juegoService.obtenerJuegos().get(0).getId());
		return "showJuegos";	
	}
	
	@GetMapping("/editaJuego")
	public String editarJuego(Juego j, Model m) {
		m.addAttribute("Juego", j);
		return "index";
	}
	
	@PostMapping("/guardaJuego")
	public String guardaJuego(@ModelAttribute Juego J) {
		juegoService.insertarJuego(J);
		return "index";
	}

	@PostMapping("/eliminaJuego")
	public String eliminarJuego(@RequestParam int idJuego) {
		juegoService.borrarJuego(idJuego);
		return "index";
	}
}
