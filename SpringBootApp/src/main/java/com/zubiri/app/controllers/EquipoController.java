package com.zubiri.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubiri.app.beans.Empresa;
import com.zubiri.app.beans.Equipo;
import com.zubiri.app.services.EmpresaService;
import com.zubiri.app.services.EquipoService;

@Controller
public class EquipoController{
	EquipoService equipoService;
	
	@Autowired
	public void setEmpService(EquipoService equipoService) {
		this.equipoService = equipoService;
	}
	
	
	@GetMapping("/insertEquipo")
	public String muestraFormEmpresa(Model m) {
		m.addAttribute("equipo", new Equipo());
		return "InsertEquipo";
	}
	
	@GetMapping("/showAllEquipos")
	public String MuestraAllEmpresas(Model m) {
		m.addAttribute("listaEquipos", equipoService.mostrarTodosLosEquipos());
		return "showEquipos";
	}
	
	@GetMapping("/editaFormEquipo")
	public String mostrarFormEditEquipo(@RequestParam int idEquipo, Model m) {
		m.addAttribute("equipo", equipoService.buscarEquipoId(idEquipo));
		return "editEquipo";
	}
	
	@PostMapping("/saveEquipo")
	public String guardaEmpresa(@ModelAttribute Equipo e) {
		equipoService.añadirEquipo(e);
		return "redirect:/";
	}
	
	
	@PostMapping("/editEquipo")
	public String editEmpresa(@ModelAttribute Equipo e) {
		equipoService.editarEquipo(e);
		return "redirect:/";
	}
	
	@PostMapping("/eliminarEquipo")
	public String liminarEquipo(@RequestParam int idEquipo) {
		equipoService.borrarEquipo(idEquipo);
		return "redirect:/";
	}
}