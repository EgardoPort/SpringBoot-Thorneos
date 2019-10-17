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
@Table(name = "detalle_deportista")
public class DetalleDeportista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@JoinColumn(name = "id_deportista")
	@ManyToOne(fetch = FetchType.EAGER)
	private Deportista id_deportista;
	@JoinColumn(name = "id_disciplina")
	@ManyToOne(fetch = FetchType.EAGER)
	private Disciplina id_disciplina;
	
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
	public Disciplina getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(Disciplina id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

}
