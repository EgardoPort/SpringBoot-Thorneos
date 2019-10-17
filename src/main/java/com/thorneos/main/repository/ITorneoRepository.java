package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.Torneo;

@Repository
public interface ITorneoRepository extends CrudRepository<Torneo, Integer> {

}
