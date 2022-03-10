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
@Table(name = "Tiquete")
public class Tiquete implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false, name = "idTiquete")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTiquete;
	
	@Column(nullable = false, name = "totalPagar")
	private String totalPagar;
	
	@ManyToOne
	@JoinColumn(name = "pasajero", referencedColumnName = "idPasajero")
	private Pasajero pasajero;
	
	@ManyToOne
	@JoinColumn(name = "reserva", referencedColumnName = "idReserva")
	private Reserva reserva;
	

	public int getIdTiquete() {
		return idTiquete;
	}

	public String getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(String totalPagar) {
		this.totalPagar = totalPagar;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Reserva getReserva() {
		return reserva;
	}

	

}

