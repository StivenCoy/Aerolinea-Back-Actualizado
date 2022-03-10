package com.aerolinea.app.service;

import java.util.List;

import com.aerolinea.app.DTO.ReservaInfo;
import com.aerolinea.app.entity.Reserva;

public interface ReservaService {

	public List<Reserva> listarReservas();
	public Reserva crearRegistro(Reserva reserva);
	public List<ReservaInfo> listarRegistrosDatos();

}
