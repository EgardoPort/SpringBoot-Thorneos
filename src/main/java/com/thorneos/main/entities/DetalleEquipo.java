package com.thorneos.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_equipo")
public class DetalleEquipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@JoinColumn(name = "id_deportista")
	@ManyToOne(fetch = FetchType.EAGER)
	private Deportista id_deportista;
	@JoinColumn(name = "id_equipo")
	@ManyToOne(fetch = FetchType.EAGER)
	private Equipo id_equipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Deportista getId_deportista() {
		return id_deportista;
	}
	public void setId_deportista(Deportista id_deportista) {
		this.id_deportista = id_deportista;
	}
	public Equipo getId_equipo() {
		return id_equipo;
	}
	public void setId_equipo(Equipo id_equipo) {
		this.id_equipo = id_equipo;
	}
	
	
}
