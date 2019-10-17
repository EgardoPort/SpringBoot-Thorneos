package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.PuntajeDeportista;

@Repository
public interface IPuntajeDeportista extends CrudRepository<PuntajeDeportista, Integer>{

}
