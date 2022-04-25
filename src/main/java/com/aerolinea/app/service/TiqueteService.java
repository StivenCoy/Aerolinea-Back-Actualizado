package com.aerolinea.app.service;

import com.aerolinea.app.entity.Pasajero;
import com.aerolinea.app.entity.Tiquete;

public interface TiqueteService {

	public Tiquete crearTiquete(Tiquete tiquete);
	public int calcularDescuentos(Pasajero pasajero);

}
