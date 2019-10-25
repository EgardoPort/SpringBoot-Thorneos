package com.thorneos.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.DetalleEquipo;

@Repository
public interface IDetalleEquipoRepository extends CrudRepository<DetalleEquipo, Integer>{

	@Query("SELECT e FROM DetalleEquipo e where e.id_equipo.id = :id")
	public List<DetalleEquipo> findById_equipo(@Param("id") Integer id);
}
