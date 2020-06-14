/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.RestauranteRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fuimonosapp.domain.Restaurante;
import java.util.List;
/**
 *
 * @author HP PC
 */
@Service
public class RestauranteService {
    
    @Autowired
    RestauranteRepository restaRepository;
    
    @Transactional
    public List<Restaurante> findAll(){
        return restaRepository.findAll();
    }
    
   public Restaurante save(Restaurante restaurante){
        return restaRepository.saveAndFlush(restaurante);
    } 
    
}
