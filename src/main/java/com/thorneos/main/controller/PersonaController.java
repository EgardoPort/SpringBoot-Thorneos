package com.thorneos.main.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thorneos.main.entities.Persona;
import com.thorneos.main.repository.IPersonaRepository;

@Controller
@RequestMapping(value = "/persona")
public class PersonaController {

	@Autowired
	IPersonaRepository iPersona;
	
	@GetMapping("index")
	public String listar(Model model) {
		List<Persona> lista = (List<Persona>) iPersona.findAll();
		model.addAttribute("lista", lista);
		return "persona/index";
	}
	
	@GetMapping("delete")
	public String delete(HttpServletRequest req) {
		int id = (req.getParameter("id") != "")? Integer.parseInt(req.getParameter("id")):0;
		iPersona.deleteById(id);
		return "redirect:/persona/index";
	}
	
	@GetMapping("add")
	public String agregar(Model model) {
		model.addAttribute("per", new Persona());
		return "persona/form";
	}
	
	@PostMapping("save")
	public String guardar(HttpServletRequest req) throws ParseException {
		Persona per = new Persona();
		int id = (req.getParameter("id")!= "")? Integer.parseInt(req.getParameter("id")):0;
		Date fechaN = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha_nacimiento"));
		
		if (id>0) {
			per.setId(id);
		}
		
		per.setNombres(req.getParameter("nombre"));
		per.setApellidos(req.getParameter("apellido"));
		per.setTelefono(req.getParameter("telefono"));
		per.setDui(req.getParameter("dui"));
		per.setFechaNacimiento(fechaN);
		per.setDireccion(req.getParameter("direccion"));
		per.setUsuario(req.getParameter("usuario"));
		per.setClave(req.getParameter("clave"));
		per.setTipoUsuario(req.getParameter("tipo"));
		
		iPersona.save(per);
		return "redirect:/persona/index";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		Persona per = iPersona.findById(id).get();
		model.addAttribute("per", per);
		return "persona/form";
	}
}
