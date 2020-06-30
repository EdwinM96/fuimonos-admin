/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.MenuXCategoriaRepository;
import com.fuimonosapp.domain.MenuXCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP PC
 */
@Service
public class MenuXCategoriaService {
    
    @Autowired
    MenuXCategoriaRepository menuxcatRepo;
    
    public MenuXCategoria save(MenuXCategoria obj){
        return menuxcatRepo.saveAndFlush(obj);
    }
    
}
