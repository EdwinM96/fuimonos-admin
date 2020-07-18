/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fuimonosapp.domain.*;
import com.fuimonosapp.repository.PlatilloRepository;
import com.fuimonosapp.repository.SubmenuRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP PC
 */

@Service
public class SubmenuService {
    
    @Autowired
    SubmenuRepository smRepo;
    
    @Autowired
    PlatilloRepository pRepo;
    
    int PAGE_SIZE = 10;
    
    public Page<Submenu> findAllByPlatillo(Integer platilloId,Integer page, String searchword ){
        return smRepo.findByPlatilloOrderByOrden(pRepo.findById(platilloId).get(), PageRequest.of(page, PAGE_SIZE));
    }
    
    public Submenu save(Submenu submenu){
        List<Submenu> submenus = smRepo.findByPlatilloOrderByOrden(submenu.getPlatillo());
        Integer i = 1;
        for(Submenu submenuItr : submenus){
            i++;
        }
        submenu.setOrden(i);
        return smRepo.saveAndFlush(submenu);
    }
    
    @Transactional
    public void posicionarSubMenuArriba(Integer submenuId) {
        Submenu submenu = smRepo.findById(submenuId).get();
        List<Submenu> submenus = smRepo.findByPlatilloOrderByOrden(submenu.getPlatillo());
        Integer posicionSubmenu = submenu.getOrden() - 1;
        if(posicionSubmenu == 0){return;}
        Submenu submenuOrderToReplace = new Submenu();
        for(Submenu submenuIter: submenus){
            if(submenuIter.getOrden().equals(posicionSubmenu)){
               submenuOrderToReplace = submenuIter;
            }
        }
        submenuOrderToReplace.setOrden(submenu.getOrden());
        submenu.setOrden(posicionSubmenu);
        smRepo.save(submenu);
        smRepo.save(submenuOrderToReplace);
    }
    
    @Transactional
    public void posicionarSubMenuoAbajo(Integer submenuId){
        Submenu submenu = smRepo.findById(submenuId).get();
        List<Submenu> submenus = smRepo.findByPlatilloOrderByOrden(submenu.getPlatillo());
        Integer posicionSubmenu = submenu.getOrden() + 1;
        if(posicionSubmenu == 0){return;}
        Submenu submenuOrderToReplace = new Submenu();
        Integer lastItemOrden = 1;
        for(Submenu submenuIter: submenus){
            if(submenuIter.getOrden().equals(posicionSubmenu)){
                submenuOrderToReplace = submenuIter;
            }
        
           lastItemOrden = submenuIter.getOrden();
        }
        if(lastItemOrden<posicionSubmenu){
            return;
        }
        submenuOrderToReplace.setOrden(submenu.getOrden());
        submenu.setOrden(posicionSubmenu);
        smRepo.save(submenu);
        smRepo.save(submenuOrderToReplace);
    }

}
