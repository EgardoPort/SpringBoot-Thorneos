package com.thorneos.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer id_disciplina;
	private Integer encargado_id;
	private Integer cantidad_equipos;
	
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
	public Integer getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(Integer id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	public Integer getEncargado_id() {
		return encargado_id;
	}
	public void setEncargado_id(Integer encargado_id) {
		this.encargado_id = encargado_id;
	}
	public Integer getCantidad_equipos() {
		return cantidad_equipos;
	}
	public void setCantidad_equipos(Integer cantidad_equipos) {
		this.cantidad_equipos = cantidad_equipos;
	}
}
