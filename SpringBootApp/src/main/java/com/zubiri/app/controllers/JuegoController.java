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
import com.zubiri.app.services.CreadorService;
import com.zubiri.app.services.JuegoService;

@Controller
public class JuegoController {

	private JuegoService juegoService;
	private CreadorService creadorService;

	@Autowired
	public void setJuegoService(JuegoService juegoService) {
		this.juegoService = juegoService;
	}

	@Autowired
	public void setCreadorService(CreadorService creadorService) {
		this.creadorService = creadorService;
	}

	@GetMapping("/insertJuego")
	public String introducirJuego(Model m) {
		m.addAttribute("juego", new Juego());
		m.addAttribute("creadores", creadorService.mostrarCreadores());
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
		m.addAttribute("listaCreadores", creadorService.mostrarCreadores());
		m.addAttribute("juego", j);
		return "editJuego";
	}

	@GetMapping("/buscar")
	public String buscarJuego(@RequestParam String nombre, Model m) {
		m.addAttribute("juegos", juegoService.buscarJuegoNombre(nombre));
		return "mostrarJuegosBuscados";
	}

	@PutMapping("/modificarJuego")
	public String modificarJuego(@RequestParam String juegoNombre, int juegoId, String juegoGenero, int juegoPrecio,
			int creadorId) {
		Juego j = new Juego();
		System.err.println(juegoId);
		j.setId(juegoId);
		j.setNombre(juegoNombre);
		j.setGenero(juegoGenero);
		j.setPrecio(juegoPrecio);
		j.setCreador_id(creadorId);
		juegoService.editarJuego(j);
		return "index";
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
