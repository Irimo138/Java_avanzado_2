package com.zubiri.app.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zubiri.app.beans.Juego;
import com.zubiri.app.services.JugadorService;

import antlr.collections.List;

import com.zubiri.app.services.JuegoService;

@Controller
public class JuegoController  {

	private JuegoService juegoService;
	private JugadorService creadorService;

	@Autowired
	public void setJuegoService(JuegoService juegoService) {
		this.juegoService = juegoService;
	}

	@Autowired
	public void setCreadorService(JugadorService creadorService) {
		this.creadorService = creadorService;
	}

	@GetMapping("/insertJuego")
	public String introducirJuego(Model m) {
		m.addAttribute("juego", new Juego());
		return "insertJuego";
	}

	@GetMapping("/buscarJuego")
	public String buscarJuego(Model m) {
		m.addAttribute("juego", new Juego());
		return "buscarJuego";
	}

	@GetMapping("/mostrarJuegos")
	public String showjuegos(Model j) {
		j.addAttribute("listaJuegos", juegoService.obtenerJuegos());
		// System.out.println(juegoService.obtenerJuegos().get(0).getId());
		return "showJuegos";
	}
	

	@GetMapping("/editaJuego")
	public String editarJuego(@RequestParam int idJuego, Model m) {
		// int x =Integer.parseInt(idJuego);
		Juego j = juegoService.buscarJuego(idJuego);
		m.addAttribute("juego", j);
		return "editJuego";
	}
	
	

	@GetMapping("/buscar")
	public String buscarJuego(@RequestParam String nombre, Model m) {
		ArrayList<Juego> lista = juegoService.buscarJuegoNombre(nombre);
		m.addAttribute("listaJuegos", lista);
		return "showJuegos";
	}
	
	/*@GetMapping("/obtenerJuegosPaginados")
	public ModelAndView obtenerPorNombre(ModelAndView m) {
		Page<Juego> lista = juegoService.obtenerTodosPorNombre();
		m.addObject("juegos", lista);
		m.setViewName("mostrarJuegosPaginacion");
		return m;
	}*/
	
	@GetMapping("/jugarPartida")
	public String prepararPartida(Model j) {
		j.addAttribute("jugadores", creadorService.mostrarJugador());
		j.addAttribute("juegos", juegoService.obtenerJuegos());
		return "seleccionarPartida";
	}
	
	
	@PostMapping("/simularPartida")
	public String jugarPartida(@RequestParam int jugador, int juego) {
		int puntuacion = (int) ((int) 1 + Math.random()*10000);
		if(puntuacion > 5000) {
			creadorService.ganaJuego(jugador);
		}
		juegoService.jugarPartida(juego, puntuacion, jugador);
		return "index";
	}

	@PutMapping("/modificarJuego")
	public String modificarJuego(@Valid @ModelAttribute Juego juego,  BindingResult thebindingresult, Model m) {
		if (thebindingresult.hasErrors()) {
			m.addAttribute("juego",juego);
			return "editJuego";
		}else {	
		juegoService.editarJuego(juego);
		return "index";
			}
	}
	
	@PutMapping("/modificarJuegoJDBC")
	public String modificarJuegoJDBC(@Valid @ModelAttribute Juego juego,  BindingResult thebindingresult, Model m) {
		if (thebindingresult.hasErrors()) {
			m.addAttribute("juego",juego);
			return "editJuego";
		}else {	
		juegoService.editarJuego(juego);
		return "index";
			}
	}
	
	@PostMapping("/guardaJuego")
	public String guardaJuegoJDBC(@Valid @ModelAttribute Juego juego, BindingResult thebindingresult) {
		if (thebindingresult.hasErrors()) {
			return "insertJuego";
		} else {
			juegoService.insertarJuego(juego);
			return "index";
		}
	}

	@PostMapping("/eliminaJuego")
	public String eliminarJuego(@RequestParam int idJuego) {
		juegoService.borrarJuego(idJuego);
		return "index";
	}
	
}
