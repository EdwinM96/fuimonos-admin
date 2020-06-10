package com.fuimonosapp.domain;

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
@Table(schema="public",name="opcionessubmenu")
public class OpcionesSubMenu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="opcionessubmenu_id")
	private Integer opcionessubmenu_id;
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="submenu_id")
	private Submenu submenu;
	*/
	@Column(name="nombre_opcion")
	private String nombre_opcion;
	
	@Column(name="costo_opcion")
	private Integer costo_opcion;

	
        /*
	public Submenu getSubmenu() {
		return submenu;
	}


	public void setSubmenu(Submenu submenu) {
		this.submenu = submenu;
	}
        */

	public Integer getOpcionessubmenu_id() {
		return opcionessubmenu_id;
	}


	public void setOpcionessubmenu_id(Integer opcionessubmenu_id) {
		this.opcionessubmenu_id = opcionessubmenu_id;
	}


	


	public String getNombre_opcion() {
		return nombre_opcion;
	}


	public void setNombre_opcion(String nombre_opcion) {
		this.nombre_opcion = nombre_opcion;
	}


	public Integer getCosto_opcion() {
		return costo_opcion;
	}


	public void setCosto_opcion(Integer costo_opcion) {
		this.costo_opcion = costo_opcion;
	}
	
	public OpcionesSubMenu () {
		
	}
}
