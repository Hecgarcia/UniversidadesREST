package com.ibm.academia.apirest.services;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.models.entities.Pabellon;
import com.ibm.academia.apirest.repositories.PabellonRepository;

@Service
public class PabellonDAOImpl implements PabellonDAO {
	
	@Autowired
	private PabellonRepository pabellonRepository;
	
	/*@Override
	@Transactional
	public Iterable<Pabellon> findPabellonByNombreIterable(String localidad) {
		
		return pabellonRepository.findPabellonByNombreIterable(localidad);
	}*/

	/*@Override
	@Transactional
	public Iterable<Pabellon> findByNombre(String nombre) {
		
		return pabellonRepository.findByNombre(nombre);
	}*/

	@Override
	@Transactional
	
	public Optional<Pabellon> buscarPorId(Integer id) {
		 
		return pabellonRepository.findById(id);
	}

	@Override
	@Transactional
	public Pabellon guardar(Pabellon pabellon) {
		 
		return pabellonRepository.save(pabellon);
	}

	@Override
	@Transactional (readOnly = true)
	public Iterable<Pabellon> buscarTodos() {
		 
		return pabellonRepository.findAll();
	}

	@Override
	@Transactional
	public void eliminarPorId(Integer id) {
		 
		pabellonRepository.deleteById(id);
	}

	
	
	

}
