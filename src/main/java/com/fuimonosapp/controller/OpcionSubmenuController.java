/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.OpcionSubmenuService;
import com.fuimonosapp.service.SubmenuService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP PC
 */

@Controller
@RequestMapping("/opcionSubMenu")
public class OpcionSubmenuController {
    
    @Autowired
    OpcionSubmenuService osms;
    
    @Autowired
    SubmenuService sms;
    
    @GetMapping("/crear")
    public ModelAndView agregarOpcionSubmenu(@RequestParam("submenuId") Integer submenuId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            ModelAndView mv = new ModelAndView("opcionsubmenu/agregar-opcionsubmenu");
            Submenu submenu = new Submenu();
            try{
                submenu = sms.findOne(submenuId);
                mv.addObject(submenu);
            }
            catch(Exception e){
                response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
               return null;
            }
            return mv;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }
    
    @PostMapping("/crear")
    public void crearOpcionSubmenu(@RequestParam("nombre") String nombre, @RequestParam("submenuId") Integer submenuId,
            @RequestParam("precio") Double precio, @RequestParam(name = "seleccionadopordefecto",  defaultValue = "false") Boolean seleccionadoPorDefecto,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Submenu sm = new Submenu();
            try{
                sm = sms.findOne(submenuId);
            }
            catch(Exception e){
                   response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            OpcionSubMenu osm = new OpcionSubMenu();
            osm.setNombre(nombre);
            osm.setPrecio(precio);
            osm.setSeleccionadoPorDefecto(seleccionadoPorDefecto);
            osm.setSubmenu(sm);
            osms.save(osm);
            response.sendRedirect(request.getContextPath() + "/submenu?id="+submenuId+"&created=true");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("")
    public ModelAndView verOpcionSubmenu(@RequestParam("id") Integer opcionSubmenuId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            OpcionSubMenu osm = new OpcionSubMenu();
            try{
                osm = osms.findOne(opcionSubmenuId);
            }
            catch(Exception e){
                   response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            
            ModelAndView mv = new ModelAndView("/opcionsubmenu/ver-opcionsubmenu");
            mv.addObject("opcionSubmenu", osm);
            return mv;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }
    
    
}
