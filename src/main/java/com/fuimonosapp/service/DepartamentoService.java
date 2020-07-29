/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.domain.*;
import com.fuimonosapp.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    
    Integer PAGE_SIZE = 10;
    
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
    
    public Page<Departamento> buscarDepartPorPais(Integer paisId, Integer currentPage ){
        
        Pais pais = paisService.findOne(paisId);
        
        return depaRepository.findByPais(pais, PageRequest.of(currentPage, PAGE_SIZE));
        
    }
    
}
