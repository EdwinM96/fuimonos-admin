/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.domain;

import java.io.Serializable;
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
 * @author HP PC
 */
@Entity
@Table(schema = "public", name = "restaurante_destacado")
public class RestauranteDestacado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurante_destacado_id")
    Integer restauranteDestacadoId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    
    @Column(name = "nombre")
    String nombre;
    
    @Column(name = "imagen")
    String imagen;
    
    @Column(name = "monto_minimo")
    Double montoMinimo;
    
    @Column(name = "orden")
    Integer orden;
    
    @Column(name = "logo")
    String logo;

    public RestauranteDestacado() {
    }

    
    
    public Integer getRestauranteDestacadoId() {
        return restauranteDestacadoId;
    }

    public void setRestauranteDestacadoId(Integer restauranteDestacadoId) {
        this.restauranteDestacadoId = restauranteDestacadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(Double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    
    
}
