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

import com.thorneos.main.entities.Deportista;
import com.thorneos.main.entities.DetalleDeportista;
import com.thorneos.main.entities.Disciplina;
import com.thorneos.main.repository.IDeportistaRepository;
import com.thorneos.main.repository.IDisciplinaRepository;
import com.thorneos.main.service.DetalleDeportistaService;

@Controller
@RequestMapping("deportista")
public class DeportistaController {

	@Autowired
	IDeportistaRepository iDeportista;
	
	@Autowired
	IDisciplinaRepository iDisciplinaRepository;
	
	@Autowired
	DetalleDeportistaService DDepoService;

	@GetMapping("index")
	public String index(Model model) {
		List<Deportista> lista = (List<Deportista>) iDeportista.findAll();
		model.addAttribute("lista", lista);
		return "deportista/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		iDeportista.deleteById(id);
		return "redirect:/deportista/index";
	}

	@GetMapping("add")
	public String agregar(Model model) {
		model.addAttribute("dep", new Deportista());
		return "deportista/form";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		Deportista deportista = iDeportista.findById(id).get();
		model.addAttribute("dep", deportista);
		return "deportista/form";
	}

	@PostMapping("save")
	public String guardar(HttpServletRequest req) throws ParseException {
		Deportista deportista = new Deportista();

		int id = (req.getParameter("id") != "") ? Integer.parseInt(req.getParameter("id")) : 0;
		Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fechaNac"));

		if (id > 0) {
			deportista.setId(id);
		}

		deportista.setNombre(req.getParameter("nombre"));
		deportista.setApellido(req.getParameter("apellido"));
		deportista.setFechaNac(fecha);
		deportista.setPeso(Double.parseDouble(req.getParameter("peso")));

		iDeportista.save(deportista);
		return "redirect:/deportista/index";
	}

	@GetMapping("detalle/{id}")

	public String detalle(@PathVariable Integer id, Model model) {

		Deportista deportista = iDeportista.findById(id).get();
		
		List<Disciplina> lista = (List<Disciplina>) iDisciplinaRepository.findAll();
		model.addAttribute("disciplinas", lista);
		model.addAttribute("dDeportista", new DetalleDeportista());
		
		List<DetalleDeportista> list = DDepoService.getDisciplinaByIdDeportista(deportista.getId());
		model.addAttribute("list", list);
		model.addAttribute("idDeportista", deportista.getId());
		return "deportista/detalle";
		
		
	}
	
	@GetMapping("deletedetalle")
	public String deletedetalle(HttpServletRequest req) {
		int idDetalle = Integer.parseInt(req.getParameter("id"));
		DDepoService.deleteById(idDetalle);
		return "redirect:/deportista/index";
	}
	
	@PostMapping("guardarDe")
	public void guardarDe(HttpServletRequest req, Model model) {
		
		DetalleDeportista det = new DetalleDeportista();
		
		
		int id_deportista  = Integer.parseInt(req.getParameter("idDeportista"));
		int id_disciplina = Integer.parseInt(req.getParameter("idDisciplina"));
		
		System.out.println("Deportista "+ id_deportista);
		System.out.println("Deportista "+ id_disciplina);
		
		Deportista deportista = DDepoService.findDeportistaById(id_deportista);
		Disciplina disciplina = DDepoService.findDisciplinaById(id_disciplina);

		det.setId_deportista(deportista);
		det.setId_disciplina(disciplina);
		
		DDepoService.save(det);

	}
	
	
}
