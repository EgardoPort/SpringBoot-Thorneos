package com.thorneos.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thorneos.main.entities.Deportista;
import com.thorneos.main.entities.DetalleEquipo;
import com.thorneos.main.entities.Equipo;
import com.thorneos.main.repository.IDeportistaRepository;
import com.thorneos.main.repository.IEquipoRepository;
import com.thorneos.main.service.DetalleEquipoService;

@Controller
@RequestMapping(value = "equipo")
public class EquipoController {

	@Autowired
	IEquipoRepository iEquipo;
	
	@Autowired
	IDeportistaRepository iDeportista;
	
	@Autowired
	DetalleEquipoService detalleEquipoService;
	
	@GetMapping("index")
	public String index(Model model) {
		List<Equipo> lista = (List<Equipo>) iEquipo.findAll();
		model.addAttribute("equi", new Equipo());
		model.addAttribute("lista", lista);
		return "equipo/index";
	}
	
	@GetMapping("delete")
	public String delete(HttpServletRequest req) {
		int id = (req.getParameter("id") != "")? Integer.parseInt(req.getParameter("id")):0;
		iEquipo.deleteById(id);
		return "redirect:/equipo/index";
	}
	
	@GetMapping("add")
	public String agregar(Model model) {
		model.addAttribute("equi", new Equipo());
		return "equipo/form";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		Equipo equipo = iEquipo.findById(id).get();
		model.addAttribute("equi", equipo);
		return "equipo/form";
	}
	
	@PostMapping("save")
	public String guardar(HttpServletRequest req) {
		Equipo equipo = new Equipo();
		int id = (req.getParameter("id") != "")? Integer.parseInt(req.getParameter("id")) : 0;
		int num = Integer.parseInt(req.getParameter("num_integrantes"));
		if	(id>0) {
			equipo.setId(id);
		}
		equipo.setNombre(req.getParameter("nombre"));
		equipo.setNum_integrantes(num);
		iEquipo.save(equipo);
		return "redirect:/equipo/index";
	}
	
	@GetMapping("detalle/{id}")
	public String detalle(@PathVariable Integer id, Model model) {

		Equipo equipo =  iEquipo.findById(id).get();
		
		List<Deportista> lista = (List<Deportista>) iDeportista.findAll();
		model.addAttribute("deportistas", lista);
		model.addAttribute("dEquipo", new DetalleEquipo());
		
		List<DetalleEquipo> list = detalleEquipoService.getDeportistaByIdEquipo(equipo.getId());
		model.addAttribute("list", list);
		model.addAttribute("idEquipo", equipo.getId());
		return ("detalleEquipo/index");
	}
	
	@PostMapping("guardarDe")
	public void guardarDe(HttpServletRequest req, Model model)
	{
		DetalleEquipo detalleEquipo = new DetalleEquipo();
		int id_deportista = Integer.parseInt(req.getParameter("id_deportista")); 
		int id_equipo = Integer.parseInt(req.getParameter("id_equipo"));
		
		Deportista deportista= detalleEquipoService.findDeportistaById(id_deportista);
		Equipo equipo = detalleEquipoService.findEquipoById(id_equipo);
		
			//Asignar valores a la entidad 
		
			detalleEquipo.setId_equipo(equipo);
		
			detalleEquipo.setId_deportista(deportista);
			detalleEquipo.setId_equipo(equipo); 
		
			detalleEquipoService.save(detalleEquipo);
	}
	
	@GetMapping("deleteDe")
	public void deleteDe(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id_deportista1"));
		detalleEquipoService.deleteById(id);
	}
}
