package com.ibm.academia.apirest.repositories;


//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.ibm.academia.apirest.entities.Persona;

@Repository("repositorioProfesor")
public interface ProfesorRepository extends PersonaRepository {
	
	//@Query("select a from Profesor a join fetch Carrera c on c.nombre = ?1")
	//public Iterable<Persona> findProfesoresByCarrera(String nombre);

}
