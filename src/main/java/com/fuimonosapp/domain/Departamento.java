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
@Table(schema = "public", name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departamento_id")
    private Integer departamento_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Pais pais;


    

    @Column(name = "nombre_departamento")
    private String nombre_departamento;
    
    @OneToOne(mappedBy = "departamento_id", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Restaurante restaurante;
    
    @OneToOne(mappedBy = "departamento_id", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Municipio municipio;

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    
    
    public Integer getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(Integer departamento_id) {
        this.departamento_id = departamento_id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

  

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }



   
    
    

    public Departamento() {

    }

}