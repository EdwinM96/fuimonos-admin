package com.fuimonosapp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="subemnu")
public class Submenu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="submenu_id")
	private Integer submenu_id;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="platillo_id")
	private Platillo platillo;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="menucobrado")
	private Boolean menucobrado;
	
	@Column(name="cobrarapartirde")
	private Integer cobrarapartirde;
	
	@Column(name="maximoopcionesaescoger")
	private Integer maximoopcionesaescoger;
	
       @OneToMany(mappedBy="opcionessubmenu_id",fetch=FetchType.EAGER)
	private List<OpcionesSubMenu> opcionesSubMenus;
	
	


	public List<OpcionesSubMenu> getOpcionesSubMenus() {
		return opcionesSubMenus;
	}


	public void setOpcionesSubMenus(List<OpcionesSubMenu> opcionesSubMenus) {
		this.opcionesSubMenus = opcionesSubMenus;
	}
        

	public Integer getSubmenu_id() {
		return submenu_id;
	}


	public void setSubmenu_id(Integer submenu_id) {
		this.submenu_id = submenu_id;
	}


	public Platillo getPlatillo() {
		return platillo;
	}


	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Boolean getMenucobrado() {
		return menucobrado;
	}


	public void setMenucobrado(Boolean menucobrado) {
		this.menucobrado = menucobrado;
	}


	public Integer getCobrarapartirde() {
		return cobrarapartirde;
	}


	public void setCobrarapartirde(Integer cobrarapartirde) {
		this.cobrarapartirde = cobrarapartirde;
	}


	public Integer getMaximoopcionesaescoger() {
		return maximoopcionesaescoger;
	}


	public void setMaximoopcionesaescoger(Integer maximoopcionesaescoger) {
		this.maximoopcionesaescoger = maximoopcionesaescoger;
	}
	
	public String getMenuCobradoDelegate() {
		if(this.menucobrado==null) return"";
		else {
			return menucobrado == true?"Ativo":"Inactivo";
		}
	}
	public Submenu() {
		
	}

}
