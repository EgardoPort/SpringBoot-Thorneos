package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.Escenario;

@Repository
public interface IEscenarioRepository extends CrudRepository<Escenario, Integer>{

}
