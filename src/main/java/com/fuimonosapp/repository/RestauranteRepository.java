/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Javier
 */
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    
}
