package com.zubiri.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.CreadoresInterface;
import com.zubiri.app.beans.Creador;
import com.zubiri.app.connections.DBManagerCreadores;
import com.zubiri.app.connections.DBManagerJuegos;

@Service
public class CreadorService implements CreadoresInterface{

	private DBManagerCreadores dbManagerCreadores;
	
	public CreadorService(DBManagerCreadores dbManagerCreadores) {
		this.dbManagerCreadores = dbManagerCreadores;
	}

	@Override
	public boolean insertarCreador(Creador c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Creador> mostrarCreadores() {
		
		return dbManagerCreadores.mostrarCreadores();
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
