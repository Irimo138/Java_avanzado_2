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

import com.zubiri.app.beans.Entrenador;
import com.zubiri.app.services.EntrenadorService;

@Controller
public class EntrenadorController {

	@Autowired
	private EntrenadorService entrenadorService;
	
	@GetMapping("/insertEntrenador")
	public String introducirEntrenador(Model m) {
		m.addAttribute("entrenador", new Entrenador());
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
			m.addAttribute("entrenador",entre);
			return "editEntrenador";
		
	}
	
	
	@PostMapping("/guardarEntrenador")
	public String guardaEntrenador(@ModelAttribute Entrenador e, BindingResult thebindingresult) {
		if (thebindingresult.hasErrors()) {
			return "insertEntrenador";
		} else {
			entrenadorService.añadirEntrenador(e);
			return "redirect:/";
		}
	}
	
	@PostMapping("/modificarentrenador")
	public String EditarDBEntrenador(@Valid @ModelAttribute Entrenador e, BindingResult thebindingresult) {
		entrenadorService.editarEntrenador(e);
		return "redirect:/";
	}
	
	
	@PostMapping("/eliminaent")
	public String eliminarEntrenador(@RequestParam int ident, Model m)  {
			entrenadorService.borrarEntrenador(ident);
			return "redirect:/";
	}
}
