package com.aerolinea.app.pasajero;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import com.aerolinea.app.entity.Pasajero;
import com.aerolinea.app.repository.PasajeroRepository;
import com.aerolinea.app.service.PasajeroServiceImpl;


public class PasajeroServiceTest {
	
	@InjectMocks
	private PasajeroServiceImpl pasajeroServiceImpl;
	@InjectMocks
	private PasajeroRepository pasajeroRepository;
	private Pasajero pasajero;
	
	
	@BeforeEach
	void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		pasajero = new Pasajero();
		pasajero.setCantidadViajes();
		pasajero.setCedula("24576093");
		pasajero.setCorreo("maria@gmail.com");
		pasajero.setEdad(30);
		pasajero.setFrecuente(true);
		pasajero.setMillasViajadas(30);
		pasajero.setTelefono("322456816");
		pasajero.setTipoViajero("Adulto");

	}
	
	@Test
	void verificarPasajeroFrecuente() {
		String mensaje = pasajeroServiceImpl.verificarPasajeroFrecuente("24576093", 20);
		String mensajeEsperado = "Usted a viajado "+ 30 + " Millas y con este vuelo llegaria a un total de  "+(30+20) + " millas";
		assertEquals(mensajeEsperado, mensaje);
	}
	

}
