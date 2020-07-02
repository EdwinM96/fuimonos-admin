package com.fuimonosapp.domain;

import java.util.List;
import java.util.Set;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(schema="public",name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="menu_id")
	private Integer menuId;
        
	@Column(name="nombre_menu")
	private String nombreMenu;
        
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="restaurante_id")
	private Restaurante restaurante;
	
	@OneToMany(mappedBy="menu")
	private List<Platillo> platillos ;
	
        @OneToMany(mappedBy = "menu_id")
        private List<MenuXCategoria> menuxcategorias;
        
        @Column(name="orden")
        private Integer orden;
        
        @Transient
        private Integer restauranteId;

	public Menu() {
		
	}

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }

    public List<MenuXCategoria> getMenuxcategorias() {
        return menuxcategorias;
    }

    public void setMenuxcategorias(List<MenuXCategoria> menuxcategorias) {
        this.menuxcategorias = menuxcategorias;
    }

    public Integer getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Integer restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
        
        

}
