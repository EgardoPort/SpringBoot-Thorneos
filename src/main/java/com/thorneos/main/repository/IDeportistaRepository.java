package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.Deportista;

@Repository
public interface IDeportistaRepository extends CrudRepository<Deportista, Integer> {

}
