package com.academia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.document.Estudiante;
import com.academia.repo.IEstudianteRepo;
import com.academia.repo.IGenericRepo;
import com.academia.service.IEstudianteService;

@Service
public class EstudianteServiceImpl extends ICRUDImpl<Estudiante, String> implements IEstudianteService{
	@Autowired
	private IEstudianteRepo repo;
	
	@Override
	protected IGenericRepo<Estudiante, String> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	} 
	
}

