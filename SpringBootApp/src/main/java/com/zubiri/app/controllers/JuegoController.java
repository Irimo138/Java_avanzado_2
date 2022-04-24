package com.zubiri.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubiri.app.beans.Juego;
import com.zubiri.app.services.JugadorService;
import com.zubiri.app.services.JuegoService;

@Controller
public class JuegoController {

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
		m.addAttribute("juegos", juegoService.buscarJuegoNombre(nombre));
		return "mostrarJuegosBuscados";
	}
	
	@GetMapping("/jugarPartida")
	public String prepararPartida(Model j) {
		j.addAttribute("jugadores", creadorService.mostrarJugador());
		j.addAttribute("juegos", juegoService.obtenerJuegos());
		return "seleccionarPartida";
	}
	
	@PostMapping("/simularPartida")
	public String jugarPartida(@RequestParam int jugador, int juego) {
		int puntuacion = (int) ((int) 1 + Math.random()*10000);
		System.err.println(puntuacion);
		if(puntuacion > 5000) {
			creadorService.ganaJuego(jugador);
		}
		juegoService.jugarPartida(juego, puntuacion);
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

	@PostMapping("/guardaJuego")
	public String guardaJuego(@Valid @ModelAttribute Juego juego, BindingResult thebindingresult) {
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
