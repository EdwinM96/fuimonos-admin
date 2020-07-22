/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP PC
 */
@Repository
public interface RestauranteDestacadoRepository extends JpaRepository<RestauranteDestacado, Integer> {
    public Page<RestauranteDestacado> findOrderByOrden(Pageable p);
}
