package com.ibm.academia.apirest.services;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.repositories.AulaRepository;

@Service
public class AulaDAOImpl implements AulaDAO {
	
	@Autowired
	private AulaRepository aulaRepository;

	@Override
	@Transactional (readOnly = true)
	public Optional<Aula> buscarPorId(Integer id) {
		
		return aulaRepository.findById(id);
	}

	@Override
	@Transactional
	public Aula guardar(Aula aula) {
		
		return aulaRepository.save(aula);
	}

	@Override
	@Transactional (readOnly = true)
	public Iterable<Aula> buscarTodos() {

		return aulaRepository.findAll();
	}

	@Override
	@Transactional
	public void eliminarPorId(Integer id) {

		aulaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Iterable<Aula> buscarAulaPorTipoPizarron() {
		
		return aulaRepository.buscarAulaPorTipoPizarron();
	}

	@Override
	@Transactional
	public Iterable<Aula> buscarAulaPorNumero(Integer numeroAula) {
		
		return aulaRepository.buscarAulaPorNumero(numeroAula);
	}

	@Override
	@Transactional
	public Iterable<Aula> buscarAulaPorNombrePabellon() {
		
		return null;
	}
	
	@Override
	@Transactional
	public Aula actualizar(Aula aulaEncontrada, Aula aula){
		Aula aulaActualizada = null;
		aulaActualizada.setCantidadPupitres(aula.getCantidadPupitres());
		aulaActualizada.setMedidas(aula.getMedidas());
		aulaActualizada.setPizarron(aula.getPizarron());
		aulaActualizada = aulaRepository.save(aulaEncontrada);
		return aulaActualizada;
	}
	

}
