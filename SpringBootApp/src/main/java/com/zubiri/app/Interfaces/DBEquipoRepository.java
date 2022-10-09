package com.zubiri.app.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zubiri.app.beans.Equipo;

public interface DBEquipoRepository extends JpaRepository<Equipo, Integer>{

}
