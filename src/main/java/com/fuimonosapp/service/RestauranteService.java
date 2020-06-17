/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.RestauranteRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fuimonosapp.domain.Restaurante;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author HP PC
 */
@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository restaRepository;

    @Transactional
    public List<Restaurante> findAll() {
        return restaRepository.findAll();
    }
    @Transactional
    public Restaurante save(Restaurante restaurante) throws DataAccessException {
        return restaRepository.saveAndFlush(restaurante);
    }
    @Transactional
    public Restaurante findOne(Integer code) throws DataAccessException {
        return restaRepository.getOne(code);
    }
    @Transactional
    public void delete(Integer restaurante_id) throws DataAccessException {
        restaRepository.deleteById(restaurante_id);

    }

}
