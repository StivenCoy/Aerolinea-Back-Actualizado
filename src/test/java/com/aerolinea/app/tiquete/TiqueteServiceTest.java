package com.aerolinea.app.tiquete;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import com.aerolinea.app.entity.Pasajero;
import com.aerolinea.app.entity.Tiquete;
import com.aerolinea.app.service.TiqueteServiceImpl;


public class TiqueteServiceTest {
	
	@InjectMocks
	private TiqueteServiceImpl tiqueteServiceImpl;
	
	
	private Pasajero pasajero;
	private List<Integer> cantidadVuelos;
	private Tiquete tiquete;
	
	@BeforeEach
	void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
	    cantidadVuelos = new ArrayList<>();
	    cantidadVuelos.add(5);
	    cantidadVuelos.add(7);
		pasajero = new Pasajero();
		pasajero.setCantidadViajes();
		pasajero.setCedula("10947896543");
		pasajero.setCorreo("stiven@gmail.com");
		pasajero.setEdad(85);
		pasajero.setFrecuente(true);
		pasajero.setMillasViajadas(45);
		pasajero.setTelefono("32123487");
		pasajero.setTipoViajero("Adulto");
		
		tiquete = new Tiquete();
		tiquete.setPasajero(pasajero);
		tiquete.setTotalPagar("360000");
	}
	
	/**
	 * Prueba que verifica el descuento de un pasajero por su edad 
	 */
	@Test
	void calcularDescuentoPorEdad() {
		int descuento = tiqueteServiceImpl.calcularDescuentoPorEdad(pasajero, 0);
		assertEquals(3, descuento);
	}
	
	
	/**
	 * Prueba que verifica el descuento de un pasajero por la cantidad de viajes realizados
	 */
	@Test
	void calcularDescuentoPorCantidadVuelos() {
		int descuento = tiqueteServiceImpl.calcularDescuentoPorCantidadVuelos(cantidadVuelos,0,pasajero);
		assertEquals(10, descuento);
	}
	

}
