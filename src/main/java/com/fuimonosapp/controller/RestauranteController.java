/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Departamento;
import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.repository.RestauranteRepository;
import com.fuimonosapp.service.DepartamentoService;
import com.fuimonosapp.service.RestauranteService;
import com.fuimonosapp.util.PagingAndSorting;
import com.fuimonosapp.util.SessionUtils;
import java.util.*; 
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.apache.tomcat.util.digester.SetPropertiesRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Javier
 */
@Controller
public class RestauranteController {

    @Autowired
    RestauranteService restaService;

    @Autowired
    DepartamentoService depaService;

    Logger l = Logger.getLogger("restaurante");

    @GetMapping("/restaurantes")
    public ModelAndView restaurantesList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        if (SessionUtils.assertLogin(request)) {
            ModelAndView mav = new ModelAndView();
            HttpSession session = request.getSession();
            l.info(request.getParameter("page"));
            Page<Restaurante> restaurantes = restaService.findBySearchWord(request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0,
                    request.getParameter("searchWord"));

            mav.addObject("restaurantes", restaurantes.getContent());
            mav.addAllObjects(PagingAndSorting.generalPagingAndSorting(restaurantes, request, (String) session.getAttribute("searchWord"), null, "restaurantes"));
            mav.setViewName("restaurante/restaurante");
            return mav;
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;

    }

    @GetMapping(path = "restaurante/crear")
    public ModelAndView saveRestaurante( HttpServletRequest request, HttpServletResponse response
           ) throws IOException {
        if (SessionUtils.assertLogin(request)) {
            ModelAndView mav = new ModelAndView("restaurante/agregar-restaurante");

            List<Departamento> departamentos = depaService.findAll();

            mav.addObject("departamentos", departamentos);
            if(request.getParameter("success")!=null){ if(Boolean.parseBoolean(request.getParameter("success"))){ mav.addObject("creatingAccountSuccess", true);}}
            return mav;
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }
    
    @PostMapping(path = "restaurante/crear",headers=("content-type=multipart/*"))
    public void saveRestaurantePOST(/*@RequestParam("username") String usuario, @RequestParam("nombre") String nombre,
            @RequestParam("horario_de_apertura")String horarioDeApertura, @RequestParam("horario_de_cierre")String horarioDeCierre,
            @RequestParam("tiempo_estimado_de_entrega") String tiempoEstimadoDeEntrega, @RequestParam("imagen_de_portada") MultipartFile imagen,
            @RequestParam(value = "representante", required=false)String representante, @RequestParam(value = "numero_de_contacto", required=false)String numeroDeContacto,
            @RequestParam("comision")Double comision, @RequestParam(value = "cargosExtra", required=false)Double cargosExtra, 
            @RequestParam("departamento") Integer departamentoId,*/
            HttpServletRequest request, HttpServletResponse response
           ) throws IOException {
        if (SessionUtils.assertLogin(request)) {
            Iterator iterator = request.getParameterMap().keySet().iterator();
            l.info("--------------Variables-------------");
            while(iterator.hasNext()){
                l.info((String)iterator.next());
            }
            /*
            Restaurante restaurante = new Restaurante();
            restaurante.setUsername(usuario);
            restaurante.setNombre(nombre);*/

            //restaService.save(restaurante);
            List<Restaurante> restaurantes = null;
            
            response.sendRedirect(request.getContextPath() + "/restaurante/crear?success=true");

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
    
    /*
        //Borrar
        @RequestMapping(value="/busqueda", params="action=borrar")
	public ModelAndView delete(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Restaurante> restaurantes = null;
		
		try {
			restaService.delete(id);
			restaurantes = restaService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("restaurantes", restaurantes);
		mav.setViewName("restaurantes/restaurante");
		
		return mav;
	}
        
        //actualizar
        @RequestMapping(value="/busqueda", params="action=actualizar")
	public ModelAndView update(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Restaurante restaurante = restaService.findOne(id);
		mav.addObject("restaurante", restaurante);
		mav.setViewName("restaurantes/actualizarResta");
		
		return mav;
	}*/
}
