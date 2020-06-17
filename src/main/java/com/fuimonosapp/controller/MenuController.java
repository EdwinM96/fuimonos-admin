/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.service.MenuService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Javier
 */
@Controller
public class MenuController {
      @Autowired
      MenuService menuService;
      
       Logger logger = Logger.getLogger("restaurante");
    
    @GetMapping("/menuss")
    public ModelAndView findAllMenus() {
        ModelAndView mav=new ModelAndView();

       List<Menu> menus = menuService.findAll();
       logger.info("Menus list size " + menus.size());
       mav.addObject("menus",menus);
       mav.setViewName("menu");
       return mav;
        
      
    }
    	@PostMapping("/saveMenu")
	public ModelAndView saveMenu(@ModelAttribute Menu menu) {
		ModelAndView mav = new ModelAndView();

                
		

			menuService.save(menu);
			List<Menu> menus =null;
			
			mav.addObject("menu",menus);
			mav.setViewName("menu");
		
		return mav;
	}
        
        //Borrar
        @RequestMapping(value="/busqueda", params="action=borrar")
	public ModelAndView delete(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Menu> menus = null;
		
		try {
			menuService.delete(id);
			menus = menuService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("menus", menus);
		mav.setViewName("menu");
		
		return mav;
	}
        
        //actualizar
        @RequestMapping(value="/busqueda", params="action=actualizar")
	public ModelAndView update(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Menu menus = menuService.findOne(id);
		mav.addObject("menus", menus);
		mav.setViewName("actualizarMenu");
		
		return mav;
	}
}

