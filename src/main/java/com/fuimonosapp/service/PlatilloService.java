/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.PlatilloRepository;
import com.fuimonosapp.domain.Platillo;
import com.fuimonosapp.repository.MenuRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author HP PC
 */

@Service
public class PlatilloService {
    
    @Autowired
    PlatilloRepository platRepo;
    
    @Autowired
    MenuRepository menuRepo;
    
    Integer PAGE_SIZE = 10;
    
    public Page<Platillo> findAllByMenu(Integer menuId, Integer currentPage, String searchWord){
        
        return platRepo.findByMenuOrderByOrden(menuRepo.findById(menuId).get(), PageRequest.of(currentPage, PAGE_SIZE));
        
    }
    
    public Platillo findOne(Integer platilloId){
        return platRepo.findById(platilloId).get();
    }
    
    public Platillo save(Platillo platillo){
        List<Platillo> platillos = platRepo.findByMenuOrderByOrden(platillo.getMenu());
        Integer i = 1;
        for(Platillo platilloItr : platillos){
            i++;
        }
        platillo.setOrden(i);
        return platRepo.saveAndFlush(platillo);
    }

    @Transactional
    public void eliminarPlatillo(Integer platilloId) {
        Platillo platillo = platRepo.findById(platilloId).get();
        List<Platillo> platillos = platRepo.findByMenuOrderByOrden(platillo.getMenu());
        List<Platillo> platilloSave = new ArrayList<Platillo>();
        for(Platillo platilloItr : platillos){
            if(platilloItr.getOrden()>platillo.getOrden()){
                platilloItr.setOrden(platilloItr.getOrden()-1);
                platilloSave.add(platilloItr);
            }
        }
        platRepo.saveAll(platillos);
        platRepo.delete(platillo);
    }
    
}
