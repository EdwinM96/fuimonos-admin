package com.fuimonosapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categoria_id")
	private Integer categoria_id;
	
	@Column(name="nombre_categoria")
	private String nombre_categoria;

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
        */
        
        
	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	
	public Categoria() {
		
	}
	
}
