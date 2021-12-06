package com.ibm.academia.apirest;

import java.math.BigDecimal;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Empleado;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.AulaDAO;
//import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.EmpleadoDAO;
import com.ibm.academia.apirest.services.PabellonDAO;
import com.ibm.academia.apirest.services.ProfesorDAO;
//import com.ibm.academia.apirest.services.PersonaDAO;

@Component
public class Comandos implements CommandLineRunner {
	
	//@Autowired
	//private ProfesorDAO  profesorDao;
	
	
	//@Autowired
	//private EmpleadoDAO  empleadoDao;
	
	//@Autowired
	//private CarreraDAO  carreraDao;
	
	//@Autowired
	//private AulaDAO  aulaDao;
	
	//@Autowired
	//private PabellonDAO  pabellonDao;

	
	@Override
	public void run(String... args) throws Exception {
		
		//List<Persona> profesoresCarreras = (List<Persona>) profesorDao.findProfesoresByCarrera("Derecho"); 
		//profesoresCarreras.forEach(a -> System.out.println(a));
		 
		//List<Carrera> carrerasNombre = (List<Carrera>) carreraDao.buscarCarrerasPorProfesorNombreYApellido("Edna", "Ramos");
		//carrerasNombre.forEach(a -> System.out.println(a));
		
		//Iterable<Persona> tipoEmpleados = empleadoDao.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
		//tipoEmpleados.forEach(a -> System.out.println(a));
		
		//List<Aula> aulaNombre = (List<Aula>) aulaDao.buscarAulaPorTipoPizarron();
		//aulaNombre.forEach(a -> System.out.println(a));
		
				
		//List<Aula> aulaNumero = (List<Aula>) aulaDao.buscarAulaPorNumero(6);
		//aulaNumero.forEach(a -> System.out.println(a));
		
		//List<Pabellon> pabellonLocalidad  = (List<Pabellon>) pabellonDaofindPabellonByNombreIterable();
	   //pabellonLocalidad.forEach(a -> System.out.println(a));
		
		
		//List<Pabellon> pabellonNombre = (List<Pabellon>) findByNombre();
		   //pabellonNombre.forEach(a -> System.out.println(a));
	}

}
