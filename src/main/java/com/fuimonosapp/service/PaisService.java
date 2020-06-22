/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.domain.Pais;
import com.fuimonosapp.repository.PaisRepository;
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
public class PaisService {
    @Autowired
    PaisRepository paisRepository;
    
    @Transactional
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }
    @Transactional
    public void save(Pais pais) throws DataAccessException {
         paisRepository.saveAndFlush(pais);
    }
    @Transactional
    public Pais findOne(Integer code) throws DataAccessException {
        return paisRepository.getOne(code);
    }
    @Transactional
    public void delete(Integer pais_id) throws DataAccessException {
        paisRepository.deleteById(pais_id);

    }
    
}
