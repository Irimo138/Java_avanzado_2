package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Profesor;
import com.example.demo.connections.DBconection;

@RestController
@RequestMapping("/testRequest")
public class ResourceController {
	private DBconection c1;
	Profesor p;
	public ResourceController(DBconection c) {
		c1 = c;
	}
		
	
			
			@GetMapping("/{nombre}")
			public Profesor getProfesor(@PathVariable String nombre) throws SQLException {
				ArrayList<Profesor> lista = c1.enseñarProfesores();
				
				for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
					//System.out.println(lista.get(i).getNombre());
					p = new Profesor();
					p.setNombre(lista.get(i).getNombre());
					p.setEdad(lista.get(i).getEdad());
					}
				}
				return p;
				
			}
			@GetMapping("/todos")
			public ArrayList<Profesor> getAllProfesor() throws SQLException {
				ArrayList<Profesor> lista = c1.enseñarProfesores();
				return lista;
				
			}
			
			
		}
	

