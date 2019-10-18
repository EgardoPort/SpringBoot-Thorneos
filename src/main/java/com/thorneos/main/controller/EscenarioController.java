package com.thorneos.main.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thorneos.main.entities.Escenario;
import com.thorneos.main.repository.IEscenarioRepository;

@Controller
@RequestMapping("/escenario")
public class EscenarioController {
	@Autowired
	IEscenarioRepository iEscenarioRepository;

	@GetMapping("index")
	public String index(Model model) {
		List<Escenario> lista = (List<Escenario>) iEscenarioRepository.findAll();
		model.addAttribute("lista", lista);
		return "escenario/index";
	}

	@GetMapping("agregar")
	public String agregar(Model model) {
		model.addAttribute("es", new Escenario());
		return "escenario/form";
	}

	@PostMapping("save")
	public String save(HttpServletRequest req) {
		Escenario es = new Escenario();
		int id = (req.getParameter("id") != "") ? Integer.parseInt(req.getParameter("id")) : 0;

		if (id > 0) {
			es.setId(id);
		}
		es.setDireccion(req.getParameter("direccion"));
		es.setNombre(req.getParameter("nombre"));
        es.setHora_reserva(req.getParameter("hora_reserva"));
        es.setFecha_reserva(req.getParameter("fecha_reserva"));
		es.setEstadoesce(req.getParameter("estadoesce"));

		iEscenarioRepository.save(es);
		return "redirect:/escenario/index";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		Optional<Escenario> es = iEscenarioRepository.findById(id);
		model.addAttribute("es", es.get());
		return "escenario/form";
	}

	@GetMapping("delete/{id}")
	public String eliminar(@PathVariable Integer id) {
		iEscenarioRepository.deleteById(id);
		return "redirect:/escenario/index";

	}

}
