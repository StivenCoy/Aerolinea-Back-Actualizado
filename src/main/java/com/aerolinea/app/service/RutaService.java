package com.aerolinea.app.service;

import java.util.List;

public interface RutaService {

	public List<String> listarDestinos(String nombre);
	public List<String> listarOrigenes();

}
