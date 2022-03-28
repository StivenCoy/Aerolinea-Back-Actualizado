package com.aerolinea.app.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entity.Pasajero;
import com.aerolinea.app.service.PasajeroService;



@RestController
@RequestMapping("/api/pasajero")
@CrossOrigin({"*"})
public class PasajeroController {
	
	
	public PasajeroService pasajeroService;
	
	 
	public PasajeroController(PasajeroService pasajeroService) {
		super();
		this.pasajeroService = pasajeroService;
	}

	/**
	 * Metodo que crea un pasajero 
	 * @param pasajero Pasajero que va hacer creado
	 * @return retorna el pasajero creado
	 */
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody Pasajero pasajero)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(pasajeroService.crearPasajero(pasajero));
	}
	
	/**
	 * Metodo que busca un pasajero con su id
	 * @param idpasajero id del pasajero a ser buscado
	 * @return retorna el pasajero 
	 */
	@GetMapping("/buscar/{idpasajero}")
	public ResponseEntity<Pasajero> buscar(@PathVariable(value ="idpasajero") String idpasajero){
		Pasajero pasajero= pasajeroService.buscarPasajero(idpasajero);
		if(pasajero == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pasajero);
	}
	
	/**
	 * Metodo que verifica si un pasajero es frecuente si es frecuente le muestra la cantidad 
	 * de millas que lleva y cuantas acumula con el viaje
	 * @param pasajero pasajero que se va a verificar
	 * @return String el mensaje si es o no frecuente
	 */
	@GetMapping("/viaje/")
	public ResponseEntity<?> verificarPasajeroFrecuente(
			@RequestParam(value="idPasajero", required = false) String idPasajero,
			@RequestParam(value="millas",required = false) int millas){
		String millasViajadas= pasajeroService.verificarPasajeroFrecuente(idPasajero,millas);
		List<String> destinos = new ArrayList<String>();
		destinos.add(millasViajadas);
		if(millasViajadas.equals("")) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(destinos);
	}
	
}

