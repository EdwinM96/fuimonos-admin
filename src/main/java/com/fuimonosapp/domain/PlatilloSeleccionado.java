/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Javier
 */
@Entity
@Table(schema = "public", name = "platilloseleccionado")
public class PlatilloSeleccionado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platilloseleccionado_id")
    private Integer platilloseleccionado_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platillo_id")
    private Platillo platillo;

    @OneToOne(mappedBy = "platilloseleccionado_id", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private OpcionDeSubMenuSeleccionado opcionDeSubMenuSeleccionado;

    @Column(name = "precio_total")
    private Integer precio_total;

    @Column(name = "nombre")
    private String nombre;

    public OpcionDeSubMenuSeleccionado getOpcionDeSubMenuSeleccionado() {
        return opcionDeSubMenuSeleccionado;
    }

    public void setOpcionDeSubMenuSeleccionado(OpcionDeSubMenuSeleccionado opcionDeSubMenuSeleccionado) {
        this.opcionDeSubMenuSeleccionado = opcionDeSubMenuSeleccionado;
    }

  
    public Integer getPlatilloseleccionado_id() {
        return platilloseleccionado_id;
    }

    public void setPlatilloseleccionado_id(Integer platilloseleccionado_id) {
        this.platilloseleccionado_id = platilloseleccionado_id;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public Integer getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Integer precio_total) {
        this.precio_total = precio_total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PlatilloSeleccionado() {

    }

}
