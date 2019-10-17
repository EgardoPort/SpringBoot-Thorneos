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
@Table(name = "torneo")
public class PuntajeDeportista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@JoinColumn(name = "id_deportista")
	@ManyToOne(fetch = FetchType.EAGER)
	private Deportista id_deportista;
	@JoinColumn(name = "id_partido")
	@ManyToOne(fetch = FetchType.EAGER)
	private Partido id_partido;
	@Column(name = "puntaje")
	private int puntaje;
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
	public Partido getId_partido() {
		return id_partido;
	}
	public void setId_partido(Partido id_partido) {
		this.id_partido = id_partido;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
