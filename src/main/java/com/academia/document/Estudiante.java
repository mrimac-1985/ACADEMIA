package com.academia.document;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
public class Estudiante {
	
	@Id
	private String id;

	@NotEmpty(message = "Nombre estudiante no puede ser vacio")
	private String nombreEstudiante;
	
	@NotEmpty(message = "Apellidos no puede ser vacio")
	private String Apellidos;
	
	@NotEmpty(message = "DNI no puede ser vacio")
	private String dni;
	
	@NotEmpty(message = "Edad no puede ser vacio")
	private Double edad;
	
	@NotEmpty
	private boolean estado;

	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	

}
