package com.aerolinea.app.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aerolinea.app.DTO.VueloInfo;
import com.aerolinea.app.entity.Vuelo;
import com.aerolinea.app.repository.VueloRepository;


@Service
public class VueloServiceImpl implements VueloService{

	private VueloRepository vueloRepository;
	
	public VueloServiceImpl(VueloRepository vueloRepository) {
		super();
		this.vueloRepository = vueloRepository;
	}

	@Override
	public List<VueloInfo> buscarVuelos(String origen, String destino, Date fecha, int cantidad) {
		List<VueloInfo> misVuelos = new ArrayList<>();
		List<Object[]> vuelos = vueloRepository.listarVuelos(origen, destino, fecha, cantidad);
		String tpoEscala="";
		for (int i =0; i< vuelos.size();i++) {
			String horaV=(String) vuelos.get(i)[0];
			String duracioI =(String) vuelos.get(i)[1];
			Byte escala=(Byte)vuelos.get(i)[2];
			if(escala == 1) {
				tpoEscala= "Escala";
			}
			double precioI= (double) vuelos.get(i)[3];
			int idVueloI =(int)  vuelos.get(i)[4];
			VueloInfo vuelo= new VueloInfo(horaV, duracioI, tpoEscala, precioI, idVueloI);
			misVuelos.add(vuelo);
			tpoEscala="Directo";
		}

		return   misVuelos;
	}

	@Override
	public Vuelo buscarVuelo(int idvuelo){
		return vueloRepository.findById(idvuelo).get();
	}


}

