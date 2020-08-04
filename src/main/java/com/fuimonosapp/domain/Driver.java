/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

/**
 *
 * @author Javier
 */
@Entity
@Table(schema = "public", name = "driver")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "username")
    private String username;
    
    @Column(name = "pass")
    private String pass;
    
    @Column(name = "nombre_driver")
    private String nombreDriver;

    @Column(name = "maximo_de_ordenes_conc")
    private Integer maximoOrdenesConc;

    @Column(name = "entrega_actual")
    private String entregaActual;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido_actual", referencedColumnName = "pedido_id")
    private Pedido pedidoActual;
    
    @Column(name = "habilitado")
    private Boolean habilitado;

    @Column(name = "horas_a_trabajar")
    private Integer horasATrabajar;
    
    @Column(name = "fecha_creado")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreado;

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombreDriver() {
        return nombreDriver;
    }

    public void setNombreDriver(String nombreDriver) {
        this.nombreDriver = nombreDriver;
    }

    public Integer getMaximoOrdenesConc() {
        return maximoOrdenesConc;
    }

    public void setMaximoOrdenesConc(Integer maximoOrdenesConc) {
        this.maximoOrdenesConc = maximoOrdenesConc;
    }

    public String getEntregaActual() {
        return entregaActual;
    }

    public void setEntregaActual(String entregaActual) {
        this.entregaActual = entregaActual;
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    public void setPedidoActual(Pedido pedidoActual) {
        this.pedidoActual = pedidoActual;
    }
    

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Integer getHorasATrabajar() {
        return horasATrabajar;
    }

    public void setHorasATrabajar(Integer horasATrabajar) {
        this.horasATrabajar = horasATrabajar;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }



    public Driver() {

    }

}
