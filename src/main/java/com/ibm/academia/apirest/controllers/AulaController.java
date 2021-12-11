package com.ibm.academia.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.services.AulaDAO;


@RestController
@RequestMapping("/aula")
public class AulaController {
	
	@Autowired
	private AulaDAO aulaDao;
	
	/**
	 *Endoint para obtener lista de carreras
	 * @return Retorna un objeto de tipo Carrera con la lista de carreras
	 * @BadRequestaException en caso de no encontrar ninguna carrea
	 * @author Hector Garcia 09-12-2021
	 */
	
	@GetMapping("/lista/aulas")
	public List<Aula> buscarTodas(){
		
		List<Aula> aulas = (List<Aula>) aulaDao.buscarTodos();
		if(aulas.isEmpty())
			throw new BadRequestException("No existen aulas");
		
		return aulas;
	
	}
	
	/**
	 * EndPoint para buscar una aula por ID
	 * @param aulaId
	 * @return regresa los datos del aula 
	 * @BadRequestaException en caso de no encontrar el aula por id
	 * @author Hector Garcia 09-12-2021
	 */
	@GetMapping("/id/{aulaId}")
	public Aula  buscarAulaPorId(@PathVariable Integer aulaId) {
		
		Aula aula = aulaDao.buscarPorId(aulaId).orElse(null);
		if(aula == null)
			throw new BadRequestException(String.format("La aula con ID; %d no existe", aulaId));
		return aula;
		
	}
	
	/**
	 *EndPoint para Dar de alta un objeto de tipo aula
	 * @param carrera se ingresan los campos obligatorios 
	 * @@return lista de errores segun el dato incorrecto
	 * @author Hector Garcia Espinobarro 09-12-21
	 */
	@PostMapping
	public ResponseEntity<?> guardarAula (@Valid @RequestBody Aula aula, BindingResult result) {
		
		Map<String, Object > validaciones = new HashMap<String, Object>();
		
		if (result.hasErrors()) {
			
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + " ' " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
			
		}
		
		Aula aulaGuardada = aulaDao.guardar(aula);
		
		return new ResponseEntity<Aula>(aulaGuardada, HttpStatus.CREATED);
		
	}
	
	/**
	 * Endoint para actualizar un objeto de tipo aula
	 * @param carreraId Parametro para buscar la aula
	 * @param carrera Objeto con la informacion de aula
	 * @return Retorna un objeto de tipo Aula con la informaci�n actualizada
	 * @NotFoundException En caso de que falle actualizando el objeto Aula
	 * @author Hector Garcia 09-12-2021
	 */
	@PutMapping("/upd/aulaId/{aulaId}")
	public ResponseEntity<?> actualizarAula(@PathVariable Integer aulaId, @RequestBody Aula aula){
		Optional<Aula> oAula = aulaDao.buscarPorId(aulaId);
		
		if(!oAula.isPresent())
			throw new NotFoundException(String.format("La Aula con ID: %d no existe",aulaId));
		
		Aula aulaActualizada = aulaDao.actualizar(oAula.get(), aula); 
		
		return new ResponseEntity<Aula>(aulaActualizada, HttpStatus.OK); 
	}
	
	/**
	 * EndPoint para eliminar un aula por Id
	 * @param aulaId 
	 * @NotFoundException En caso de que no encuentre ningun aula por ID en la base de datos
	 * @author Hector Garcia 08-12-2021
	 */
	@DeleteMapping("/aulaId/{aulaId}")
	public ResponseEntity<?> eliminarAula(@PathVariable Integer aulaId){
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		Optional<Aula> aula = aulaDao.buscarPorId(aulaId);
		
		if(!aula.isPresent())
			throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));
		
		aulaDao.eliminarPorId(aulaId);
		respuesta.put("OK", "Aula ID: " + aulaId + " eliminada exitosamente");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
	}

}
