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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author HP PC
 */

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

    private final DepartamentoService departmentService;
    private final PaisService paisService;

    @Autowired
    public DepartamentoController(DepartamentoService departmentService,
                                  PaisService paisService) {
        this.departmentService = departmentService;
        this.paisService = paisService;
    }

    @RequestMapping(value = "/porPais", method = RequestMethod.GET)
    public ModelAndView verDepartamentoPorPais(@RequestParam("paisId")
                                                       Integer paisId,
                                               HttpServletRequest request,
                                               HttpServletResponse response) throws IOException {

        if (!SessionUtils.isValidSession(request, response)) {
            return null;
        }

        Pais pais = paisService.findOne(paisId);
        Departamento newDepartamento = new Departamento();
        newDepartamento.setPais_id(paisId);

        Page<Departamento> departamentos = departmentService.buscarDepartPorPais(paisId, request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0);

        ModelAndView mv = new ModelAndView("departamento/ver-departamento");
        mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(departamentos, request, (String) request.getSession().getAttribute("searchWord"), null,
                "departamento/porPais"));
        mv.addObject("departamentos", departamentos.getContent());
        mv.addObject("pais", pais);
        mv.addObject("departamentoModel", newDepartamento);
        return mv;

    }

    @RequestMapping(value = "/porPais", method = RequestMethod.POST)
    public void agregarDepartamento(@RequestParam("paisId")
                                            Integer paisId,
                                    @ModelAttribute("departamentoModel")
                                            Departamento departamentoModel,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {

        departamentoModel.setPais_id(paisId);

        departmentService.save(departamentoModel);

        response.sendRedirect(request.getContextPath() + "/departamento/porPais?paisId=" + paisId);

    }

    @RequestMapping(value = "/delete")
    public String eliminarDepartamento(@RequestParam("paisId")
                                       Integer paisId,
                                       @RequestParam("departamentoId")
                                       Integer departamentoId) {

        departmentService.delete(departamentoId);
        return "redirect:/departamento/porPais?paisId=" + paisId;

    }

}
