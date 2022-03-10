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
@Table(name = "Reserva")
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, name = "idReserva")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int idReserva;
	
	@Column(nullable = false, name = "estado")
	private String estado;
	
	@Column(nullable = false, name = "tipoVuelo")
	private String tipoVuelo;
	
	@ManyToOne
	@JoinColumn(name = "vueloIda", referencedColumnName = "idVuelo")
	private Vuelo vueloIda;
	
	@ManyToOne
	@JoinColumn(name = "vueloVuelta", referencedColumnName = "idVuelo")
	private Vuelo vueloVuelta;

	public int getIdReserva() {
		return idReserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	public Vuelo getVueloIda() {
		return vueloIda;
	}

	public void setVueloIda(Vuelo vueloIda) {
		this.vueloIda = vueloIda;
	}

	public Vuelo getVueloVuelta() {
		return vueloVuelta;
	}

	public void setVueloVuelta(Vuelo vueloVuelta) {
		this.vueloVuelta = vueloVuelta;
	}
	
	
}
