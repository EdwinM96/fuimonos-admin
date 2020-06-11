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
    private Integer opcionsubmenu_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "submenu_id")
    private Submenu submenu;

    @Column(name = "nombre")
    private String nombre_opcion;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "seleccionado_por_defecto")
    private Boolean seleccionado_por_defecto;
    
    @OneToOne(mappedBy = "opcionsubmenu_id", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private OpcionDeSubMenuSeleccionado opcionDeSubMenuSeleccionado;
     
     @OneToMany(mappedBy = "opcionsubmenu", fetch = FetchType.EAGER)
    private List<SeleccionSubMenuPlatilloFavorito> seleccionSubMenuPlatilloFavoritos;

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
     
     

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Boolean getSeleccionado_por_defecto() {
        return seleccionado_por_defecto;
    }

    public void setSeleccionado_por_defecto(Boolean seleccionado_por_defecto) {
        this.seleccionado_por_defecto = seleccionado_por_defecto;
    }
    
    
    
    
    
    public Submenu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Submenu submenu) {
        this.submenu = submenu;
    }

    public Integer getOpcionsubmenu_id() {
        return opcionsubmenu_id;
    }

    public void setOpcionsubmenu_id(Integer opcionsubmenu_id) {
        this.opcionsubmenu_id = opcionsubmenu_id;
    }

    public String getNombre_opcion() {
        return nombre_opcion;
    }

    public void setNombre_opcion(String nombre_opcion) {
        this.nombre_opcion = nombre_opcion;
    }

  

    public OpcionSubMenu() {

    }
}
