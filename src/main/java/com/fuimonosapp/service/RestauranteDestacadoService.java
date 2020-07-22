/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.RestauranteDestacadoRepository;
import com.fuimonosapp.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP PC
 */

@Service
public class RestauranteDestacadoService {
    
    @Autowired
    RestauranteDestacadoRepository rdRepo;
    
    public RestauranteDestacado save(RestauranteDestacado rd){
        return rdRepo.save(rd);
    }
    
    public List<RestauranteDestacado> findByOrden(){
        return rdRepo.findAllByOrderByOrden(PageRequest.of(0, 10)).getContent();
    }
    
}
