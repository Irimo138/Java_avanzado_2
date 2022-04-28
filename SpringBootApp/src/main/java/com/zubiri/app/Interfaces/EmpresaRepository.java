package com.zubiri.app.Interfaces;

import org.springframework.data.repository.CrudRepository;

import com.zubiri.app.beans.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
	
	
}
