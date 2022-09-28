package com.zubiri.app.Interfaces;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.zubiri.app.beans.Juego;

public interface DBJuegosInterface extends CrudRepository<Juego, Long>{
	
}
