package com.zubiri.app.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zubiri.app.beans.Jugador;

public interface DBJugadorInterface extends JpaRepository<Jugador, Integer>{

}
