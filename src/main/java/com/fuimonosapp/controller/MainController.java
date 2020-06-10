/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.repository.RestauranteRepository;
import com.fuimonosapp.service.RestauranteService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP PC
 */

@Controller
public class MainController {
    
    @Autowired
    RestauranteService restaService;
    
    @RequestMapping(value="/main")
    public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response){
        System.out.println();
        restaService.findAll();
        System.out.println("Entered homepage");
        return new ModelAndView("index");
    }
    
}
