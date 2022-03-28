package com.aerolinea.app.service;

import org.springframework.stereotype.Service;
import com.aerolinea.app.entity.Pasajero;
import com.aerolinea.app.repository.PasajeroRepository;


@Service
public class PasajeroServiceImpl implements PasajeroService{
	
	private PasajeroRepository pasajeroRepository;
	

	public PasajeroServiceImpl(PasajeroRepository pasajeroRepository) {
		super();
		this.pasajeroRepository = pasajeroRepository;
	}

	@Override
	public Pasajero crearPasajero(Pasajero pasajero) {
		return pasajeroRepository.save(pasajero);
	}

	@Override
	public Pasajero buscarPasajero(String cedula) {
		return pasajeroRepository.findByCedula(cedula);
	}

	@Override
	public String verificarPasajeroFrecuente(String cedula, int millas) {
		Pasajero pasajeroEncontrado= pasajeroRepository.findByCedula(cedula);
		String mensaje="No Frecuente";
		int millasViajadas = 0;
		if(pasajeroEncontrado != null){
			if(pasajeroEncontrado.isFrecuente() == true) {
				millasViajadas = (int)pasajeroEncontrado.getMillasViajadas();
				mensaje="Usted a viajado "+ millasViajadas + 
						" Millas y con este vuelo llegaria a un total de  "+(millasViajadas+millas) + " millas";
				return mensaje;
			}
		}
		return mensaje;
	}
}

