package com.thorneos.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thorneos.main.entities.Disciplina;

@Repository
public interface IDisciplinaRepository extends CrudRepository<Disciplina, Integer>{

}
