package com.zubiri.app.Interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.zubiri.app.beans.Juego;

public interface DBJuegosRepository extends JpaRepository<Juego, Integer>{
	
}
