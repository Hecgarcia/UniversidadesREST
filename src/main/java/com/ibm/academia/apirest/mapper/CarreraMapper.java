package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.CarreraDTO;
import com.ibm.academia.apirest.models.entities.Carrera;

public class CarreraMapper {
	
	public static CarreraDTO mapCarrera(Carrera carrera) {
		
		CarreraDTO carreraDTO = new CarreraDTO();
		carreraDTO.setId(carrera.getId());
		carreraDTO.setNombre(carrera.getNombre());
		carreraDTO.setCantidadMaterias(carrera.getCantidadMaterias());
		carreraDTO.setCantidadAnios(carrera.getCantidadAnios());
		return carreraDTO;
	}

}
