package com.thorneos.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "partido")
public class PartidoController {
	

	@GetMapping("index")
	public String listar(Model model) {
		return "partido/index";
	}

	@GetMapping("perfil")
	public String perfil(Model model) {
		return "partido/perfil";
	}
}
