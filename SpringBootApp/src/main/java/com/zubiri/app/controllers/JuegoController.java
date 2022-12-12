package com.zubiri.app.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
import com.zubiri.app.beans.Partida;
import com.zubiri.app.beans.Partida.Id;
import com.zubiri.app.services.JuegoService;
import com.zubiri.app.services.JugadorService;

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
	
	@GetMapping("/apiExterna")
	public String apiExterna() {
		return "showAPI";
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
		j.addAttribute("partida", new Partida());
		j.addAttribute("juegos", juegoService.obtenerJuegos());
		return "seleccionarPartida";
	}
	
	
	@PostMapping("/simularPartida")
	public String jugarPartida(@ModelAttribute Partida p, int jugador_id, int juego_id) {
		int puntuacion = (int) ((int) 1 + Math.random()*10000);
			juegoService.jugarPartida(juego_id, puntuacion, jugador_id);
			p.setJuego(juegoService.buscarJuego(juego_id));
			p.setJugador(creadorService.buscarCreador(jugador_id));
			p.setPuntuacion(puntuacion);
			p.setId(new Id(jugador_id, juego_id, LocalDateTime.now()));
			/*System.err.println(p.getJuego().getNombre());
			System.err.println(p.getJugador().getNombre());
			System.err.println(p.getAddedOn());*/
			creadorService.ganaJuego(p);
		return "redirect:/";
	}

	@PutMapping("/modificarJuego")
	public String modificarJuego(@Valid @ModelAttribute Juego juego,  BindingResult thebindingresult, Model m) {
		if (thebindingresult.hasErrors()) {
			m.addAttribute("juego",juego);
			return "editJuego";
		}else {	
		juegoService.editarJuego(juego);
		return "redirect:/";
			}
	}
	
	@PostMapping("/guardaJuego")
	public String guardaJuegoJDBC(@Valid @ModelAttribute Juego juego, BindingResult thebindingresult) {
		if (thebindingresult.hasErrors()) {
			return "insertJuego";
		} else {
			juegoService.insertarJuego(juego);
			return "redirect:/";
		}
	}

	@PostMapping("/eliminaJuego")
	public String eliminarJuego(@RequestParam int idJuego) {
		juegoService.borrarJuego(idJuego);
		return "redirect:/";
	}
	
}
