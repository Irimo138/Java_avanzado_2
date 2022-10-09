package com.zubiri.app.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	@GetMapping("/obtenerJuegosPaginados")
    public ModelAndView findAll(ModelAndView m){
		Page<Juego> lista = juegoService.obtenerTodosPorNombre();
		m.addObject("juegos", lista);
        return m;
    }
}
