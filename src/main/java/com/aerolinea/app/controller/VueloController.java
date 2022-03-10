package com.aerolinea.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.DTO.VueloInfo;
import com.aerolinea.app.entity.Vuelo;
import com.aerolinea.app.service.VueloService;


@RestController
@RequestMapping("/api/vuelo")
@CrossOrigin({"*"})
public class VueloController {
	
	private VueloService vueloService;

	public VueloController(VueloService vueloService) {
		super();
		this.vueloService = vueloService;
	}
	
	/**
	 * Metodo que busca los vuelos que correspondan a los filtros de fecha origen destino y cantidad de personas
	 * @param fecha fecha del vuelo
	 * @param origen nombre de la ciudad origen
	 * @param destino nombre de la ciudad destino
	 * @param cantidad cantidad de pasajeros
	 * @return returna la lista de los vuelos
	 */
	@GetMapping("/lista/")
	public ResponseEntity<?> buscarVuelos(
			@RequestParam(value="fecha") @DateTimeFormat( pattern ="yyyy-MM-dd" ) Date fecha,
			@RequestParam(value="origen", required = false) String origen,
			@RequestParam(value="destino",required = false) String destino,
			@RequestParam(value="cantidad",required = false) int cantidad){
		List<VueloInfo> vuelos = vueloService.buscarVuelos(origen, destino, fecha, cantidad);
		
		System.out.println(" vuelos " + vuelos.size());
		if(vuelos.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vuelos);
	}
	
	
	/**
	 * Metodo que busca un vuelo 
	 * @param idvuelo id del vuelo que se va a buscar
	 * @return retorna la el vuelo
	 */
	@GetMapping("/buscar/{idvuelo}")
	public ResponseEntity<?> buscarVuelo(@PathVariable(value ="idvuelo") Integer idvuelo){
		Vuelo miVuelo = vueloService.buscarVuelo(idvuelo);
		if(miVuelo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(miVuelo);
	}

}

