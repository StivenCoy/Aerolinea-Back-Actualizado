package com.aerolinea.app.service;

import java.util.List;

import com.aerolinea.app.DTO.DatosVuelo;
import com.aerolinea.app.DTO.VueloInfo;
import com.aerolinea.app.entity.Vuelo;

public interface VueloService {
	
	public List<VueloInfo> buscarVuelos(DatosVuelo vuelo);
	public Vuelo buscarVuelo(int idvuelo);

}
