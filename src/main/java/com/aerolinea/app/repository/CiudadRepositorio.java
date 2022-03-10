package com.aerolinea.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aerolinea.app.entity.Ciudad;



public interface CiudadRepositorio extends JpaRepository<Ciudad, Integer>{

	@Query(value = "select isVisa from Ciudad as c where c.nombre=:nombre",nativeQuery=true)
	String isVisa(String nombre);
}
