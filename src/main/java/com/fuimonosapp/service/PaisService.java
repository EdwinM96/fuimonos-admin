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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Javier
 */
@Service
public class PaisService {

    private final PaisRepository paisRepository;

    private static final Integer PAGE_SIZE = 10;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    public Page<Pais> findAllbyPage(Integer currentPage) {
        return paisRepository.findAll(PageRequest.of(currentPage, PAGE_SIZE));
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
