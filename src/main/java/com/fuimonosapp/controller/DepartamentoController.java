/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.DepartamentoService;
import com.fuimonosapp.service.PaisService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.*;
import com.fuimonosapp.util.PagingAndSorting;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HP PC
 */

@Controller
public class DepartamentoController {

    private final DepartamentoService departmentService;
    private final PaisService paisService;

    @Autowired
    public DepartamentoController(DepartamentoService departmentService,
                                  PaisService paisService) {
        this.departmentService = departmentService;
        this.paisService = paisService;
    }

    @RequestMapping("/departamento/porPais")
    public ModelAndView verDepartamentoPorPais(@RequestParam("paisId")
                                               Integer paisId,
                                               HttpServletRequest request,
                                               HttpServletResponse response) throws IOException {

        if (!SessionUtils.isValidSession(request, response)) {
            return null;
        }

        Pais pais = paisService.findOne(paisId);

        Page<Departamento> departamentos = departmentService.buscarDepartPorPais(paisId, request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0);

        ModelAndView mv = new ModelAndView("departamento/ver-departamento");
        mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(departamentos, request, (String) request.getSession().getAttribute("searchWord"), null,
                "departamento/porPais"));
        mv.addObject("departamentos", departamentos.getContent());
        mv.addObject("pais", pais);
        return mv;

    }

}
