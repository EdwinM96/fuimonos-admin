package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Departamento;
import com.fuimonosapp.domain.Municipio;
import com.fuimonosapp.domain.Pais;
import com.fuimonosapp.service.DepartamentoService;
import com.fuimonosapp.service.MunicipiosService;
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
@RequestMapping("/municipios")
public class MunicipioController {

    private final DepartamentoService departamentoService;
    private final MunicipiosService municipiosService;

    @Autowired
    public MunicipioController(DepartamentoService departamentoService,
                               MunicipiosService municipiosService) {
        this.departamentoService = departamentoService;
        this.municipiosService = municipiosService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView verMunicipios(@RequestParam("departamentoId")
                                      Integer departamentoId,
                                      @RequestParam(value = "page", defaultValue = "0")
                                      Integer page,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws UnsupportedEncodingException {

        if (!SessionUtils.isValidSession(request, response)) {
            return null;
        }

        Departamento departamento = departamentoService.findOne(departamentoId);
        Municipio newMunicipio = new Municipio();

        Page<Municipio> municipiosPage = municipiosService.obtenerMunicipiosPor(departamentoId, page);

        ModelAndView mv = new ModelAndView("municipio/municipios");

        mv.addObject("municipios", municipiosPage.getContent());
        mv.addObject("departamento", departamento);
        mv.addObject("municipioNewModel", newMunicipio);
        mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(municipiosPage, request, null, null, "municipios?departamentoId=" + departamentoId));

        return mv;

    }

    @RequestMapping(value= "/pais/paises", method = RequestMethod.POST)
    public void agregarMunicipio(@RequestParam("departamentoId")
                                 Integer departamentoId,
                                 @ModelAttribute("municipioNewModel")
                                 Municipio municipioNewModel,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {

        Departamento departamento = departamentoService.findOne(departamentoId);
        municipioNewModel.setDepartamento_id(departamento);
        municipiosService.save(municipioNewModel);

        response.sendRedirect(request.getContextPath() + "/municipios?departamentoId=" + departamentoId);

    }

    @RequestMapping(value = "/delete")
    public String eliminarMunicipio(@RequestParam("departamentoId")
                                    Integer departamentoId,
                                    @RequestParam("municipioId")
                                    Integer municipioId) {

        municipiosService.delete(municipioId);
        return "redirect:/municipios?departamentoId=" + departamentoId;

    }

}
