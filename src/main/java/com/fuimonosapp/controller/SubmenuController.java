/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.PlatilloService;
import com.fuimonosapp.service.SubmenuService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP PC
 */
@RequestMapping("/submenu")
public class SubmenuController {

    @Autowired
    SubmenuService smService;

    @Autowired
    PlatilloService pService;

    @GetMapping("/")
    public ModelAndView verSubmenu(@RequestParam("id") Integer submenuId) {
        return new ModelAndView("");
    }

    @GetMapping("/crear")
    public ModelAndView creatSubmenu(@RequestParam("platilloId") Integer platilloId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtils.assertLogin(request)) {
            ModelAndView mv = new ModelAndView("submenu/agregar-submenu");

            try {
                mv.addObject("platillo", pService.findOne(platilloId));
            } catch (Exception e) {
                response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
                return null;
            }
            return mv;
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;

    }
    
    @PostMapping("/crear")
    public void creatSubmenu(@RequestParam("submenuId") Integer submenuId, @RequestParam("menuCobrado") Boolean menuCobrado,
            @RequestParam("cobrarapartirde") Integer cobrarApartiDe, @RequestParam("minimodeopcionesaescoger") Integer minOpcAEscoger,
            @RequestParam("maxOpcAEscog") Integer maxOpcAEsxoger, @RequestParam("titulo") String titulo,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (SessionUtils.assertLogin(request)) {
            Submenu submenu = new Submenu();
            submenu.setMenucobrado(menuCobrado);
            submenu.setCobrarapartirde(cobrarApartiDe);
            submenu.setMaximoopcionesaescoger(maxOpcAEsxoger);
            submenu.setMinimoopcionesaescoger(minOpcAEscoger);
            submenu.setTitulo(titulo);
            smService.save(submenu);
        }
         else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        
    }

}
