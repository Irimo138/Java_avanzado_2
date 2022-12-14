package com.zubiri.app.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zubiri.app.Interfaces.DBUserRepository;
import com.zubiri.app.beans.User;

@RestController
public class restUserController {
	
	@Autowired
	private DBUserRepository dbUserRepository;
	
	@GetMapping("/obtenerUsers")
    public List<User> findAll(ModelAndView m){
		List<User> lista = dbUserRepository.findAll();
        return lista;
    }
}
