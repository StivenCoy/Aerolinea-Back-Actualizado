package com.aerolinea.app.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vuelo")
public class Vuelo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "idVuelo")
	private int idVuelo;
	
	@Column(nullable = false, name= "fecha")
	private Date fecha;
	
	@Column(nullable = false, name= "isEscala")
	private String isEscala;
	
	@Column(nullable = false, name= "numero")
	private String numero;
	
	@Column(nullable = false, name= "hora")
	private String hora;
	
	@Column(nullable = false, name= "sillasDisponibles")
	private int sillasDisponibles;
	
	@Column(nullable = false, name= "precio")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name ="ruta", referencedColumnName = "idRuta")
	private Ruta ruta;

	public int getIdVuelo() {
		return idVuelo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIsEscala() {
		return isEscala;
	}

	public void setIsEscala(String isEscala) {
		this.isEscala = isEscala;
	}

	public String getNumero() {
		return numero;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getSillasDisponibles() {
		return sillasDisponibles;
	}

	public void setSillasDisponibles() {
		this.sillasDisponibles +=1;
	}

	public double getPrecio() {
		return precio;
	}

	public Ruta getRuta() {
		return ruta;
	}

	
	
}

