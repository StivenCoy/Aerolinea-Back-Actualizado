package com.aerolinea.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entity.Tiquete;
import com.aerolinea.app.service.TiqueteService;


@RestController
@RequestMapping("/api/tiquete")
@CrossOrigin({"*"})
public class TiqueteController {
	
	public TiqueteService tiqueteService;

	public TiqueteController(TiqueteService tiqueteService) {
		super();
		this.tiqueteService = tiqueteService;
	}

	/**
	 * Metodo que crea un tiquete 
	 * @param tiquete tiquete que se va a crear 
	 * @return retorna el tiquete creado
	 */
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody Tiquete tiquete)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(tiqueteService.crearTiquete(tiquete));
	}
	
	/**
	 * Metodo que calcula el porcentaje de descuentos a ser aplicados a un pasajero segun las reglas de negocio
	 * @param fechaInicio fecha de inicio del año 
	 * @param fechaFin fecha fin del año 
	 * @param idPasajero identificador del pasajero 
	 * @return retorna el valor en porcentaje del descuento que se le aplicara al pasajero
	 */
	@GetMapping("/descuentos")
	public ResponseEntity<?> calcularDescuentos(
			@RequestBody()                                                
			@RequestParam(value="idPasajero", required = false) String idPasajero){
		int totalVuelos = tiqueteService.calcularDescuentos(idPasajero);
		return ResponseEntity.ok(totalVuelos);
	}
}
