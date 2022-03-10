package com.aerolinea.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aerolinea.app.entity.Tiquete;



public interface TiqueteRepository extends JpaRepository<Tiquete, Integer> {

	
	@Query(value = "select count(r.vueloIda), count(r.vueloVuelta) from Tiquete as t inner join Reserva as r on t.reserva=r.idReserva inner join Vuelo as v on r.vueloIda = v.idVuelo inner join Pasajero as pa on pa.idPasajero = t.pasajero where pa.cedula=:cedula and v.fecha>=DATE_FORMAT(:fechaInicio,\"%Y-%m-%d\") and v.fecha<=DATE_FORMAT(:fechaFin,\"%Y-%m-%d\")",nativeQuery=true)
    List<Integer> contarVuelos(String cedula, Date fechaInicio, Date fechaFin);
}

