package com.thorneos.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ThorneosSpringApplication {

	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	
	@GetMapping("/encargado")
	public String encargado()
	{
		return "encargado";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ThorneosSpringApplication.class, args);
	}

}
