package com.thorneos.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.DetalleTorneo;

@Repository
public interface IDetalleTorneoRepository extends CrudRepository<DetalleTorneo, Integer> {

	@Query("SELECT t FROM DetalleTorneo t where t.id_torneo.id = :id")
	public List<DetalleTorneo> findById_Torneo(@Param("id") Integer id);
}
