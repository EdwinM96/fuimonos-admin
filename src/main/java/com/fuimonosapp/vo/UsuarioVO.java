/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP PC
 */
public class UsuarioVO {

    @JsonProperty(value = "email", required = true)
    String email;
    
    @JsonProperty(value = "contrasena", required = true)
    String contrasena;
    
    @JsonProperty(value = "nombre", required = true)
    String nombre;
    
    @JsonProperty(value = "apellido", required = true)
    String apellido;
    
    @JsonProperty(value = "celular", required = true)
    String celular;

    @JsonProperty(value = "imagen", required = false)
    MultipartFile imagen;
    
    @JsonProperty(value = "usuario", required = false)
    String username;
    
    @JsonProperty(value = "fechaDeNacimiento", required = false)
    String fechaDeNacimiento;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public UsuarioVO() {
    }

    
}
