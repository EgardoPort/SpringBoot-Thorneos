package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.DetalleDeportista;

@Repository
public interface IDetalleDeportistaRepository extends CrudRepository<DetalleDeportista, Integer>{

}
