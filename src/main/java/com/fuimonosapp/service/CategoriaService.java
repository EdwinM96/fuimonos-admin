/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fuimonosapp.repository.CategoriaRepository;
import com.fuimonosapp.domain.Categoria;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author HP PC
 */

@Service
public class CategoriaService {
    
    @Autowired
    CategoriaRepository cateRepo;
    
    public List<Categoria> getAllCategorias(){
        return cateRepo.findAll();
    }
    
    public Categoria findOne(Integer id){
        return cateRepo.findById(id).get();
    }
    
}
