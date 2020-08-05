/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.AdministradorService;
import com.fuimonosapp.util.SessionUtils;
import java.io.IOException;
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
public class AdministradorController {
    
    @Autowired
    AdministradorService as;
    
    @RequestMapping("/administrador")
    public ModelAndView administrador(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
            return null;
        }
        
        return new ModelAndView("administrador/añadir-administrador");
    }
    
}
