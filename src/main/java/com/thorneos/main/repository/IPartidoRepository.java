package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.Partido;

@Repository
public interface IPartidoRepository extends CrudRepository<Partido, Integer>{

}
