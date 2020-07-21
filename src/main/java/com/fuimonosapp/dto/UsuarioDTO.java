/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.dto;

import java.util.Date;

/**
 *
 * @author HP PC
 */
public class UsuarioDTO {
    
    String nombre;
    String apellido;
    String usuario;
    String celular;
    Date fechaDeNacimiento;
    Byte[] imagenDePerfil;

    public UsuarioDTO() {
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Byte[] getImagenDePerfil() {
        return imagenDePerfil;
    }

    public void setImagenDePerfil(Byte[] imagenDePerfil) {
        this.imagenDePerfil = imagenDePerfil;
    }
    
    
    
}
