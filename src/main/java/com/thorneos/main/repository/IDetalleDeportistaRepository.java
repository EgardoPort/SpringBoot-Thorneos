package com.thorneos.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.DetalleDeportista;

@Repository
public interface IDetalleDeportistaRepository extends CrudRepository<DetalleDeportista, Integer>{
	

	@Query("SELECT d FROM DetalleDeportista d where d.id_deportista.id = :id")
	public List<DetalleDeportista> findById_Deportista(@Param("id") Integer id);

}
