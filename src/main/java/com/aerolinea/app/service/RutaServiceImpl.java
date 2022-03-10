package com.aerolinea.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aerolinea.app.repository.RutaRepository;


@Service
public class RutaServiceImpl implements RutaService {

	
	private RutaRepository rutaRepository;
	
	public RutaServiceImpl(RutaRepository rutaRepository) {
		super();
		this.rutaRepository = rutaRepository;
	}

	@Override
	public List<String> listarDestinos(String nombre) {
		return rutaRepository.listarDestinos(nombre);
	}

	@Override
	public List<String> listarOrigenes() {
		return rutaRepository.listarOrigenes();
	}

}

