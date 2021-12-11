package com.ibm.academia.apirest.models.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CarreraDTO {
	
	private Integer id;
	
		
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 4, max = 80)
	private String   nombre;
	
    @Positive(message = "El valor minimo aceptado es 1")
	private Integer  cantidadMaterias;
	
    @Positive(message = "El valor debe ser mayor a 0")
	private Integer  cantidadAnios;
	


}
