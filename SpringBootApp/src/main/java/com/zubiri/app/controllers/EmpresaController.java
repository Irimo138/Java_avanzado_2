package com.zubiri.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zubiri.app.beans.Empresa;
import com.zubiri.app.services.EmpresaService;

@Controller
public class EmpresaController{
	EmpresaService empServ;
	
	@Autowired
	public void setEmpService(EmpresaService empServ) {
		this.empServ = empServ;
	}
	
	
	@GetMapping("/emp")
	public String muestraFormEmpresa() {
		return "EmpForm";
	}
	
	@GetMapping("/showAllEmp")
	public String MuestraAllEmpresas(Model m) {
		m.addAttribute("listaEmpresas", empServ.allEmpresas());
		return "showEmpresas";
	}
	
	@PostMapping("/saveEmpresa")
	public String guardaEmpresa(@ModelAttribute Empresa e) {
		empServ.guardaEmp(e);
		return "index";
	}
	
	
	@PostMapping("/editEmpresa")
	public String editEmpresa(@ModelAttribute Empresa e) {
		empServ.guardaEmp(e);
		return "index";
	}
}