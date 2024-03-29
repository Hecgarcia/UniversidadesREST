 package com.ibm.academia.apirest.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "alumnos", schema = "universidad")
//@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona {
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","alumnos"})
	private Carrera carrera;
	
	public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
		super(id, nombre, apellido, dni, direccion);
	
	}
	
	

	@Override
	public String toString() {
		return super.toString() + "\tAlumno []";
	}



	private static final long serialVersionUID = 282135527639709536L;
	
	

}
