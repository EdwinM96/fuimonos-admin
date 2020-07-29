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
@Table(schema = "public", name = "opcionsubmenu")
public class OpcionSubMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opcionsubmenu_id")
    private Integer opcionsubmenuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "submenu_id")
    private Submenu submenu;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "seleccionado_por_defecto")
    private Boolean seleccionadoPorDefecto;

    @OneToOne(mappedBy = "opcionsubmenuId", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private OpcionDeSubMenuSeleccionado opcionDeSubMenuSeleccionado;

    @OneToMany(mappedBy = "opcionsubmenu", fetch = FetchType.LAZY)
    private List<SeleccionSubMenuPlatilloFavorito> seleccionSubMenuPlatilloFavoritos;
    
    @Column(name = "orden")
    private Integer orden;

    public OpcionDeSubMenuSeleccionado getOpcionDeSubMenuSeleccionado() {
        return opcionDeSubMenuSeleccionado;
    }

    public void setOpcionDeSubMenuSeleccionado(OpcionDeSubMenuSeleccionado opcionDeSubMenuSeleccionado) {
        this.opcionDeSubMenuSeleccionado = opcionDeSubMenuSeleccionado;
    }

    public List<SeleccionSubMenuPlatilloFavorito> getSeleccionSubMenuPlatilloFavoritos() {
        return seleccionSubMenuPlatilloFavoritos;
    }

    public void setSeleccionSubMenuPlatilloFavoritos(List<SeleccionSubMenuPlatilloFavorito> seleccionSubMenuPlatilloFavoritos) {
        this.seleccionSubMenuPlatilloFavoritos = seleccionSubMenuPlatilloFavoritos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

    public Submenu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Submenu submenu) {
        this.submenu = submenu;
    }

    public Integer getOpcionsubmenuId() {
        return opcionsubmenuId;
    }

    public void setOpcionsubmenuId(Integer opcionsubmenuId) {
        this.opcionsubmenuId = opcionsubmenuId;
    }

    

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }    

    public OpcionSubMenu() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getSeleccionadoPorDefecto() {
        return seleccionadoPorDefecto;
    }

    public void setSeleccionadoPorDefecto(Boolean seleccionadoPorDefecto) {
        this.seleccionadoPorDefecto = seleccionadoPorDefecto;
    }
    
    
}
