/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.domain;

import java.util.Date;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Javier
 */
@Entity
@Table(schema = "public", name = "pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer pedido_id;
    
    @Column(name = "codigo_pedido")
    private String codido_pedido;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante_id;
    
    @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "driver_asignado")
    private Driver driver_asignado;
    
    @OneToOne(mappedBy = "id_pedido_actual", cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, optional = false)
        private Driver drivers;
    
    @Column(name = "forma_de_pago")
    private String forma_de_pago;
    
    @Column(name = "total_de_pedido")
    private Integer total_de_pedido;
    
    @Column(name = "pedido_pagado")
    private Boolean pedido_pagado;
    
    @Column(name = "fecha_ordenado")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_ordenado;
    
    @Column(name = "tiempo_prom_entrega")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tiempo_prom_entrega;

    public Driver getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver drivers) {
        this.drivers = drivers;
    }
    
    

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public String getCodido_pedido() {
        return codido_pedido;
    }

    public void setCodido_pedido(String codido_pedido) {
        this.codido_pedido = codido_pedido;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Restaurante getRestaurante_id() {
        return restaurante_id;
    }

    public void setRestaurante_id(Restaurante restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    public Driver getDriver_asignado() {
        return driver_asignado;
    }

    public void setDriver_asignado(Driver driver_asignado) {
        this.driver_asignado = driver_asignado;
    }

   

   

   

    public String getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(String forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }

    public Integer getTotal_de_pedido() {
        return total_de_pedido;
    }

    public void setTotal_de_pedido(Integer total_de_pedido) {
        this.total_de_pedido = total_de_pedido;
    }

    public Boolean getPedido_pagado() {
        return pedido_pagado;
    }

    public void setPedido_pagado(Boolean pedido_pagado) {
        this.pedido_pagado = pedido_pagado;
    }

    public Date getFecha_ordenado() {
        return fecha_ordenado;
    }

    public void setFecha_ordenado(Date fecha_ordenado) {
        this.fecha_ordenado = fecha_ordenado;
    }

    public Date getTiempo_prom_entrega() {
        return tiempo_prom_entrega;
    }

    public void setTiempo_prom_entrega(Date tiempo_prom_entrega) {
        this.tiempo_prom_entrega = tiempo_prom_entrega;
    }
    
    public Pedido(){
        
    }
    
}
