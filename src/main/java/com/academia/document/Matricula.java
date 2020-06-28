package com.academia.document;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
 

@Document(collection = "matriculas")
public class Matricula {
	
	@Id
	private String id;
	
	@NotEmpty(message = "Fecha no puede ser vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDate fechaMatricula;
	
	@DBRef 
	private Estudiante estudiante;
	
	@DBRef 
	private List<Curso> Listacursos;
	
	@NotEmpty
	private boolean estado;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<Curso> getListacursos() {
		return Listacursos;
	}

	public void setListacursos(List<Curso> listacursos) {
		Listacursos = listacursos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
		
}
