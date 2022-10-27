package com.zubiri.app.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zubiri.app.beans.Juego;
import com.zubiri.app.services.JuegoService;

@RestController
@RequestMapping("/api")
public class restJuegoController {

	private JuegoService juegoService;
	
	@Autowired
	public void setJuegoService(JuegoService juegoService) {
		this.juegoService = juegoService;
	}
	
	@GetMapping("/obtenerJuegos")
    public ModelAndView findAll(ModelAndView m){
		List<Juego> lista = juegoService.obtenerTodosPorNombre();
		m.addObject("juegos", lista);
		m.setViewName("MostrarJuegos");
        return m;
    }
}
