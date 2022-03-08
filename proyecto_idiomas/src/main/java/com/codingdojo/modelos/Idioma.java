package com.codingdojo.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="idiomas")
public class Idioma {
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private long id;

	@Size(min=2,max=20,message="llenar el espacio,minimo entre 2 a 20 caracteres")
	@NotNull
	private String nombre;
	
	@Size(min=2,max=20,message="llenar el espacio,minimo entre 2 a 20 caracteres")
	@NotNull
	private String creador;
	
	@NotNull
	private double version ;
	
	public Idioma() {
	}

	public Idioma(String nombre,String creador, long version) {
		this.nombre = nombre;
		this.creador = creador;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}
	
	
}
