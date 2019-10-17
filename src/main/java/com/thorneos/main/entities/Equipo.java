package com.thorneos.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="num_integrantes")
	private int num_integrantes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNum_integrantes() {
		return num_integrantes;
	}

	public void setNum_integrantes(int num_integrantes) {
		this.num_integrantes = num_integrantes;
	}
}
