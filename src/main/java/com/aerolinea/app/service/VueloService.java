package com.aerolinea.app.service;

import java.util.Date;
import java.util.List;

import com.aerolinea.app.DTO.VueloInfo;
import com.aerolinea.app.entity.Vuelo;

public interface VueloService {
	
	public List<VueloInfo> buscarVuelos(String origen,String destino,Date fecha,int cantidad);
	public Vuelo buscarVuelo(int idvuelo);

}
