/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Administrador;
import com.fuimonosapp.domain.PlatilloSeleccionado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Javier
 */
@Repository
public interface PlatilloSeleccionadoRepository extends JpaRepository<PlatilloSeleccionado, Integer> {
    
}
