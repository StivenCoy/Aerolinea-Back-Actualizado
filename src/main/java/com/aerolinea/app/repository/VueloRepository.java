package com.aerolinea.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entity.Vuelo;


@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer>{

	
	@Query(value = "select hora, duracion, isEscala, precio, idVuelo from vuelo as v inner join ruta as r on r.idRuta = v.ruta inner join ciudad as co on r.ciudadOrigen = co.idCiudad  inner join ciudad as cd on cd.idCiudad = r.ciudadDestino  where co.nombre=:origen and cd.nombre=:destino and v.fecha=DATE_FORMAT(:fecha,\"%Y-%m-%d\") and sillasDisponibles > (:cantidad)", nativeQuery=true)
	List<Object[]> listarVuelos(String origen,String destino, Date fecha,int cantidad);
}
