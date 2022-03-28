package com.aerolinea.app.DTO;

import java.util.Date;

public class DatosVuelo {
	private String origen;
	private String destino;
	private Date fecha;
	private int cantidad;
	public DatosVuelo(String origen, String destino, Date fecha, int cantidad) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
