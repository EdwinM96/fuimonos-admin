/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Departamento;
import com.fuimonosapp.domain.Municipio;
import com.fuimonosapp.domain.Pais;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Javier
 */
@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    Page<Municipio> findByDepartamento(Departamento departamento, Pageable pageable);

}
