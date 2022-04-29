package com.zubiri.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.EmpresaRepository;
import com.zubiri.app.beans.Empresa;

@Service 
public class EmpresaService{
	
	@Autowired
	EmpresaRepository empService;


	public void guardaEmp(Empresa e) {
		empService.save(e);		
	}


	public List<Empresa> allEmpresas() {
		List<Empresa> lista = (List<Empresa>) empService.findAll();
		
		return lista;
	}
	
	public ArrayList<Empresa> showEmpresaQuery(){
		return empService.showEmpresaQuery();
	}
	
	
	
}
