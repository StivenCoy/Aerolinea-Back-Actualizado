package com.aerolinea.app.DTO;


public class VueloInfo {
	
	private String hora;
	private String duracion;
	private String tipoVuelo;
	private double precio;
	private int idVuelo;
	
	
	public VueloInfo(String hora, String duracion, String tipoVuelo, double precio, int idVuelo) {
		super();
		this.hora = hora;
		this.duracion = duracion;
		this.tipoVuelo = tipoVuelo;
		this.precio = precio;
		this.idVuelo = idVuelo;
	}


	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public String getTipoVuelo() {
		return tipoVuelo;
	}


	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}


	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	
	
	

}

