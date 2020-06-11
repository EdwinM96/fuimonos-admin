/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Javier
 */
@Entity
@Table(schema = "public", name = "pais")
public class Pais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Integer pais_id;
    
    
    @Column(name = "nombre_pais")
    private String nombre_pais;
    
    @OneToMany(mappedBy = "pais", fetch = FetchType.EAGER)
    private List<Departamento> departamentos;

    public Integer getPais_id() {
        return pais_id;
    }

    public void setPais_id(Integer pais_id) {
        this.pais_id = pais_id;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    public Pais(){
        
    }
}
