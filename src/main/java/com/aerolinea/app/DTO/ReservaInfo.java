package com.aerolinea.app.DTO;


public class ReservaInfo {
	
	private String nombrePasajero;
	private String apellidoPasajero;
	private String origen;
	private String fechaIda;
	private String tipoVueloIda;
	private String destino;
	private String fechaRegreso;
	private String tipoVueloRegreso;

	
	public ReservaInfo(String nombrePasajero, String apellidoPasajero, String origen,String fechaIda,
			 String tipoVueloIda, String destino,String fechaRegreso, String tipoVueloRegreso) {
		super();
		this.nombrePasajero = nombrePasajero;
		this.apellidoPasajero = apellidoPasajero;
		this.origen = origen;
		this.fechaIda = fechaIda;
		this.tipoVueloIda = tipoVueloIda;
		this.destino = destino;
		this.fechaRegreso = fechaRegreso;
		this.tipoVueloRegreso = tipoVueloRegreso;
	}


	public String getNombrePasajero() {
		return nombrePasajero;
	}


	public void setNombrePasajero(String nombrePasajero) {
		this.nombrePasajero = nombrePasajero;
	}


	public String getApellidoPasajero() {
		return apellidoPasajero;
	}


	public void setApellidoPasajero(String apellidoPasajero) {
		this.apellidoPasajero = apellidoPasajero;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getFechaIda() {
		return fechaIda;
	}


	public void setFechaIda(String fechaIda) {
		this.fechaIda = fechaIda;
	}


	public String getTipoVueloIda() {
		return tipoVueloIda;
	}


	public void setTipoVueloIda(String tipoVueloIda) {
		this.tipoVueloIda = tipoVueloIda;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getFechaRegreso() {
		return fechaRegreso;
	}


	public void setFechaRegreso(String fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}


	public String getTipoVueloRegreso() {
		return tipoVueloRegreso;
	}


	public void setTipoVueloRegreso(String tipoVueloRegreso) {
		this.tipoVueloRegreso = tipoVueloRegreso;
	}
	

}