package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Pabellon;

public interface PabellonDAO {
	
	public Iterable<Pabellon> findPabellonByNombreIterable(String localidad);
	
	 public  Iterable<Pabellon> findByNombre(String nombre);
	
	public Optional<Pabellon>buscarPorId(Integer id);
	public Pabellon guardar (Pabellon pabellon);
	public Iterable<Pabellon> buscarTodos();
	public void eliminarPorId(Integer id);


}
