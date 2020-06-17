/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.repository.MenuRepository;
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
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    
    @Transactional
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
    @Transactional
    public Menu save(Menu menu) throws DataAccessException {
        return menuRepository.saveAndFlush(menu);
    }
    @Transactional
    public Menu findOne(Integer code) throws DataAccessException {
        return menuRepository.getOne(code);
    }
    @Transactional
    public void delete(Integer menu_id) throws DataAccessException {
        menuRepository.deleteById(menu_id);

    }
}
