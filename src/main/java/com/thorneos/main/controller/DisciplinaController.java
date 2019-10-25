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

import com.thorneos.main.entities.Disciplina;
import com.thorneos.main.repository.IDisciplinaRepository;

@Controller
@RequestMapping(value = "/disciplina")
public class DisciplinaController {
	
	@Autowired
	IDisciplinaRepository iDisciplina;
	
	@GetMapping(value = "index")
	public String index(Model model)
	{
		List<Disciplina> listado = (List<Disciplina>) iDisciplina.findAll();
		model.addAttribute("lista", listado);
		return "disciplina/index";
	}
	
	@GetMapping(value = "delete")
	public String delete(HttpServletRequest req)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		iDisciplina.deleteById(id);
		return "redirect:/disciplina/index";
	}
	
	@GetMapping(value = "agregar")
	public String agregar(Model model)
	{
		model.addAttribute("dis", new Disciplina());
		return "disciplina/form";
	}
	
	@GetMapping(value = "update/{id}")
	public String update(@PathVariable("id") int id, Model model)
	{
		Disciplina disciplina = iDisciplina.findById(id).get();
		model.addAttribute("dis", disciplina);
		return "disciplina/form";
	}
	
	@PostMapping(value = "guardar")
	public String guardar(HttpServletRequest req)
	{
		Disciplina dis = new Disciplina();
		int id = (req.getParameter("id") != "")? Integer.parseInt(req.getParameter("id")) : 0;
		dis.setId(id);
		dis.setNombre(req.getParameter("nombre"));
		iDisciplina.save(dis);
		return "redirect:/disciplina/index";
	}
}
