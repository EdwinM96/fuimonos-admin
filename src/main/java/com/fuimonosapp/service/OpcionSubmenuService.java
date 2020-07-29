/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.domain.OpcionSubMenu;
import com.fuimonosapp.domain.Platillo;
import com.fuimonosapp.domain.Submenu;
import com.fuimonosapp.repository.OpcionSubMenuRepository;
import com.fuimonosapp.repository.SubmenuRepository;
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
public class OpcionSubmenuService {
    
    @Autowired
    OpcionSubMenuRepository osmRepo;
    
    @Autowired
    SubmenuRepository smRepo;
    
    Integer PAGE_SIZE = 10;
    
    public OpcionSubMenu findOne(Integer opcionSubmenuId){
        return osmRepo.findById(opcionSubmenuId).get();
    }
    
    public Page<OpcionSubMenu> findAllBySubmenu(Integer submenuId, Integer currentPage, String searchWord){
        return osmRepo.findAllBySubmenuOrderByOrden(smRepo.findById(submenuId).get(), PageRequest.of(currentPage, PAGE_SIZE));
    }
    
    public OpcionSubMenu save(OpcionSubMenu osm){
        List<OpcionSubMenu> submenus = osmRepo.findBySubmenuOrderByOrden(osm.getSubmenu());
        Integer i = 1;
        for(OpcionSubMenu osms : submenus){
            i++;
        }
        osm.setOrden(i);
        return osmRepo.saveAndFlush(osm);
    }
    
    @Transactional
    public void posicionarOpcionSubmenuArriba(Integer opcionSubmenuId) {
        OpcionSubMenu osm = osmRepo.findById(opcionSubmenuId).get();
        List<OpcionSubMenu> osmS = osmRepo.findBySubmenuOrderByOrden(osm.getSubmenu());
        Integer posicionOpcionSubmenu = osm.getOrden() - 1;
        if(posicionOpcionSubmenu == 0){return;}
        OpcionSubMenu opcionSubmenuToReplace = new OpcionSubMenu();
        for(OpcionSubMenu osmIter: osmS){
            if(osmIter.getOrden().equals(posicionOpcionSubmenu)){
                opcionSubmenuToReplace = osmIter;
                break;
            }
        }
        opcionSubmenuToReplace.setOrden(osm.getOrden());
        osm.setOrden(posicionOpcionSubmenu);
        osmRepo.save(osm);
        osmRepo.save(opcionSubmenuToReplace);
    }
    
    @Transactional
    public void posicionarOpcionSubmenuAbajo(Integer opcionSubmenuId){
        OpcionSubMenu osm = osmRepo.findById(opcionSubmenuId).get();
        List<OpcionSubMenu> osmS = osmRepo.findBySubmenuOrderByOrden(osm.getSubmenu());
        Integer posicionOpcionSubmenu = osm.getOrden() + 1;
        if(posicionOpcionSubmenu == 0){return;}
        OpcionSubMenu opcionSubmenuToReplace = new OpcionSubMenu();
        Integer lastItemOrden = 1;
        for(OpcionSubMenu osmIter: osmS){
            if(osmIter.getOrden().equals(posicionOpcionSubmenu)){
                opcionSubmenuToReplace = osmIter;
            }
           lastItemOrden = osmIter.getOrden();
        }
        if(lastItemOrden<posicionOpcionSubmenu){
            return;
        }
        opcionSubmenuToReplace.setOrden(osm.getOrden());
        osm.setOrden(posicionOpcionSubmenu);
        osmRepo.save(osm);
        osmRepo.save(opcionSubmenuToReplace);
    }
    
    @Transactional
    public void eliminarOpcionSubmenu(Integer opcionSubmenu){
        OpcionSubMenu osm = osmRepo.findById(opcionSubmenu).get();
        List<OpcionSubMenu> submenus = osmRepo.findBySubmenuOrderByOrden(osm.getSubmenu());
        List<OpcionSubMenu> submenusSave = new ArrayList();
        for(OpcionSubMenu osmItr : submenus){
            if(osmItr.getOrden()>osm.getOrden()){
                osmItr.setOrden(osmItr.getOrden()-1);
                submenusSave.add(osmItr);
            }
        }
        osmRepo.saveAll(submenusSave);
        osmRepo.delete(osm);
    }

    public Page<OpcionSubMenu> findBySubmenu(Submenu submenu, int page, String searchword) {
        return osmRepo.findAllBySubmenuOrderByOrden(submenu, PageRequest.of(page, PAGE_SIZE));
    }
    
}
