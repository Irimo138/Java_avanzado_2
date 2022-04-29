package com.zubiri.app.Interfaces;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zubiri.app.beans.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
	
	@Query(value ="Select * from empresa", nativeQuery = true)
	 ArrayList<Empresa> showEmpresaQuery();
	
	@Modifying
	@Transactional
	@Query("UPDATE Empresa e SET c.nombre = :nombre WHERE c.id = :id")
	void editEmpresaQuery(Long id, String nombre);

	
}
