package com.aerolinea.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.aerolinea.app.entity.Pasajero;



public interface PasajeroRepository  extends JpaRepository<Pasajero, Integer>{

	@Query(value = "select * from pasajero where cedula=:cedula", nativeQuery = true)
	Pasajero findByCedula(String cedula);
	

}

