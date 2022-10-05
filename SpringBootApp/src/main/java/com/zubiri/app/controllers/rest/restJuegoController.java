package com.zubiri.app.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zubiri.app.beans.Juego;
import com.zubiri.app.services.JuegoService;

@RestController
public class restJuegoController {

	private JuegoService juegoService;
	
	@Autowired
	public void setJuegoService(JuegoService juegoService) {
		this.juegoService = juegoService;
	}
	
	@GetMapping("/obtenerPorNombre")
    public ModelAndView findAll(ModelAndView m){
		Page<Juego> lista = juegoService.obtenerTodosPorNombre();
		m.addObject("juegos", lista);
		m.setViewName("mostrarJuegosPaginacion");
        return m;
    }
}
