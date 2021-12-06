package com.ibm.academia.apirest.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Aula;



@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {
	
	@Query (value = "select id,tipo_pizarron \r\n"
			+ "from universidad.aulas\r\n"
			+ "where tipo_pizarron = 'PIZARRA_TIZA';", nativeQuery = true )
	public Iterable<Aula> buscarAulaPorTipoPizarron();
	
    @Query(value = "select *\r\n"
    		+ "from universidad.aulas as a\r\n"
    		+ "inner join universidad.pabellones as p \r\n"
    		+ "on a.id = p.id where p.nombre = 'Redes';", nativeQuery = true)
    public Iterable<Aula> buscarAulaPorNombrePabellon ();
	
	
	 @Query("select a from Aula a where a.numeroAula = ?1")
	 public Iterable<Aula> buscarAulaPorNumero(Integer numeroAula);

	
	

}
