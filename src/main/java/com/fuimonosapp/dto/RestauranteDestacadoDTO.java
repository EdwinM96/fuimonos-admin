/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.dto;

import java.util.List;
import com.fuimonosapp.domain.*;

/**
 *
 * @author HP PC
 */
public class RestauranteDestacadoDTO {

    public String encabezado = "Restaurantes populares";
    public List<RestauranteDestacado> restaurantes;

    public RestauranteDestacadoDTO() {
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public List<RestauranteDestacado> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<RestauranteDestacado> restaurantes) {
        this.restaurantes = restaurantes;
    }

}
