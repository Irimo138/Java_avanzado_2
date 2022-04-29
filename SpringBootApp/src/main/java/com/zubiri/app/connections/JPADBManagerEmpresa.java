package com.zubiri.app.connections;

import java.util.ArrayList;
import java.util.Optional;

import com.zubiri.app.Interfaces.EmpresaRepository;
import com.zubiri.app.beans.Empresa;

public class JPADBManagerEmpresa implements EmpresaRepository{

	@Override
	public <S extends Empresa> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Empresa> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Empresa> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Empresa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Empresa> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Empresa entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Empresa> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Empresa> showEmpresaQuery() {
		
		return null;
	}

	@Override
	public void editEmpresaQuery(Long id, String nombre) {
		
	}

}
