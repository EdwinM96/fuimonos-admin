/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Javier
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    
    Page<Driver> findAll(Pageable pageable);
    
    Page<Driver> findAllByUsernameContainsOrderByDriverId(String username, Pageable pageable);
}
