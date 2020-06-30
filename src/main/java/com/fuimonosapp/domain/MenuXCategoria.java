package com.fuimonosapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="menuxcategoria")
public class MenuXCategoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="menuxcategoria_id")
	private Integer menuxcategoria_id;
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "menu_id")
	private Menu menu_id;
	
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "categoria_id")
	private Categoria categoria_id;
        
	public Integer getMenuxcategoria_id() {
		return menuxcategoria_id;
	}

	public void setMenuxcategoria_id(Integer menuxcategoria_id) {
		this.menuxcategoria_id = menuxcategoria_id;
	}

        public Menu getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Menu menu_id) {
		this.menu_id = menu_id;
	}

	public Categoria getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Categoria categoria_id) {
		this.categoria_id = categoria_id;
	}
        
	public MenuXCategoria() {
		
	}
}
