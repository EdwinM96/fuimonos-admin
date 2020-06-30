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
@Table(schema="public",name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categoria_id")
	private Integer categoriaId;
	
	@Column(name="nombre_categoria")
	private String nombreCategoria;

        @OneToMany(mappedBy = "categoria_id")
        private List<MenuXCategoria> menuxcategorias;

    public List<MenuXCategoria> getMenuxcategorias() {
        return menuxcategorias;
    }

    public void setMenuxcategorias(List<MenuXCategoria> menuxcategorias) {
        this.menuxcategorias = menuxcategorias;
    }



    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
        
        
	
	public Categoria() {
		
	}
	
}
