/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.domain;

import java.util.Date;
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
@Table(schema = "public", name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "municipio_id")
    private Integer municipio_id;

     @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento_id;

    @Column(name = "tiempo_de_entrega_estimado")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tiempo_de_entrega_estimado;
    
    @Column(name = "costo_de_entrega")
    private Integer costo_de_entrega;
    
    @Column(name = "nombre_municipio")
    private String nombre_municipio;

    public Integer getMunicipio_id() {
        return municipio_id;
    }

    public void setMunicipio_id(Integer municipio_id) {
        this.municipio_id = municipio_id;
    }

    public Departamento getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(Departamento departamento_id) {
        this.departamento_id = departamento_id;
    }



    public Date getTiempo_de_entrega_estimado() {
        return tiempo_de_entrega_estimado;
    }

    public void setTiempo_de_entrega_estimado(Date tiempo_de_entrega_estimado) {
        this.tiempo_de_entrega_estimado = tiempo_de_entrega_estimado;
    }

    public Integer getCosto_de_entrega() {
        return costo_de_entrega;
    }

    public void setCosto_de_entrega(Integer costo_de_entrega) {
        this.costo_de_entrega = costo_de_entrega;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public Municipio(){
        
    }
    
}
