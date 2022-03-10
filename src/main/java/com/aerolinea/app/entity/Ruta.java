package com.aerolinea.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ruta")
public class Ruta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false , name = "idRuta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRuta;
	
	@Column(nullable = false , name = "duracion")
	private String duracion;
	
	@Column(nullable = false , name = "millas")
	private double millas;
	
//	@Column(nullable = false, name= "isEscala")
//	private String isEscala;
	
	@ManyToOne
	@JoinColumn(name = "ciudadOrigen", referencedColumnName = "idCiudad")
	private Ciudad ciudadOrigen;
	
	@ManyToOne
	@JoinColumn(name = "ciudadDestino", referencedColumnName = "idCiudad")
	private Ciudad ciudadDestino;


//	public String getIsEscala() {
//		return isEscala;
//	}
//
//	public void setIsEscala(String isEscala) {
//		this.isEscala = isEscala;
//	}
	
	public int getIdRuta() {
		return idRuta;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public double getMillas() {
		return millas;
	}

	public void setMillas(double millas) {
		this.millas = millas;
	}

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	
	
}
