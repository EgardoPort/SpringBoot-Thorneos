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
@Table(name = "detalle_torneo")
public class DetalleTorneo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@JoinColumn(name = "id_torneo")
	@ManyToOne(fetch = FetchType.EAGER)
	private Torneo id_torneo;
	@JoinColumn(name = "id_equipo")
	@ManyToOne(fetch = FetchType.EAGER)
	private Equipo id_equipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Torneo getId_torneo() {
		return id_torneo;
	}
	public void setId_torneo(Torneo id_torneo) {
		this.id_torneo = id_torneo;
	}
	public Equipo getId_equipo() {
		return id_equipo;
	}
	public void setId_equipo(Equipo id_equipo) {
		this.id_equipo = id_equipo;
	}
	
}
