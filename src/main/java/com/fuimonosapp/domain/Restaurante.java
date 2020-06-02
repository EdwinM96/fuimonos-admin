package com.fuimonosapp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(schema="public",name="restaurante")
public class Restaurante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="restaurante_id")
	private Integer restaurante_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="menu",fetch=FetchType.EAGER)
	private List<Menu> menus;


	public List<Menu> getMenus() {
		return menus;
	}


	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}


	public Integer getRestaurante_id() {
		return restaurante_id;
	}


	public void setRestaurante_id(Integer restaurante_id) {
		this.restaurante_id = restaurante_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Restaurante() {
		
	}
	
}
