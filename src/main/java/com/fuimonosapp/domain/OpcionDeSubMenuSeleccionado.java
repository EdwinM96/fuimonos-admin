/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Javier
 */
@Entity
@Table(schema = "public", name = "opciondesubmenuseleccionado")
public class OpcionDeSubMenuSeleccionado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opciondesubmenuseleccionado_id")
    private Integer opciondesubmenuseleccionadoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opcionsubmenuId")
    private OpcionSubMenu opcionsubmenuId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platilloseleccionado_id")
    private PlatilloSeleccionado platilloseleccionado_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Integer precio;

    public Integer getOpciondesubmenuseleccionadoId() {
        return opciondesubmenuseleccionadoId;
    }

    public void setOpciondesubmenuseleccionadoId(Integer opciondesubmenuseleccionadoId) {
        this.opciondesubmenuseleccionadoId = opciondesubmenuseleccionadoId;
    }

    public OpcionSubMenu getOpcionsubmenuId() {
        return opcionsubmenuId;
    }

    public void setOpcionsubmenuId(OpcionSubMenu opcionsubmenuId) {
        this.opcionsubmenuId = opcionsubmenuId;
    }
    

    
    public PlatilloSeleccionado getPlatilloseleccionado_id() {
        return platilloseleccionado_id;
    }

    public void setPlatilloseleccionado_id(PlatilloSeleccionado platilloseleccionado_id) {
        this.platilloseleccionado_id = platilloseleccionado_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }


    public OpcionDeSubMenuSeleccionado() {

    }
}
