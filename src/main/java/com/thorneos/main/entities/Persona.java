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
@Table(name ="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_persona;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String dui;
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	private String direccion;
	private String usuario;
	private String clave;
	@Column(name = "tipo_Usuario")
	private String tipoUsuario;
	
	public int getId() {
		return id_persona;
	}
	
	public void setId(int id_persona) {
		this.id_persona = id_persona;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDui() {
		return dui;
	}
	
	public void setDui(String dui) {
		this.dui = dui;
	}
	
	public Date getFechaNacimiento() {
		return fecha_nacimiento;
	}
	
	public void setFechaNacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
