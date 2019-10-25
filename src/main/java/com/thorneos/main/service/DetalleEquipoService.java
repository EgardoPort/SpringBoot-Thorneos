package com.thorneos.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thorneos.main.entities.Deportista;
import com.thorneos.main.entities.DetalleEquipo;
import com.thorneos.main.entities.Equipo;
import com.thorneos.main.repository.IDeportistaRepository;
import com.thorneos.main.repository.IDetalleEquipoRepository;
import com.thorneos.main.repository.IEquipoRepository;

@Service
@Transactional
public class DetalleEquipoService {
	
	@Autowired
	IDetalleEquipoRepository iDetalleEquipo;
	@Autowired
	IDeportistaRepository iDeportista;
	@Autowired
	IEquipoRepository iEquipo;
	
	public List<DetalleEquipo> findAll()
	{
		return (List<DetalleEquipo>) iDetalleEquipo.findAll();
	}
	
	public DetalleEquipo findById(Integer id)
	{
		return iDetalleEquipo.findById(id).get();
	}
	
	public void save(DetalleEquipo detalleEquipo)
	{
		iDetalleEquipo.save(detalleEquipo);
	}
	
	public void deleteById(Integer id)
	{
		iDetalleEquipo.deleteById(id);
	}
	
	public void delete(Integer id)
	{
		iDetalleEquipo.delete(iDetalleEquipo.findById(id).get());
	}
	
	//Método de la entidad equipo
	
	public List<Equipo> getEquipo()
	{
		return (List<Equipo>) iEquipo.findAll();
	}
	
	public Equipo findEquipoById(Integer id)
	{
		return iEquipo.findById(id).get();
	}
	
	//Método de la entidad Deportista
	
	public List<Deportista> getDeportistas()
	{
		return (List<Deportista>) iDeportista.findAll();
	}
	
	public Deportista findDeportistaById(Integer id)
	{
		return iDeportista.findById(id).get();
	}
	
	public List<DetalleEquipo> getDeportistaByIdEquipo(Integer id){
		return iDetalleEquipo.findById_equipo(id);
	}
}
