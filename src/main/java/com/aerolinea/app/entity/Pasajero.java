package com.aerolinea.app.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pasajero")
public class Pasajero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false , name="idPasajero")
	private int idPasajero;
	
	@Column(nullable = false , name="nombre")
	private String nombre;
	
	@Column(nullable = false , name="apellido")
	private String apellido;
	
	@Column(nullable = false , name="telefono")
	private String telefono;
	
	@Column(nullable = false , name="correo")
	private String correo;
	
	@Column(nullable = false , name="edad")
	private int edad;
	
	@Column(nullable = true , name="fechaVisa")
	private Date fechaVisa;
	
	@Column(nullable = true , name="cantidadViajes")
	private int cantidadViajes;
	
	@Column(nullable = true , name="millasViajadas")
	private double millasViajadas;
	
	@Column(nullable = false , name="tipoViajero")
	private String tipoViajero;
	
	@Column(nullable = false , name="isFrecuente")
	private boolean isFrecuente;
	
	@Column(nullable = false , name="cedula")
	private String cedula;
	
	
	public boolean isMayorEdad() {
		if(edad >= 18) {
			return true;
		}
		return false;
	}

	public boolean isFrecuente() {
		return isFrecuente;
	}

	public void setFrecuente(boolean isFrecuente) {
		this.isFrecuente = isFrecuente;
	}

	public int getIdPasajero() {
		return idPasajero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad+1;
	}

	public Date getFechaVisa() {
		return fechaVisa;
	}

	public void setFechaVisa(Date fechaVisa) {
		this.fechaVisa = fechaVisa;
	}

	public int getCantidadViajes() {
		return cantidadViajes;
	}

	public void setCantidadViajes() {
		this.cantidadViajes += 1;
	}

	public double getMillasViajadas() {
		return millasViajadas;
	}

	public void setMillasViajadas(double millasViajadas) {
		this.millasViajadas += millasViajadas;
	}

	public String getTipoViajero() {
		return tipoViajero;
	}

	public void setTipoViajero(String tipoViajero) {
		this.tipoViajero = tipoViajero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	
	
}
