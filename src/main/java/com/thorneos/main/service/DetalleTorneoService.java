package com.thorneos.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thorneos.main.entities.DetalleTorneo;
import com.thorneos.main.entities.Equipo;
import com.thorneos.main.entities.Torneo;
import com.thorneos.main.repository.IDetalleTorneoRepository;
import com.thorneos.main.repository.IEquipoRepository;
import com.thorneos.main.repository.ITorneoRepository;

@Service
@Transactional
public class DetalleTorneoService {
	
	@Autowired
	IDetalleTorneoRepository iDetalleTorneo;
	@Autowired
	IEquipoRepository iEquipo;
	@Autowired
	ITorneoRepository iTorneo;
	
	public List<DetalleTorneo> findAll(){
		return (List<DetalleTorneo>) iDetalleTorneo.findAll();
	}
	
	public DetalleTorneo findById(Integer id){
		return iDetalleTorneo.findById(id).get();
	}
	
	public void save(DetalleTorneo detalleTorneo){
		iDetalleTorneo.save(detalleTorneo);
	}
	
	public void deleteById(Integer id){
		iDetalleTorneo.deleteById(id);
	}
	
	public void delete(Integer id){
		iDetalleTorneo.delete(iDetalleTorneo.findById(id).get());
	}
	
	//Método de la entidad equipo
	
	public List<Equipo> getEquipo(){
		return (List<Equipo>) iEquipo.findAll();
	}
	
	public Equipo findEquipoById(Integer id){
		return iEquipo.findById(id).get();
	}
	
	//Método de la entidad Torneo
	
	public List<Torneo> getTorneo(){
		return (List<Torneo>) iTorneo.findAll();
	}
	
	public Torneo findTorneoById(Integer id){
		return iTorneo.findById(id).get();
	}
	
	public List<DetalleTorneo> getTorneoById(Integer id){
		return iDetalleTorneo.findById_Torneo(id);
	}
}
