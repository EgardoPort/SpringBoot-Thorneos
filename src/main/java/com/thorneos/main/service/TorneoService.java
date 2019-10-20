package com.thorneos.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thorneos.main.entities.Disciplina;
import com.thorneos.main.entities.Persona;
import com.thorneos.main.entities.Torneo;
import com.thorneos.main.repository.IDisciplinaRepository;
import com.thorneos.main.repository.IPersonaRepository;
import com.thorneos.main.repository.ITorneoRepository;

@Service
@Transactional
public class TorneoService {

	@Autowired
	ITorneoRepository iTorneo;
	
	@Autowired
	IDisciplinaRepository iDisciplina;
	
	@Autowired
	IPersonaRepository iPersona;
	
	public List<Torneo> findAll(){
		return (List<Torneo>) iTorneo.findAll();
	}
	
	public Torneo findById(Integer id) {
		return iTorneo.findById(id).get();
	}
	
	public void save(Torneo participante) {
		iTorneo.save(participante);
	}
	
	public void deleteById(Integer id) {
		iTorneo.deleteById(id);
	}
	
	public void delete(Integer id) {
		iTorneo.delete(iTorneo.findById(id).get());
	}
	
	//Métodos para listar la entidad Disciplinas
	public List<Disciplina> getDisciplina(){
		return (List<Disciplina>) iDisciplina.findAll();
	}
	
	public Disciplina findDisciplinaById(Integer id) {
		return iDisciplina.findById(id).get();
	}
	
	//Métodos para listar la entidad Persona
	public List<Persona> getPersona(){
		return (List<Persona>) iPersona.findAll();
	}
	
	public Persona findPersonaById(Integer id) {
		return iPersona.findById(id).get();
	}
}
