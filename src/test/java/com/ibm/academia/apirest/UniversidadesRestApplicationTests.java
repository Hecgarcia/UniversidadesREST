package com.ibm.academia.apirest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class UniversidadesRestApplicationTests {
	
	Calculadora calculadora = new Calculadora();
	
	@Test
	@DisplayName("Test: Sumar 2 valores")
	void sumarValores() {
		
		//Given:  define el contexto y la precondición 
		
		Integer valorA = 1;
		Integer valorB = 4;
		
		//Then: Es cuando se ejecuta la acción, quiere decir , que se quiere probar.
		Integer expected =  calculadora.sumar(valorA, valorB);
		
		
		//When -> se valida lo que se esta probando es correcto
		Integer resultadoEsperado = 5;
		assertThat(expected).isEqualTo(resultadoEsperado);
		
				
	}

	
	class Calculadora {
		
		Integer sumar(Integer a, Integer b) {
			
			return a + b;
		}
		
	}
}
