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
import javax.persistence.Table;

/**
 *
 * @author Javier
 */
@Entity
@Table(schema = "public", name = "seleccionsubmenuplatillofavorito")
public class SeleccionSubMenuPlatilloFavorito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seleccionsubmenuplatillofavorito_id")
    private Integer seleccionsubmenuplatillofavorito_id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opcionsubmenu_id")
    private OpcionSubMenu opcionsubmenu;

    public Integer getSeleccionsubmenuplatillofavorito_id() {
        return seleccionsubmenuplatillofavorito_id;
    }

    public void setSeleccionsubmenuplatillofavorito_id(Integer seleccionsubmenuplatillofavorito_id) {
        this.seleccionsubmenuplatillofavorito_id = seleccionsubmenuplatillofavorito_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public OpcionSubMenu getOpcionsubmenu() {
        return opcionsubmenu;
    }

    public void setOpcionsubmenu(OpcionSubMenu opcionsubmenu) {
        this.opcionsubmenu = opcionsubmenu;
    }
    
    public SeleccionSubMenuPlatilloFavorito(){
        
    }
    
}
