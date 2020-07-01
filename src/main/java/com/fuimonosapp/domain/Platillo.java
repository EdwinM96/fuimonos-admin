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
@Table(schema = "public", name = "platillo")
public class Platillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platillo_id")
    private Integer platillo_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio_base")
    private Integer precio_base;
    
    @Column(name = "orden")
    private Integer orden;
    
    @OneToMany(mappedBy = "platillo")
    private List<Submenu> submenus;
    
     @OneToMany(mappedBy = "platillo", fetch = FetchType.EAGER)
    private List<PlatilloFavorito> platillosFavoritos;
     
      @OneToMany(mappedBy = "platillo")
    private List<PlatilloSeleccionado> platillosSeleccionados;

    @Column(name = "imagen")
    private String imagen;

    public List<PlatilloSeleccionado> getPlatillosSeleccionados() {
        return platillosSeleccionados;
    }

    public void setPlatillosSeleccionados(List<PlatilloSeleccionado> platillosSeleccionados) {
        this.platillosSeleccionados = platillosSeleccionados;
    }

    
    public List<PlatilloFavorito> getPlatillosFavoritos() {
        return platillosFavoritos;
    }

    public void setPlatillosFavoritos(List<PlatilloFavorito> platillosFavoritos) {
        this.platillosFavoritos = platillosFavoritos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

    public List<Submenu> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<Submenu> submenus) {
        this.submenus = submenus;
    }

    public Integer getPlatillo_id() {
        return platillo_id;
    }

    public void setPlatillo_id(Integer platillo_id) {
        this.platillo_id = platillo_id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(Integer precio_base) {
        this.precio_base = precio_base;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
    

    public Platillo() {

    }
}
