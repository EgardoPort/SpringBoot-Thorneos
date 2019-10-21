package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.Persona;

@Repository
public interface IPersonaRepository extends CrudRepository<Persona, Integer>{
	Persona findByUsuario(String usuario);
}
