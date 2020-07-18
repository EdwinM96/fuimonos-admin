/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Platillo;
import com.fuimonosapp.domain.Submenu;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Javier
 */
@Repository
public interface SubmenuRepository extends JpaRepository<Submenu, Integer> {

    public Page<Submenu> findByPlatilloOrderByOrden(Platillo platillo, Pageable pageable);
    
    public List<Submenu> findByPlatilloOrderByOrden(Platillo platillo);
}
