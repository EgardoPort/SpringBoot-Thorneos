package com.thorneos.main.entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="escenario")
public class Escenario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private int id;

	@Column (name="direccion")
	private String direccion;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="hora_reserva")
	private Time hora_reserva;
	
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	@Column (name="fecha_reserva")
	private Date fecha_reserva;
	
	@Column (name="estadoesce")
	private String estadoesce;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Time getHora_reserva() {
		return hora_reserva;
	}

	public void setHora_reserva(Time hora_reserva) {
		this.hora_reserva = hora_reserva;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public String getEstadoesce() {
		return estadoesce;
	}

	public void setEstadoesce(String estadoesce) {
		this.estadoesce = estadoesce;
	}
}
