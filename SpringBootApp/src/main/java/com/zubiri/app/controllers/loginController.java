package com.zubiri.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zubiri.app.Interfaces.DBUserRepository;
import com.zubiri.app.beans.User;

@Controller
public class loginController {
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DBUserRepository userRepository;

	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView m = new ModelAndView();
		m.setViewName("formulario.html");
		return m;
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestParam String password, String nombre) {
		String passString = bCryptPasswordEncoder.encode(password);
		userRepository.save(new User(nombre, passString, null, null));
		return "redirect:/index";
	}
	
	@GetMapping("/addUsers")
	public String Register() {
		String passString = bCryptPasswordEncoder.encode("12345");
		String name = "IriA";
		String rol = "ADMIN";
		userRepository.save(new User(name, passString, null, rol));
		String name2 = "IriM";
		String rol2 = "MANAGER";
		userRepository.save(new User(name2, passString, null, rol2));
		return "Agregado";
	}
	
}
