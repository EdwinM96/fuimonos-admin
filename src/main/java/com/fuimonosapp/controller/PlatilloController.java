/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.MenuService;
import com.fuimonosapp.service.PlatilloService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.Platillo;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.domain.Submenu;
import com.fuimonosapp.service.SubmenuService;
import com.fuimonosapp.util.PagingAndSorting;
import javax.servlet.annotation.MultipartConfig;
import org.jboss.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP PC
 */
@MultipartConfig
@Controller
public class PlatilloController {
    
    @Autowired
    PlatilloService platService;
    
    @Autowired
    MenuService menuService;
    
    @Autowired
    SubmenuService smService;
    
    Logger l = Logger.getLogger("platillo");
    
    
    @GetMapping("/platillo/crear")
    public ModelAndView agregarPlatilloView(@RequestParam("menuId")Integer menuId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            ModelAndView mv = new ModelAndView("/platillo/agregar-platillo");
            Menu menu = new Menu();
            try{
                menu = menuService.findOne(menuId);
                mv.addObject("menu",menu );
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
    
    @PostMapping("/platillo/crear")
    public void agregarPlatilloPost(@RequestParam("imagen") MultipartFile imagen,@RequestParam("nombre") String nombre,
            @RequestParam("precioBase") Double precioBase, @RequestParam("menuId")Integer menuId,
            @RequestParam("descripcion") String descripcion,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Menu menu = new Menu();
            menu.setMenuId(menuId);
            try{
                menu = menuService.findOne(menuId);
            }
            catch(Exception e){
               response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            Platillo platillo = new Platillo();
            Byte[] imageBytes = new Byte[imagen.getBytes().length];
            for (int i = 0; i < imagen.getBytes().length; i++)
            {
                imageBytes[i] = imagen.getBytes()[i];
            }
            platillo.setImagen(imageBytes);
            platillo.setNombre(nombre);
            platillo.setMenu(menu);
            platillo.setPrecioBase(precioBase);
            platillo.setDescripcion(descripcion);
            platService.save(platillo);
            response.sendRedirect(request.getContextPath() + "/menu?creation=true&id="+menuId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/platillo")
    public ModelAndView verPlatillo(@RequestParam("id")Integer platilloId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            ModelAndView mv = new ModelAndView("/platillo/ver-platillo");
            Platillo platillo = new Platillo();
            try{
                platillo = platService.findOne(platilloId);
                mv.addObject("platillo",platillo );
            }
            catch(Exception e){
               response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
               return null;
            }
            Page<Submenu> submenus = smService.findAllByPlatillo(platilloId, request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0, 
                    request.getParameter("searchWord"));
            mv.addObject("submenus", submenus.getContent());
            mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(submenus, request, (String) request.getSession().getAttribute("searchWord"), null, "menu"));
            mv.addObject("deleted",request.getParameter("deleted"));
            return mv;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }
    
    @GetMapping("/platillo/delete")
    public void eliminarPlatillo(@RequestParam("id")Integer platilloId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer menuId = 0; 
            try{
                Platillo platillo = platService.findOne(platilloId);
                menuId = platillo.getMenu().getMenuId();
                platService.eliminarPlatillo(platilloId);
            }
            catch(Exception e){
               response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
            }
            response.sendRedirect(request.getContextPath() + "/menu?delete=true&id="+menuId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/platillo/top")
    public void posicionarPlatilloArriba(@RequestParam("id")Integer platilloId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer menuId = 0;
            try{
             menuId = platService.findOne(platilloId).getMenu().getMenuId();
             platService.posicionarPlatilloArriba(platilloId);
            }
            catch(Exception e){
                l.info(e.getMessage());
                response.sendRedirect(request.getContextPath() + "/restaurantes");
            }
            
            response.sendRedirect(request.getContextPath() + "/menu?id="+menuId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/platillo/bot")
    public void posicionarMenuAbajo(@RequestParam("id")Integer platilloId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer menuId = 0;
            try{
             menuId = platService.findOne(platilloId).getMenu().getMenuId();
             platService.posicionarPlatilloAbajo(platilloId);
            }
            catch(Exception e){
                l.info(e.getMessage());
                response.sendRedirect(request.getContextPath() + "/restaurantes");
            }
            
            response.sendRedirect(request.getContextPath() + "/menu?id="+menuId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    
}
