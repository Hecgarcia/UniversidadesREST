package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pabellones", schema = "universidad")
//@Table(name = "pabellones")
public class Pabellon implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Positive(message = "el numero debe ser mayor a cero ")
	@Column(name = "metros_cuadrados")
	private Double metrosCuadrados;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "no puede ser vacio")
	@Size(min = 4, max = 80)
	@Column(name = "nombre", unique = true, nullable = false)
	private String nombre;
	
	@Column(name = "fecha_alta")
	private Date    fechaAlta;
	
	@Column(name = "fecha_modificacion")
	private Date    fechaModificacion;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
		@AttributeOverride(name = "departamento", column = @Column(name = "departamento"))
	})
	private Direccion direccion;
	
	@OneToMany(mappedBy = "pabellon", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"pabellon"})
    private Set<Aula> aulas;
		
		
	
	public Pabellon(Integer id, Double metrosCuadrados, String nombre, Direccion direccion) {
		this.id = id;
		this.metrosCuadrados = metrosCuadrados;
		this.nombre = nombre;
		this.direccion = direccion;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pabellon other = (Pabellon) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
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

	private static final long serialVersionUID = 6165337968591140809L;

 
}
