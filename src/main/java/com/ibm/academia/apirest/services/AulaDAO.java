package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.models.entities.Aula;

public interface AulaDAO {
	
	
	public Iterable<Aula> buscarAulaPorTipoPizarron();
	
	public Iterable<Aula> buscarAulaPorNombrePabellon();
	
	public Iterable<Aula> buscarAulaPorNumero(Integer numeroAula);
	
	public Optional<Aula> buscarPorId(Integer id);
	public Aula guardar (Aula aula);
	public Iterable<Aula> buscarTodos();
	public void eliminarPorId(Integer id);

	public Aula actualizar(Aula aulaEncontrada, Aula aula);
	

}
