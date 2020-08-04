package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Pais;
import com.fuimonosapp.service.PaisService;
import com.fuimonosapp.util.PagingAndSorting;
import com.fuimonosapp.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @RequestMapping(value= "/pais/paises")
    public ModelAndView verPaises(@RequestParam(value = "page", defaultValue = "0")
                                  Integer page,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws UnsupportedEncodingException {

        if(!SessionUtils.isValidSession(request, response)) {
            return null;
        }

        Pais pais = new Pais();
        Page<Pais> paisesPage = paisService.findAllbyPage(page);

        ModelAndView mv = new ModelAndView("pais/paises");

        mv.addObject("paisModel", pais);
        mv.addObject("paises", paisesPage.getContent());
        mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(paisesPage, request, null, null, "paises"));

        return mv;

    }

    @RequestMapping(value= "/pais/paises", method = RequestMethod.POST)
    public void agregarPais(@ModelAttribute("paisModel")
                            Pais paisModel,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        paisService.save(paisModel);

        response.sendRedirect(request.getContextPath() + "/pais/paises");

    }

    @RequestMapping(value = "pais/delete")
    public String eliminarPais(@RequestParam(value = "paisId")
                               Integer paisId) {

        paisService.delete(paisId);
        return "redirect:/pais/paises";

    }

}
