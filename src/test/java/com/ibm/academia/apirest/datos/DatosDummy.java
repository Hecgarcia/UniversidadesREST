package com.ibm.academia.apirest.datos;


import java.math.BigDecimal;

import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Direccion;
import com.ibm.academia.apirest.models.entities.Empleado;
import com.ibm.academia.apirest.models.entities.Persona;

public class DatosDummy {
	
	
	public static Carrera carrera01() {
		
		return new Carrera(null, "Ingenieria en Redes", 50, 5);
	}
	
    public static Carrera carrera02() {
		
		return new Carrera(null, "Licenciatura en Redes", 60, 4);
	}
    
    public static Carrera carrera03() {
		
		return new Carrera(null, "Turismo", 40, 4);
	}

	public static Empleado empleado01() {
		
		return  new Empleado(null, "Miguel", "Lopez", "695225", new Direccion(), new BigDecimal("59874.22"), TipoEmpleado.ADMINISTRATIVO);
	}

	public static Persona alumno01() {
		
		return null;
	}
	
}
