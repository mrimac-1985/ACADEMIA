package com.academia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.document.Matricula;
import com.academia.repo.IGenericRepo;
import com.academia.repo.IMatriculaRepo;
import com.academia.service.IMatriculaService;
 
@Service
public class MatriculaServiceImpl extends ICRUDImpl<Matricula, String> implements IMatriculaService{

	@Autowired
	private IMatriculaRepo repo;
	
	@Override
	protected IGenericRepo<Matricula, String> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
 
  
}
