/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.domain.Categoria;
import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.domain.Platillo;
import com.fuimonosapp.domain.MenuXCategoria;
import com.fuimonosapp.service.CategoriaService;
import com.fuimonosapp.service.MenuService;
import com.fuimonosapp.service.MenuXCategoriaService;
import com.fuimonosapp.service.PlatilloService;
import com.fuimonosapp.service.RestauranteService;
import com.fuimonosapp.util.PagingAndSorting;
import com.fuimonosapp.util.SessionUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    
    @Autowired
    RestauranteService restaService;
    
    @Autowired
    CategoriaService cateService;        
    
    @Autowired
    MenuXCategoriaService mxcService;
    
    @Autowired
    PlatilloService platService;
    
    

    Logger l = Logger.getLogger("menu");

    @GetMapping("/menu/crear")
    public ModelAndView agregarMenu(@RequestParam("restauranteId")Integer restauranteId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            ModelAndView mv = new ModelAndView("/menus/agregar-menu");
            mv.addObject("categorias",cateService.getAllCategorias() );
            mv.addObject("restaurante",restaService.findOne(restauranteId));
            return mv;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }
    
    @PostMapping("/menu/crear")
    public void anadirMenu(@RequestParam("restauranteId")Integer restauranteId, @RequestParam("categoriaId") Integer categoriaId,
            @RequestParam("nombre") String nombre,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Categoria cate = cateService.findOne(categoriaId);
            Menu menu = new Menu();
            Restaurante restaurante = new Restaurante();
            restaurante.setRestauranteId(restauranteId);
            menu.setRestaurante(restaurante);
            menu.setNombreMenu(nombre);
            menu = menuService.save(menu);
            MenuXCategoria mxc = new MenuXCategoria();
            mxc.setMenu_id(menu);
            mxc.setCategoria_id(cate);
            mxcService.save(mxc);
           response.sendRedirect(request.getContextPath() + "/restaurante?id="+restauranteId+"&creation=true"); 
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/menu/delete")
    public void eliminarMenu(@RequestParam("id")Integer menuId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer restauranteId = 0;
            try{
            restauranteId = menuService.findOne(menuId).getRestaurante().getRestauranteId();
            }
            catch(Exception e){
                response.sendRedirect(request.getContextPath() + "/dashboard");
            }
            menuService.delete(menuId);           
            response.sendRedirect(request.getContextPath() + "/restaurante?id="+restauranteId+"&delete=true");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/menu/top")
    public void posicionarMenuArriba(@RequestParam("id")Integer menuId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer restauranteId = 0;
            try{
             restauranteId = menuService.findOne(menuId).getRestaurante().getRestauranteId();
             menuService.posicionarMenuArriba(menuId);
            }
            catch(Exception e){
                l.info(e.getMessage());
                response.sendRedirect(request.getContextPath() + "/restaurantes");
            }
            
            response.sendRedirect(request.getContextPath() + "/restaurante?id="+restauranteId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/menu/bot")
    public void posicionarMenuAbajo(@RequestParam("id")Integer menuId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Integer restauranteId = 0;
            try{
             restauranteId = menuService.findOne(menuId).getRestaurante().getRestauranteId();
             menuService.posicionarMenuAbajo(menuId);
            }
            catch(Exception e){
                l.info(e.getMessage());
                response.sendRedirect(request.getContextPath() + "/restaurantes");
            }
            
            response.sendRedirect(request.getContextPath() + "/restaurante?id="+restauranteId);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
    
    @GetMapping("/menu")
    public ModelAndView verMenu(@RequestParam("id")Integer menuId, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(SessionUtils.assertLogin(request)){
            Menu menu = new Menu();
            try{
                menu = menuService.findOne(menuId);
            }
            catch(Exception e){
                response.sendRedirect(request.getContextPath() + "/restaurantes");
                return null;
            }       
            HttpSession session = request.getSession();
            ModelAndView mv = new ModelAndView("menus/ver-menu");
            Page<Platillo> platillos = platService.findAllByMenu(menuId, request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0, 
                    request.getParameter("searchWord"));
            mv.addObject("menu", menu);
            mv.addObject("platillos",platillos.getContent() );
            mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(platillos, request, (String) session.getAttribute("searchWord"), null, "menu"));
            return mv;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
        
        return null;
    }
}
