package com.aerolinea.app.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ciudad")
public class Ciudad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, name= "idCiudad")
	private int idCiudad;
	
	@Column(nullable = false, name= "nombre")
	private String nombre;
	
	@Column(nullable = false, name= "isVisa")
	private boolean isVisa;
	
	@Column(nullable = false, name= "isNacional")
	private boolean isNacional;
	
	
	
	public int getIdCiudad() {
		return idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isVisa() {
		return isVisa;
	}

	public void setVisa(boolean isVisa) {
		this.isVisa = isVisa;
	}

	public boolean isNacional() {
		return isNacional;
	}

	public void setNacional(boolean isNacional) {
		this.isNacional = isNacional;
	}

	
	
	
}
