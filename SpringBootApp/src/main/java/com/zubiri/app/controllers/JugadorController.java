package com.zubiri.app.controllers;

import java.util.List;

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

import com.zubiri.app.beans.Direccion;
import com.zubiri.app.beans.Jugador;
import com.zubiri.app.beans.Partida;
import com.zubiri.app.services.JugadorService;


@Controller
public class JugadorController {
	private JugadorService creadorService;
	
	@Autowired
	public void setCreadorService(JugadorService creadorService) {
		this.creadorService = creadorService;
	}
	
	@GetMapping("/insertJugador")
	public String introducirCreador(Model m) {
		m.addAttribute("direccion", new Direccion());
		m.addAttribute("jugador", new Jugador());
		return "CreadorForm";
	}
	
	@GetMapping("/mostrarJugador")
	public String mostrarCreador(Model m) {
		List<Jugador> lista = creadorService.mostrarJugador();
		m.addAttribute("listaJugadores", lista);
		return "showCreador";
	}
	
	@GetMapping("/editarJugador")
	public String editarCreador(@RequestParam int idCreador, Model m) {
		// int x =Integer.parseInt(idJuego);
		Jugador j = creadorService.buscarCreador(idCreador);
		m.addAttribute("jugador", j);
		return "editCreador";
	}
	
	@PostMapping("/eliminarJugador")
	public String eliminarJugador(@RequestParam int idCreador) {
		creadorService.eliminarJugador(idCreador);
		return "redirect:/";
	}

	
	@PutMapping("/modificarJugador")
	public String modificarJuego(@Valid @ModelAttribute Jugador j, BindingResult thebindingresult, Model m) {
		if (thebindingresult.hasErrors()) {
			m.addAttribute("jugador",j);
			return "editCreador";
		}else{
		creadorService.editarJugador(j);
		return "redirect:/";
		}
	}
	
	@PostMapping("/guardaJugador")
	public String guardaCreador(@Valid @ModelAttribute Jugador j, Direccion d, BindingResult thebindingresult) {
		if (thebindingresult.hasErrors()) {
			return "CreadorForm";
		} else {
			j.setDireccion(d);
			creadorService.insertarJugador(j);
			return "redirect:/";
		}	
	}
}
