/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.repository.RestauranteRepository;
import com.fuimonosapp.service.RestauranteService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Javier
 */
@Controller
public class RestauranteController {
    
    @Autowired
    RestauranteService restaService;
    
    Logger logger = Logger.getLogger("restaurante");
    
    @GetMapping("/restaurantes")
    public ModelAndView findAllRes() {
        ModelAndView mav=new ModelAndView();

       List<Restaurante> restaurantes = restaService.findAll();
       logger.info("Restaurantes list size " + restaurantes.size());
       mav.addObject("restaurantes",restaurantes);
       mav.setViewName("restaurante");
       return mav;
        
      
    }
    	@PostMapping("/saveRestaurante")
	public ModelAndView saveRestaurante(@ModelAttribute Restaurante restaurante) {
		ModelAndView mav = new ModelAndView();

                
			mav.setViewName("ingresarRestaurante");

			restaService.save(restaurante);
			List<Restaurante> restaurantes =null;
			
			mav.addObject("restaurante",restaurantes);
			mav.setViewName("index");
		
		return mav;
	}
}
