package com.example.demo.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Profesor;
import com.example.demo.connections.DBconection;




@Controller
public class ProfeController {
	private DBconection c1;
	public ProfeController(DBconection c) {
		c1 = c;
	}

	
	@GetMapping("/showProfes")
	public void listaProfes() throws SQLException {
		ArrayList<Profesor> lista = c1.enseñarProfesores();
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre());
		}
		//returnHome();
		
	}
	
	public String returnHome() {
		return "Consola.html";
	}
}