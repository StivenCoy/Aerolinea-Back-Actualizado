package com.aerolinea.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.service.RutaService;


@RestController
@RequestMapping("/api/ruta")
@CrossOrigin({"*"})
public class RutaController {
	
	
	public RutaService miRuta;

	
	public RutaController(RutaService miRuta) {
		super();
		this.miRuta = miRuta;
	}

	/**
	 * Metodo que lista los nombres de las ciudades desde donde vuela la aerolinea
	 * @return retorna la lista de nombres de las ciudades
	 */
	@GetMapping("/origenes")
	public ResponseEntity<?> listarOrigenes(){
		List<String> origenes = miRuta.listarOrigenes();
		if(origenes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(origenes);
	}
	
	/**
	 * Metodo que lista los nombres de los destinos a los que vuela dado una ciudad origen
	 * @param nombre nombre del origen seleccionado por el usuario
	 * @return retorna los nombres de los destinos 
	 */
	@GetMapping("/destinos/{origen}")
	public ResponseEntity<?> listarDestinos(@PathVariable(value ="origen") String origen)
	{
		List<String> destinos = miRuta.listarDestinos(origen);
		if(destinos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(destinos);
	}

}
