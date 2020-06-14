/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.repository.RestauranteRepository;
import com.fuimonosapp.service.AdministradorService;
import com.fuimonosapp.service.RestauranteService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.Administrador;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author HP PC
 */

@Controller
public class MainController {
    
    @Autowired
    AdministradorService adminService;
    
    SessionUtils sesUtils;
    
    
    @RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("index");
		
		return mav;
	}
        
        @RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("login");
		
		return mav;
	}
        
        @RequestMapping("/attempt-login")
        public void attemptLogin(@RequestParam(value="username", required=true) String username,@RequestParam(value="password", required=true) String password,
                HttpServletResponse response, HttpServletRequest request) throws IOException{
            
                Administrador adminFill = new Administrador();
                adminFill.setUsername(username);
                adminFill.setPass(password);
                Administrador adminResponse = adminService.loginAdministrador(adminFill);
                if(adminResponse != null){
                    request.getSession().setAttribute("adminUser", adminResponse);
                    response.sendRedirect(request.getContextPath()+"/dashboard");
                }
                else{
                   response.sendRedirect(request.getContextPath()+"?failedAttempt=true"); 
                }
            
        }
        
        @RequestMapping("/dashboard")
        public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response) throws IOException{
            if(SessionUtils.assertLogin(request)){
                return new ModelAndView("dashboard");
            }
            else{
                response.sendRedirect(request.getContextPath()+"/");
            }
            return null;
        }
        
        @RequestMapping("/logout")
        public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.getSession().removeAttribute("adminUser");
            response.sendRedirect(request.getContextPath()+"/");
        }
}
