package com.example.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.CreadoresInterface;
import com.zubiri.app.beans.Creador;

@Service
public class CreadorService implements CreadoresInterface{

	@Override
	public boolean insertarCreador(Creador c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Creador> mostrarCreadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarCreador(Creador c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editarCreador(Creador c) {
		// TODO Auto-generated method stub
		return false;
	}

}
