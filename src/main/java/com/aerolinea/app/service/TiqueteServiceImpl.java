package com.aerolinea.app.service;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.aerolinea.app.entity.Pasajero;
import com.aerolinea.app.entity.Tiquete;
import com.aerolinea.app.repository.PasajeroRepository;
import com.aerolinea.app.repository.TiqueteRepository;


@Service
public class TiqueteServiceImpl implements TiqueteService{

	private TiqueteRepository tiqueteRepository;
	private PasajeroRepository pasajeroRepository;
	
	public TiqueteServiceImpl(TiqueteRepository tiqueteRepository, PasajeroRepository pasajeroRepository) {
		super();
		this.tiqueteRepository = tiqueteRepository;
		this.pasajeroRepository = pasajeroRepository;
		
	}

	@Override
	public Tiquete crearTiquete(Tiquete tiquete) {
		tiquete.getPasajero().setCantidadViajes();
		if(tiquete.getReserva().getTipoVuelo().equals("RT")) {
			tiquete.getPasajero().setMillasViajadas(tiquete.getReserva().getVueloIda().getRuta().getMillas()
					+tiquete.getReserva().getVueloVuelta().getRuta().getMillas());
			tiquete.getPasajero().setCantidadViajes();
			tiquete.getReserva().getVueloIda().setSillasDisponibles();
			tiquete.getReserva().getVueloVuelta().setSillasDisponibles();
		}
		else {
			tiquete.getPasajero().setMillasViajadas(tiquete.getReserva().getVueloIda().getRuta().getMillas());
			tiquete.getPasajero().setCantidadViajes();
			tiquete.getReserva().getVueloIda().setSillasDisponibles();
		}
		return tiqueteRepository.save(tiquete);
	}

	@Override
	public int calcularDescuentos(String idPasajero) {
		int porcentageDescuento = 0;
		Date fechaHoy = new Date();
		fechaHoy.toInstant();
		Date inicioAnio =  new Date(fechaHoy.getYear(),01,01);
		List<Integer> cantidadVuelos = tiqueteRepository.contarVuelos(idPasajero, inicioAnio,fechaHoy);
		System.out.println(idPasajero + "PASAJERO "+ inicioAnio + " año "+ fechaHoy + "fecha hoy");
		Pasajero pasajero =  pasajeroRepository.findByCedula(idPasajero);
		if(pasajero != null) {
			if(cantidadVuelos != null ) {
				porcentageDescuento	= calcularDescuentoPorCantidadVuelos(cantidadVuelos,porcentageDescuento, pasajero);
				}
				porcentageDescuento += calcularDescuentoPorEdad(pasajero, porcentageDescuento);
		}
		if(porcentageDescuento >= 100) {
			porcentageDescuento = 100;
		}
		return porcentageDescuento;
	}
	
	
	
	/**
	 * Metodo que calcula el descuento por cantidad de vuelos viajados por el pasajero
	 * @param cantidadVuelos es la lista que contiene la cantidad de vuelos de ida y regreso 
	 * @param porcentageDescuento porcentaje del descuento a sumar 
	 * @return retorna la suma del descuento
	 */
	public static int calcularDescuentoPorCantidadVuelos(List<Integer> cantidadVuelos, int porcentageDescuento, Pasajero pasajero ) {
		int cantidadTotalVuelos = 0;
		try {
			cantidadTotalVuelos=cantidadVuelos.get(0)+cantidadVuelos.get(0);
			System.out.println(cantidadTotalVuelos + "vuelos cantidad");
			if(cantidadTotalVuelos > 10) {
				if(pasajero.isFrecuente())
				{
					porcentageDescuento = 10;
					System.out.println("vuelos ingresop");
				}
				else {
					porcentageDescuento = 5;
				}
			}
			
		} catch (Exception e) {
			System.out.println(" Error de casteo de numero");
		}
		return porcentageDescuento;
	}
	
	
	/**
	 * Metodo que realiza el calculo del descuento por tipo de viajero y edad del viajero
	 * @param pasajero pasajero al cual se le van a validar opciones de descuento
	 * @param porcentageDescuento es la suma de los descuentos 
	 * @return retorna la suma del porcentage de los descuentos 
	 */
	public static int calcularDescuentoPorEdad(Pasajero pasajero, int porcentageDescuento) {
		if(pasajero.getEdad() > 65) {
			porcentageDescuento +=3;
		}
		if(pasajero.getTipoViajero().equals("Infantes")) {
			porcentageDescuento+=90;
		}
		return porcentageDescuento;
	}
	

}

