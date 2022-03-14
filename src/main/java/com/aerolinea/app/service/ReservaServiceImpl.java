package com.aerolinea.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aerolinea.app.DTO.ReservaInfo;
import com.aerolinea.app.entity.Reserva;
import com.aerolinea.app.repository.ReservaRepository;


@Service
public class ReservaServiceImpl implements ReservaService{

	private ReservaRepository reservaRepository;
	
	

	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		super();
		this.reservaRepository = reservaRepository;
	}

	@Override
	public List<Reserva> listarReservas() {
		return reservaRepository.findAll();
	}
	

	@Override
	public Reserva crearRegistro(Reserva reserva) {
		return reservaRepository.save(reserva);
	}

	@Override
	public List<ReservaInfo> listarRegistrosDatos() {
		List<Object[]> reservas =	reservaRepository.listarReservas();
		List<ReservaInfo> misReservas = new ArrayList<>();
		String nombrePasajero;
		 String apellidoPasajero;
		 String origen;
		 String fechaIda;
		 String tipoVueloIda;
		 String destino;
		 String fechaRegreso;
		 String tipoVueloRegreso;
		for (int i = 0; i < reservas.size(); i++) {
			  nombrePasajero = (String) reservas.get(i)[0];
			  apellidoPasajero = (String) reservas.get(i)[1];
			  origen = (String) reservas.get(i)[2];
			  fechaIda = ""+ reservas.get(i)[3];
			  tipoVueloIda = verificarTipoVuelo(""+reservas.get(i)[3]);
			  destino = ""+ reservas.get(i)[5];
			  fechaRegreso = ""+ reservas.get(i)[6];
			  tipoVueloRegreso = verificarTipoVuelo(""+reservas.get(i)[7]);
			  ReservaInfo reservaInfo = new ReservaInfo(nombrePasajero, apellidoPasajero, origen, fechaIda, tipoVueloIda, destino, fechaRegreso, tipoVueloRegreso);
		      misReservas.add(reservaInfo);
		}
		return misReservas;
	}
	public String verificarTipoVuelo(String escala) {
		  String tipoVuelo = "";
		if(escala.equals("1")) {
			  tipoVuelo= "Escala";
			}
		  else {
			  tipoVuelo= "Directo";
		  }
		return tipoVuelo;
	}

	
}

