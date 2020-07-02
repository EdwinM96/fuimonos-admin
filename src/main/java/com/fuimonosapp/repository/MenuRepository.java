/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.domain.Restaurante;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Javier
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    
    public List<Menu> findByRestauranteOrderByOrden(Restaurante restaurante);
    
    public Page<Menu> findByRestauranteOrderByOrden(Restaurante restaurante, Pageable pageable);
    
}
