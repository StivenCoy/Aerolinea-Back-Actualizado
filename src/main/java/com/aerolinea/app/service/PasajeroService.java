package com.aerolinea.app.service;

import com.aerolinea.app.entity.Pasajero;

public interface PasajeroService {

	public Pasajero crearPasajero(Pasajero pasajero);
	public Pasajero buscarPasajero(String cedula);
	public String verificarPasajeroFrecuente(String cedula, int millas);

}
