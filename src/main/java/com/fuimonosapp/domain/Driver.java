/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Javier
 */
@Entity
@Table(schema = "public", name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Integer driver_id;

    @Column(name = "nombre_driver")
    private String nombre_driver;

    @Column(name = "maximo_de_ordenes_conc")
    private Integer maximo_de_ordenes_conc;

    @Column(name = "entrega_actual")
    private String entrega_actual;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido_actual")
    private Pedido id_pedido_actual;
    
     @OneToOne(mappedBy = "driver_asignado", cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, optional = false)
        private Pedido pedidos;

    @Column(name = "habilitado")
    private Boolean habilitado;

    @Column(name = "horas_a_trabajar")
    private Integer horas_a_trabajar;

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }
    
    

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    public String getNombre_driver() {
        return nombre_driver;
    }

    public void setNombre_driver(String nombre_driver) {
        this.nombre_driver = nombre_driver;
    }

    public Integer getMaximo_de_ordenes_conc() {
        return maximo_de_ordenes_conc;
    }

    public void setMaximo_de_ordenes_conc(Integer maximo_de_ordenes_conc) {
        this.maximo_de_ordenes_conc = maximo_de_ordenes_conc;
    }

    public String getEntrega_actual() {
        return entrega_actual;
    }

    public void setEntrega_actual(String entrega_actual) {
        this.entrega_actual = entrega_actual;
    }

    public Pedido getId_pedido_actual() {
        return id_pedido_actual;
    }

    public void setId_pedido_actual(Pedido id_pedido_actual) {
        this.id_pedido_actual = id_pedido_actual;
    }



    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Integer getHoras_a_trabajar() {
        return horas_a_trabajar;
    }

    public void setHoras_a_trabajar(Integer horas_a_trabajar) {
        this.horas_a_trabajar = horas_a_trabajar;
    }

    public Driver() {

    }

}
