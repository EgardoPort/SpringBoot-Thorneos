package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.DetalleTorneo;

@Repository
public interface IDetalleTorneoRepository extends CrudRepository<DetalleTorneo, Integer> {

}
