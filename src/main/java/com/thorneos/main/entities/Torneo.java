package com.thorneos.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "torneo")
public class Torneo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_inicio;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_fin;
	private int cantidad_equipos;
	
	@JoinColumn(name = "id_disciplina")
	@ManyToOne(fetch = FetchType.EAGER)
	private Disciplina id_disciplina;
	
	@JoinColumn(name = "id_persona")
	@ManyToOne(fetch = FetchType.EAGER)
	private Persona id_persona;
	
	public void setId_disciplina(Disciplina id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	
	public void setId_persona(Persona id_persona) {
		this.id_persona = id_persona;
	}
	
	public Disciplina getId_disciplina() {
		return id_disciplina;
	}
	
	public Persona getId_persona() {
		return id_persona;
	}
	
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
	
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	
	public Date getFecha_fin() {
		return fecha_fin;
	}
	
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public int getCantidad_equipos() {
		return cantidad_equipos;
	}
	
	public void setCantidad_equipos(int cantidad_equipos) {
		this.cantidad_equipos = cantidad_equipos;
	}
}
