/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fuimonosapp.domain.OpcionSubMenu;
/**
 *
 * @author Javier
 */
@Repository
public interface OpcionSubMenuRepository extends JpaRepository<OpcionSubMenu, Integer> {
    
}