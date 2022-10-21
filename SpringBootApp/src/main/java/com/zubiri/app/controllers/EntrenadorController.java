package com.zubiri.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubiri.app.beans.Direccion;
import com.zubiri.app.beans.Entrenador;
import com.zubiri.app.services.EntrenadorService;
import com.zubiri.app.services.EquipoService;

@Controller
public class EntrenadorController {

	@Autowired
	private EntrenadorService entrenadorService;
	
	@Autowired
	private EquipoService equipoService;
	
	@GetMapping("/insertEntrenador")
	public String introducirEntrenador(Model m) {
		m.addAttribute("entrenador", new Entrenador());
		m.addAttribute("equipos", equipoService.mostrarTodosLosEquipos());
		return "InsertEntrenador";
	}
	
	@GetMapping("/mostrarAllEntrenadores")
	public String MostrarAllEntrenadores(Model m) {
		m.addAttribute("listaEntrenador", entrenadorService.mostrarTodosLosEntrenadors());
		return "showEntrenadores";
	}
	
	@GetMapping("/editaent")
	public String editarEntrenador(@RequestParam int ident, Model m) {
			Entrenador entre = entrenadorService.buscarEntrenadorId(ident);
			m.addAttribute("equipos", equipoService.mostrarTodosLosEquipos());
			m.addAttribute("entrenador",entre);
			return "editEntrenador";
		
	}
	
	
	@PostMapping("/guardarEntrenador")
	public String guardaEntrenador(@ModelAttribute Entrenador e, Direccion d, BindingResult thebindingresult) {
		if (thebindingresult.hasErrors()) {
			return "insertEntrenador";
		} else {
			e.setDireccion(d);
			entrenadorService.añadirEntrenador(e);
			return "redirect:/";
		}
	}
	
	@PostMapping("/modificarentrenador")
	public String EditarDBEntrenador(@Valid @ModelAttribute Entrenador e, Direccion d,@RequestParam int idEquipo, BindingResult thebindingresult) {
		e.setDireccion(d);
		e.setEquipo(equipoService.buscarEquipoId(idEquipo));
		entrenadorService.editarEntrenador(e);
		return "redirect:/";
	}
	
	
	@PostMapping("/eliminaent")
	public String eliminarEntrenador(@RequestParam int ident, Model m)  {
			entrenadorService.borrarEntrenador(ident);
			return "redirect:/";
	}
}
