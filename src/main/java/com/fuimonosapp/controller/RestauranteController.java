/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.repository.RestauranteRepository;
import com.fuimonosapp.service.RestauranteService;
import com.fuimonosapp.util.PagingAndSorting;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public class RestauranteController {
    
    @Autowired
    RestauranteService restaService;
    
    
    Logger logger = Logger.getLogger("restaurante");
    
    @GetMapping("/restaurantes")
    public ModelAndView restaurantesList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        ModelAndView mav=new ModelAndView();
        HttpSession session = request.getSession();

       Page<Restaurante> restaurantes = restaService.findBySearchWord(session.getAttribute("page")!=null?(Integer)session.getAttribute("page"):0,
               (String)session.getAttribute("searchWord"));
       mav.addObject("restaurantes",restaurantes.getContent());
       mav.addAllObjects(PagingAndSorting.generalPagingAndSorting(restaurantes, request, (String)session.getAttribute("searchWord"), null));
       mav.setViewName("restaurante/restaurante");
       return mav;
        
      
    }
    	@PostMapping("/saveRestaurante")
	public ModelAndView saveRestaurante(@ModelAttribute Restaurante restaurante) {
		ModelAndView mav = new ModelAndView();

                
		

			restaService.save(restaurante);
			List<Restaurante> restaurantes =null;
			
			mav.addObject("restaurante",restaurantes);
			mav.setViewName("restaurante");
		
		return mav;
	}
        /*
        //Borrar
        @RequestMapping(value="/busqueda", params="action=borrar")
	public ModelAndView delete(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Restaurante> restaurantes = null;
		
		try {
			restaService.delete(id);
			restaurantes = restaService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("restaurantes", restaurantes);
		mav.setViewName("restaurante");
		
		return mav;
	}
        
        //actualizar
        @RequestMapping(value="/busqueda", params="action=actualizar")
	public ModelAndView update(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Restaurante restaurante = restaService.findOne(id);
		mav.addObject("restaurante", restaurante);
		mav.setViewName("actualizarResta");
		
		return mav;
	}*/
}
