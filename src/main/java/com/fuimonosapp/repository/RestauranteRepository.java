/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Restaurante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Javier
 */
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    
    public Page<Restaurante> findAll(Pageable pageable);
    
    public Page<Restaurante> findAllByOrderByRestauranteIdDesc(Pageable pageable);
    
    public Page<Restaurante> findByNombreContainsOrderByRestauranteIdDesc(String nombre, Pageable pageable);
    
}
