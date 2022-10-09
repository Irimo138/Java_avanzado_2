package com.zubiri.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBEntrenadorRepository;
import com.zubiri.app.Interfaces.DBEquipoRepository;
import com.zubiri.app.Interfaces.EntrenadorInterface;
import com.zubiri.app.beans.Entrenador;
import com.zubiri.app.beans.Equipo;

@Service
public class EntrenadorService implements EntrenadorInterface{
	
	@Autowired
	DBEntrenadorRepository DBEntrenador;
	
	@Autowired
	DBEquipoRepository DBEQuipo;

	@Override
	public Equipo mostrarEquipo(int i) {
		Equipo e = DBEQuipo.getById(i);
		return e;
	}

	@Override
	public void editarEntrenador(Entrenador e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entrenador buscarEntrenadorId(int i) {
		Entrenador e = DBEntrenador.getById(i);
		return e;
	}

	@Override
	public List<Entrenador> mostrarTodosLosEntrenadors() {
		List<Entrenador> lista = DBEntrenador.findAll();
		return lista;
	}

	@Override
	public void borrarEntrenador(int i) {
		DBEntrenador.deleteById(i);
		
	}

	@Override
	public void añadirEntrenador(Entrenador e) {
		DBEntrenador.save(e);
		
	}

}
