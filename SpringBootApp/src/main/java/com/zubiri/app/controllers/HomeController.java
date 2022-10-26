package com.zubiri.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubiri.app.beans.Juego;
import com.zubiri.app.services.JugadorService;
import com.zubiri.app.services.JuegoService;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Index";
	}
	
	@GetMapping("/consultarDatos")
	public String ConsultarDatos() {
		return "ConsultarDatos";
	}
	
}
