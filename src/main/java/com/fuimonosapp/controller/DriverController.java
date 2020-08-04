/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.domain.*;
import com.fuimonosapp.service.DriverService;
import com.fuimonosapp.util.PagingAndSorting;
import com.fuimonosapp.util.SessionUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP PC
 */

@Controller
public class DriverController {
    
    @Autowired
    DriverService ds;
    
    @RequestMapping("/drivers")
    public ModelAndView drivers(@RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "searchWord", required = false) String searchWord,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
            return null;
        }
        Page<Driver> drivers;
        if(searchWord!=null){ drivers = ds.findAllWithSearchWord(page, searchWord);}
        else{ drivers = ds.findAll(page);}
        ModelAndView mv = new ModelAndView("drivers/drivers");
        mv.addObject("drivers", drivers.getContent());
        mv.addObject("driverCreado", request.getParameter("created"));
        mv.addObject("driverActualizado", request.getParameter("updated"));
        mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(drivers, request, searchWord, null, "/drivers"));
        
        return mv;
    }
    
    @GetMapping("/driver/crear")
    public ModelAndView agregarDriver(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
            return null;
        }
        return new ModelAndView("drivers/agregar-driver");
    }
    
    @PostMapping("/driver/crear")
    public void guardarDriver( @RequestParam("nombre") String nombre,
            @RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
        }
        
        Driver driver = new Driver();
        driver.setNombreDriver(nombre);
        driver.setUsername(username);
        driver.setPass(password);
        ds.save(driver);
        response.sendRedirect(request.getContextPath() + "/drivers?created=true");
    }
    
    @GetMapping("/driver")
    public ModelAndView verDriver(@RequestParam("id") Integer driverId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
            return null;
        }
        Driver driver = new Driver();
        try{
            driver = ds.findById(driverId);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
        }
        
        ModelAndView mv = new ModelAndView("drivers/ver-driver");
        mv.addObject(driver);
        return mv;
    }
    
    @PostMapping("driver/editar")
    public void editarDriverGuardar( @RequestParam("driverId")Integer driverId, @RequestParam("nombre") String nombre, 
            @RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
        }
        Driver driver = new Driver();
        try{
            driver = ds.findById(driverId);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
        }
        driver.setNombreDriver(nombre);
        driver.setUsername(username);
        driver.setPass(password);
        ds.update(driver);
        response.sendRedirect(request.getContextPath() + "/drivers?updated=true");
    }
    
    @GetMapping("driver/editar")
    public ModelAndView editarDriver(@RequestParam("id") Integer driverId,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
        }
        Driver driver = new Driver();
        try{
            driver = ds.findById(driverId);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/dashboard?entityNotFound=true");
        }
        ModelAndView mv = new ModelAndView("drivers/editar-driver");
        mv.addObject(driver);
        return mv;
    }
}
