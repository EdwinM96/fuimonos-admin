/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.domain.Departamento;
import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Javier
 */
@Service
public class DepartamentoService {
    @Autowired
    DepartamentoRepository depaRepository;
    
    @Autowired
    PaisService paisService;
    
    @Transactional
    public List<Departamento> findAll() {
        return depaRepository.findAll();
    }
    @Transactional
    public void save(Departamento depa) throws DataAccessException {
        depa.setPais(paisService.findOne(depa.getPais_id()));
         depaRepository.saveAndFlush(depa);
    }
    @Transactional
    public Departamento findOne(Integer code) throws DataAccessException {
        return depaRepository.getOne(code);
    }
    @Transactional
    public void delete(Integer departamento_id) throws DataAccessException {
        depaRepository.deleteById(departamento_id);

    }
    
}
