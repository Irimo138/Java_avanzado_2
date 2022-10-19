package com.zubiri.app.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zubiri.app.beans.Partida;

public interface DBPartidasRepository extends JpaRepository<Partida, Integer> {
	
}
