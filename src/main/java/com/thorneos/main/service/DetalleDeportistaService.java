package com.thorneos.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thorneos.main.entities.Deportista;
import com.thorneos.main.entities.DetalleDeportista;
import com.thorneos.main.entities.Disciplina;
import com.thorneos.main.repository.IDeportistaRepository;
import com.thorneos.main.repository.IDetalleDeportistaRepository;
import com.thorneos.main.repository.IDisciplinaRepository;

@Service
@Transactional
public class DetalleDeportistaService {

	@Autowired
	IDetalleDeportistaRepository iDetalleDeportista;
	
	@Autowired
	IDeportistaRepository iDeportistaRepository;
	
	@Autowired
	IDisciplinaRepository iDisciplinaRepository;
	

	public List<DetalleDeportista> getDisciplinaByIdDeportista(Integer id) {
		return iDetalleDeportista.findById_Deportista(id);
	}
	

	public List<DetalleDeportista> findAll(){
		return (List<DetalleDeportista>) iDetalleDeportista.findAll();
	}
	
	public DetalleDeportista findById(Integer id) {
		return iDetalleDeportista.findById(id).get();
	}
	
	public void save(DetalleDeportista detalleDeportista) {
		iDetalleDeportista.save(detalleDeportista);
	}
	
	public void deleteById(Integer id) {
		iDetalleDeportista.deleteById(id);
	}
	
	public void delete(Integer id) {
		iDetalleDeportista.delete(iDetalleDeportista.findById(id).get());
	}
	
	//Método de la entidad Deportista
	public List<Deportista> getDeportista(){
		return (List<Deportista>) iDeportistaRepository.findAll();
	}
	
	public Deportista findDeportistaById(Integer id) {
		return iDeportistaRepository.findById(id).get();
	}
	
	//Método de la entidad Disciplina
		public List<Disciplina> getDisciplina(){
			return (List<Disciplina>) iDisciplinaRepository.findAll();
		}
		
		public Disciplina findDisciplinaById(Integer id) {
			return iDisciplinaRepository.findById(id).get();
		}

}