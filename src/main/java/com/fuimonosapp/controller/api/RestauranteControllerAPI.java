/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller.api;

import com.fuimonosapp.service.RestauranteDestacadoService;
import com.fuimonosapp.util.APIAuthentication;
import com.fuimonosapp.domain.*;
import com.fuimonosapp.dto.RestauranteDestacadoDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP PC
 */

@RestController
public class RestauranteControllerAPI {
    
    @Autowired
    RestauranteDestacadoService rdService;
    
    APIAuthentication auth = new APIAuthentication();
    
    @PostMapping(value = "/restaurantes/destacados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> restaurantesDestacados(HttpServletRequest request){
        ResponseEntity re = auth.authenticateRequest(request);
        if(re!=null){return re;}
        RestauranteDestacadoDTO restaDTO = new RestauranteDestacadoDTO();
        List<RestauranteDestacado> restaurantes = rdService.findByOrden();
        restaDTO.setRestaurantes(restaurantes);
        return new ResponseEntity(restaDTO, HttpStatus.OK);
    }
    
}
