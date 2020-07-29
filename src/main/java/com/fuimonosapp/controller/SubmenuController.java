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
import com.fuimonosapp.service.OpcionSubmenuService;
import com.fuimonosapp.util.PagingAndSorting;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/submenu")
public class SubmenuController {

    @Autowired
    SubmenuService smService;

    @Autowired
    PlatilloService pService;
    
    @Autowired
    OpcionSubmenuService osmService;
    
    @GetMapping("")
    public ModelAndView verSubmenu(@RequestParam("id") Integer submenuId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (SessionUtils.assertLogin(request)) {
            ModelAndView mv = new ModelAndView("submenu/ver-submenu");
            Submenu submenu = new Submenu();
            try{
                submenu = smService.findOne(submenuId);
            }
            catch(Exception e){
                 response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            Page<OpcionSubMenu> opciones = osmService.findBySubmenu(submenu,(request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):0),
                    request.getParameter("searchWord"));
            mv.addObject("opcionesSubmenu", opciones.getContent());
            mv.addObject("submenu", submenu);
            mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(opciones, request, (String) request.getParameter("searchWord"), null, "submenu"));
            
            return mv;
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }

    @GetMapping("/crear")
    public ModelAndView crearSubmenu(@RequestParam("platilloId") Integer platilloId, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
    public void crearSubmenu(@RequestParam("platilloId") Integer platilloId, @RequestParam(name = "menucobrado", defaultValue = "false") Boolean menuCobrado,
            @RequestParam("cobrarapartirde") Integer cobrarApartiDe, @RequestParam("minimoopciones") Integer minOpcAEscoger,
            @RequestParam("maximoopciones") Integer maxOpcAEsxoger, @RequestParam("titulo") String titulo,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (SessionUtils.assertLogin(request)) {
            Platillo platillo = new Platillo();
            try {
                platillo = pService.findOne(platilloId);
            } catch (Exception e) {
                response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            Submenu submenu = new Submenu();
            submenu.setMenucobrado(menuCobrado);
            submenu.setCobrarapartirde(cobrarApartiDe);
            submenu.setMaximoopcionesaescoger(maxOpcAEsxoger);
            submenu.setMinimoopcionesaescoger(minOpcAEscoger);
            submenu.setTitulo(titulo);
            submenu.setPlatillo(platillo);
            smService.save(submenu);
            response.sendRedirect(request.getContextPath() + "/platillo?id=" + platilloId);
            
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/delete")
    public void eliminarSubmenu(@RequestParam("id") Integer submenuId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (SessionUtils.assertLogin(request)) {
           Submenu submenu =  smService.findOne(submenuId);
           Integer platilloId = submenu.getPlatillo().getPlatilloId();
           smService.delete(submenuId);
           response.sendRedirect(request.getContextPath() + "/platillo?id=" + platilloId+"&deleted=true");
        }else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/top")
    public void posicionarPlatilloArriba(@RequestParam("id")Integer submenuId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer platilloId = 0;
            try{
             platilloId = smService.findOne(submenuId).getPlatillo().getPlatilloId();
             smService.posicionarSubMenuArriba(submenuId);
            }
            catch(Exception e){
                response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            
            response.sendRedirect(request.getContextPath() + "/platillo?id="+platilloId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/bot")
    public void posicionarPlatilloAbajo(@RequestParam("id")Integer submenuId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer platilloId = 0;
            try{
             platilloId = smService.findOne(submenuId).getPlatillo().getPlatilloId();
             smService.posicionarSubMenuoAbajo(submenuId);
            }
            catch(Exception e){
                response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            
            response.sendRedirect(request.getContextPath() + "/platillo?id="+platilloId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    

}
