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

import com.thorneos.main.entities.Disciplina;
import com.thorneos.main.entities.Persona;
import com.thorneos.main.entities.Torneo;
import com.thorneos.main.service.TorneoService;

@Controller
@RequestMapping(value = "torneo")
public class TorneoController {
	@Autowired
	TorneoService iTorneo;
	
	@GetMapping("index")
	public String listar(Model model) {
		List<Torneo> lista = (List<Torneo>) iTorneo.findAll();
		model.addAttribute("list", lista);
		return "torneo/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		iTorneo.deleteById(id);
		return "redirect:/torneo/index";
	}
	
	@GetMapping("add")
	public String agregar(Model model) {
		model.addAttribute("tor", new Torneo());
		model.addAttribute("dis", iTorneo.getDisciplina());
		model.addAttribute("per", iTorneo.getPersona());
		return "torneo/form";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		Torneo tor = iTorneo.findById(id);
		model.addAttribute("tor", tor);
		model.addAttribute("dis", iTorneo.getDisciplina());
		model.addAttribute("per", iTorneo.getPersona());
		return "torneo/update";
	}
	
	@PostMapping("save")
	public String guardar(HttpServletRequest req) throws ParseException {
		Torneo tor = new Torneo();
		Date fechaI = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha_inicio"));
		Date fechaF = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha_fin"));
		
		int id = (req.getParameter("id") != "")? Integer.parseInt(req.getParameter("id")):0;
		int id_dis = Integer.parseInt(req.getParameter("id_disciplina"));
		int id_enca = Integer.parseInt(req.getParameter("id_persona"));
		
		Disciplina dis = iTorneo.findDisciplinaById(id_dis);
		Persona per = iTorneo.findPersonaById(id_enca);
		if(id > 0) {
			tor.setId(id);
		}
		tor.setNombre(req.getParameter("nombre"));
		tor.setFecha_inicio(fechaI);
		tor.setFecha_fin(fechaF);
		tor.setId_disciplina(dis);
		tor.setId_persona(per);
		tor.setCantidad_equipos(Integer.parseInt(req.getParameter("cantidad_equipos")));
		
		iTorneo.save(tor);
		return "redirect:/torneo/index";
	}
}
