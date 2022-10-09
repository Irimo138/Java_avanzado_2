package com.zubiri.app.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.descriptor.TaglibDescriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBEquipoRepository;
import com.zubiri.app.Interfaces.EquipoInterface;
import com.zubiri.app.beans.Equipo;
import com.zubiri.app.beans.Jugador;

@Service
public class EquipoService implements EquipoInterface{

	@Autowired
	DBEquipoRepository dbEquipo;
	
	@Override
	public void añadirEquipo(Equipo e) {
		dbEquipo.save(e);
	}

	@Override
	public Equipo buscarEquipoId(int i) {
		Equipo e = dbEquipo.getById(i);
		return e;
	}

	@Override
	public void editarEquipo(Equipo e) {
		
	}

	@Override
	public List<Jugador> mostrarJugadoresIdEqupo(int i) {
		return null;
	}

	@Override
	public List<Equipo> mostrarTodosLosEquipos() {
		List<Equipo> lista = dbEquipo.findAll();
		return lista;
	}

	@Override
	public void borrarEquipo(int i) {
		dbEquipo.deleteById(i);
		
	}

}
