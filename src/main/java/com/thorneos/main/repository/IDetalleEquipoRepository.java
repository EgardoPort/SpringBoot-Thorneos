package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.DetalleEquipo;

@Repository
public interface IDetalleEquipoRepository extends CrudRepository<DetalleEquipo, Integer>{

}
