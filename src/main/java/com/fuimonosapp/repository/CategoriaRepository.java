/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Javier
 */
public interface  CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
