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

import com.thorneos.main.entities.Torneo;
import com.thorneos.main.repository.ITorneoRepository;

@Controller
@RequestMapping(value = "torneo")
public class TorneoController {
	@Autowired
	ITorneoRepository iTorneo;
	
	@GetMapping("index")
	public String listar(Model model) {
		List<Torneo> lista = (List<Torneo>) iTorneo.findAll();
		model.addAttribute("list", lista);
		return "torneo/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		iTorneo.deleteById(id);
		return "redirect:/torneo/list";
	}
	
	@GetMapping("add")
	public String agregar(Model model) {
		model.addAttribute("tor", new Torneo());
		return "torneo/form";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		Torneo tor = iTorneo.findById(id).get();
		model.addAttribute("tor", tor);
		return "torneo/form";
	}
	
	@PostMapping("save")
	public String guardar(HttpServletRequest req) throws ParseException {
		Torneo tor = new Torneo();
		int id_dis = Integer.parseInt(req.getParameter("id_disciplina"));
		int id_enca = Integer.parseInt(req.getParameter("encargado_id"));
		int cantidad = Integer.parseInt(req.getParameter("cantidad_equipos"));
		Date fechaI = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha_inicio"));
		Date fechaF = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha_fin"));
		
		tor.setNombre(req.getParameter("nombre"));
		tor.setFecha_inicio(fechaI);
		tor.setFecha_fin(fechaF);
		tor.setId_disciplina(id_dis);
		tor.setEncargado_id(id_enca);
		tor.setCantidad_equipos(cantidad);
		
		iTorneo.save(tor);
		return "redirect:/torneo/list";
	}
}
