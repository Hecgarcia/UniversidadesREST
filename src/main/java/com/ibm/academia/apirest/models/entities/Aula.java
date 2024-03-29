package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


import com.ibm.academia.apirest.enums.Pizarron;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity 
@Table(name = "aulas", schema = "universidad" )
//@Table(name = "aulas")

public class Aula implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Positive(message = "El valor minimo aceptado es 1")
	@Column(name = "numero_aula", nullable = false)
	private Integer numeroAula;
    
    
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "no puede ser vacio")
    @Column(name = "medidas")
	private String medidas;
    
    @Positive(message = "El valor minimo aceptado es 1")
    @Column(name = "cantidad_pupitres")
	private Integer cantidadPupitres;
	
	@Column(name = "tipo_pizarron")
	@Enumerated(EnumType.STRING)
	private Pizarron pizarron;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
	private Pabellon pabellon;
	
	
	
	
	public Aula(Integer id, Integer numeroAula, String medidas, Integer cantidadPupitres, Pizarron pizarron) {
		
		this.id = id;
		this.numeroAula = numeroAula;
		this.medidas = medidas;
		this.cantidadPupitres = cantidadPupitres;
		this.pizarron = pizarron;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id, numeroAula);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id) && Objects.equals(numeroAula, other.numeroAula);
	}

	@PrePersist
	private void antesPersistir() {
		this.fechaAlta = new Date(); 
	}
	
	@PreUpdate
	private void antesActualizar()
	{
		this.fechaModificacion = new Date();
	}


	private static final long serialVersionUID = -5828074579621708376L;
	
	

}
