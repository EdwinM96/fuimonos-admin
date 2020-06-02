package com.fuimonosapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(schema="public",name="administrador")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="administrador_id")
	private Integer administrador_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="ultimo_inicio")
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date ultimo_inicio;
	
	@Column(name="fecha_creacion")
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private Date fecha_creacion;

	public Integer getAdministrador_id() {
		return administrador_id;
	}

	public void setAdministrador_id(Integer administrador_id) {
		this.administrador_id = administrador_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getUltimo_inicio() {
		return ultimo_inicio;
	}

	public void setUltimo_inicio(Date ultimo_inicio) {
		this.ultimo_inicio = ultimo_inicio;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	public Administrador() {
		
	}
}