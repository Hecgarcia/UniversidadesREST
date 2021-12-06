package com.ibm.academia.apirest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Pabellon;
 
@Repository
public interface PabellonRepository extends CrudRepository<Pabellon,Integer> {
	
	@Query(value = "select nombre,localidad from universidad.pabellones\r\n"
			     + "where localidad like '%a%';" )
	
	public Iterable<Pabellon> findPabellonByNombreIterable(String localidad);
	
	@Query (value = "select nombre,localidad from universidad.pabellones\r\n"
			       + "where nombre like '%e%';")
	
    public  Iterable<Pabellon> findByNombre(String nombre);
}
