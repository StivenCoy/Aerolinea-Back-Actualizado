package com.aerolinea.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aerolinea.app.DTO.ReservaInfo;
import com.aerolinea.app.entity.Reserva;



public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	@Query(value =
			  "select  p.nombre as nombrePasajero, p.apellido as apellidoPasajero, co.nombre as origen, v.fecha as fechaIda,"
			+ "	v.isEscala as tipoVueloIda, cd.nombre as destino, vv.fecha as fechaRegreso, vv.isEscala as tipoVueloRegreso"
			+ " from reserva as r inner join vuelo as v on r.vueloida=v.idVuelo "
			+ " left join vuelo as vv on vv.idVuelo = r.vueloVuelta "
			+ " inner join ruta as rut on rut.idRuta=v.ruta "
			+ " inner join ciudad as co on co.idCiudad=rut.ciudadOrigen"
			+ " inner join ciudad as cd on cd.idCiudad=rut.ciudadDestino "
			+ " inner join tiquete as t on r.idReserva=t.reserva "
			+ " inner join pasajero as p on p.idpasajero=t.pasajero",nativeQuery=true)
    List<Object[]> listarReservas();

}

