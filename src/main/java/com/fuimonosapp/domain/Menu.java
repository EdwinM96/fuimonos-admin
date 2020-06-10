package com.fuimonosapp.domain;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(schema="public",name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="menu_id")
	private Integer menu_id;
	@Column(name="nombre_menu")
	private String nombre_menu;
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="restaurante_id")
	private Restaurante restaurante;
	
	@OneToMany(mappedBy="platillo",fetch=FetchType.EAGER)
	private List<Platillo> platillos ;
	/*
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, optional = false)
        private MenuXCategoria menuxcategorias;
        
    public MenuXCategoria getMenuxcategorias() {
        return menuxcategorias;
    }

    public void setMenuxcategorias(MenuXCategoria menuxcategorias) {
        this.menuxcategorias = menuxcategorias;
    }
        
        

	public List<Platillo> getPlatillos() {
		return platillos;
	}

	public void setPlatillos(List<Platillo> platillos) {
		this.platillos = platillos;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
        */
	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public String getNombre_menu() {
		return nombre_menu;
	}

	public void setNombre_menu(String nombre_menu) {
		this.nombre_menu = nombre_menu;
	}

	
	public Menu() {
		
	}

}
