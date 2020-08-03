/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.DepartamentoService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.*;
import com.fuimonosapp.util.PagingAndSorting;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP PC
 */

@Controller
public class DepartamentoController {

    private final DepartamentoService departmentService;

    public DepartamentoController(DepartamentoService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/departamento/porPais")
    public ModelAndView verDepartamentoPorPais(@RequestParam("paisId")
                                               Integer paisId,
                                               HttpServletRequest request,
                                               HttpServletResponse response ) throws IOException {

        if(SessionUtils.assertLogin(request)){
               Page<Departamento> departamentos =  departmentService.buscarDepartPorPais(paisId, request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0);
               
               ModelAndView mv = new ModelAndView("departamento/ver-departamento");
               mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(departamentos, request, (String) request.getSession().getAttribute("searchWord"), null,
                       "departamento/porPais"));
               mv.addObject("departamentos", departamentos.getContent());
               return mv;
            }
        else{
            
            response.sendRedirect(request.getContextPath()+"/");
        }
        
        return null;
    }
    
}
