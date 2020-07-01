/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Platillo;
import com.fuimonosapp.domain.Menu;
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
public interface PlatilloRepository extends JpaRepository<Platillo, Integer> {
    
    public Page<Platillo> findByMenuOrderByOrden(Menu menu, Pageable pageable);
    
    public List<Platillo> findByMenuOrderByOrden(Menu menu);
}
