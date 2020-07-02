/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.repository.MenuRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Javier
 */
@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    
    @Autowired
    RestauranteService restaService;
    
    Integer PAGESIZE = 10;
    
    Logger l = Logger.getLogger("menuServ");
    
    @Transactional
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
    
    @Transactional
    public Page<Menu> findAllByRestaurante(Integer restauranteId, Integer currentPage, String searchWord) {
        Restaurante restaurante = new Restaurante();
        restaurante.setRestauranteId(restauranteId);
        
        
        return menuRepository.findByRestauranteOrderByOrden(restaurante, PageRequest.of(currentPage, PAGESIZE));
        
    }
    
    
    @Transactional
    public Menu save(Menu menu) throws DataAccessException {
        Restaurante restaurante = restaService.findOne(menu.getRestaurante().getRestauranteId());  
        List<Menu> menus = menuRepository.findByRestauranteOrderByOrden(restaurante);
        Integer index = 1;
        for(Menu menuIter : menus){
           index++; 
        }
        menu.setOrden(index);
        menu.setRestaurante(restaurante);
        return menuRepository.saveAndFlush(menu);
    }
    @Transactional
    public Menu findOne(Integer code) throws DataAccessException {
        return menuRepository.getOne(code);
    }
    
    @Transactional
    public void delete(Integer menuId) throws DataAccessException {
        Menu menu = menuRepository.getOne(menuId);
        List<Menu> menus = menuRepository.findByRestauranteOrderByOrden(restaService.findOne(menu.getRestaurante().getRestauranteId()));
        List<Menu> menusSave = new ArrayList();
        for(Menu menuIter: menus){
            if(menuIter.getOrden()>menu.getOrden()){
                menuIter.setOrden(menuIter.getOrden()-1);
                menusSave.add(menuIter);
            }
        }
        
        menuRepository.deleteById(menuId);
        l.info(menusSave.toString());
        if(!menusSave.isEmpty()){
            menuRepository.saveAll(menusSave);
        }

    }
    
    @Transactional
    public void posicionarMenuArriba(Integer menuId){
        Menu menu = menuRepository.getOne(menuId);
        List<Menu> menus = menuRepository.findByRestauranteOrderByOrden(restaService.findOne(menu.getRestaurante().getRestauranteId()));
        Integer posicionMenu = menu.getOrden() - 1;
        if(posicionMenu == 0){return;}
        Menu menuOrderToReplace = new Menu();
        for(Menu menuIter: menus){
            if(menuIter.getOrden().equals(posicionMenu)){
                menuOrderToReplace = menuIter;
            }
        }
        menuOrderToReplace.setOrden(menu.getOrden());
        menu.setOrden(posicionMenu);
       menuRepository.save(menuOrderToReplace);
       menuRepository.save(menu);
    }
    
    @Transactional
    public void posicionarMenuAbajo(Integer menuId){
        Menu menu = menuRepository.getOne(menuId);
        List<Menu> menus = menuRepository.findByRestauranteOrderByOrden(restaService.findOne(menu.getRestaurante().getRestauranteId()));
        Integer posicionMenu = menu.getOrden() + 1;
        if(posicionMenu == 0){return;}
        Menu menuOrderToReplace = new Menu();
        Integer lastOrden = 1;
        for(Menu menuIter: menus){
            if(menuIter.getOrden().equals(posicionMenu)){
                menuOrderToReplace = menuIter;
            }
           lastOrden = menuIter.getOrden();
        }
        if(lastOrden<posicionMenu){
            return;
        }
        menuOrderToReplace.setOrden(menu.getOrden());
        menu.setOrden(posicionMenu);
       menuRepository.save(menuOrderToReplace);
       menuRepository.save(menu);
    }
}
