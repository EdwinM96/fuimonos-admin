/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.domain.Departamento;
import com.fuimonosapp.domain.Restaurante;
import com.fuimonosapp.domain.Menu;
import com.fuimonosapp.repository.RestauranteRepository;
import com.fuimonosapp.service.DepartamentoService;
import com.fuimonosapp.service.MenuService;
import com.fuimonosapp.service.RestauranteService;
import com.fuimonosapp.util.PagingAndSorting;
import com.fuimonosapp.util.SessionUtils;
import java.util.*; 
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
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
@MultipartConfig
@Controller
public class RestauranteController {

    @Autowired
    RestauranteService restaService;

    @Autowired
    DepartamentoService depaService;
    
    @Autowired
    MenuService menuService;
    
    SimpleDateFormat format = new SimpleDateFormat("hh:mm");
    SimpleDateFormat minuteFormat = new SimpleDateFormat("mm:ss");
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
            mav.setViewName("restaurante/restaurantes");
            if(request.getParameter("success")!=null){ if(Boolean.parseBoolean(request.getParameter("success"))){ mav.addObject("creatingAccountSuccess", true);}}
            if(request.getParameter("deleted")!=null){ if(Boolean.parseBoolean(request.getParameter("deleted"))){ mav.addObject("deletingAccountSuccess", true);}}
            return mav;
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;

    }

    @GetMapping(path = "restaurante/crear")
    public ModelAndView agregarRestaurante( HttpServletRequest request, HttpServletResponse response
           ) throws IOException {
        if (SessionUtils.assertLogin(request)) {
            ModelAndView mav = new ModelAndView("restaurante/agregar-restaurante");

            List<Departamento> departamentos = depaService.findAll();

            mav.addObject("departamentos", departamentos);
            
            return mav;
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }
    
    @PostMapping(path = "restaurante/crear")
    public void agregarRestaurantePOST(@RequestParam("username") String usuario, @RequestParam("nombre") String nombre,
            @RequestParam("horario_de_apertura")String horarioDeApertura, @RequestParam("horario_de_cierre")String horarioDeCierre,
            @RequestParam("tiempo_estimado_de_entrega") String tiempoEstimadoDeEntrega, @RequestParam("imagen_de_portada") MultipartFile imagen,
            @RequestParam(value = "representante", required=false)String representante, @RequestParam(value = "numero_de_contacto", required=false)String numeroDeContacto,
            @RequestParam(value = "cargosExtras", required=false)Double cargosExtra, @RequestParam("departamento") Integer departamentoId,
            @RequestParam("comision") Double comision, @RequestParam(value="nit", required=false) String nit, @RequestParam("correo") String correo,
            HttpServletRequest request, HttpServletResponse response
           ) throws IOException, ParseException {
        if (SessionUtils.assertLogin(request)) {
            Departamento departamento = new Departamento();
            departamento.setDepartamento_id(departamentoId);
            Byte[] imageBytes = new Byte[imagen.getBytes().length];
            for (int i = 0; i < imagen.getBytes().length; i++)
            {
                imageBytes[i] = imagen.getBytes()[i];
            }
            Restaurante restaurante = new Restaurante();
            restaurante.setUsername(usuario);
            restaurante.setNombre(nombre);
            restaurante.setHorarioDeApertura(format.parse(horarioDeApertura));
            restaurante.setHorarioDeCierre(format.parse(horarioDeCierre));
            restaurante.setTiempoEstimadoDeEntrega(minuteFormat.parse(tiempoEstimadoDeEntrega));
            restaurante.setImagenDePortada(imageBytes);
            restaurante.setRepresentante(representante);
            restaurante.setNumeroDeContacto(numeroDeContacto);
            restaurante.setCargosExtras(cargosExtra);
            restaurante.setComision(comision);
            restaurante.setDepartamento_id(departamento);

            restaService.save(restaurante);
            List<Restaurante> restaurantes = null;
            
            response.sendRedirect(request.getContextPath() + "/restaurantes?success=true");

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
    
    @GetMapping(path = "restaurante/delete")
    public void eliminarRestaurante(@RequestParam("id")Integer id, HttpServletRequest request, HttpServletResponse response
           ) throws IOException {
        if (SessionUtils.assertLogin(request)) {
            restaService.delete(id);
            response.sendRedirect(request.getContextPath() + "/restaurantes?deleted=true");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    
    }
    
    @GetMapping(path = "restaurante")
    public ModelAndView verRestaurante(@RequestParam("id")Integer id, HttpServletRequest request, HttpServletResponse response
           ) throws IOException {
        if (SessionUtils.assertLogin(request)) {
            ModelAndView mav = new ModelAndView("restaurante/ver-restaurante");
            
             SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
             SimpleDateFormat timeFormatHour = new SimpleDateFormat("hh:mm"); 
             
            Restaurante restaurante = restaService.findOne(id);
            Page<Menu> menus = menuService.findAllByRestaurante(id, request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0,
                    request.getParameter("searchWord"));
            mav.addObject("restaurante", restaurante);
            mav.addObject("horarioDeApertura", timeFormatHour.format(restaurante.getHorarioDeApertura()));
            mav.addObject("horarioDeCierre", timeFormatHour.format(restaurante.getHorarioDeCierre()));
            mav.addObject("tiempoDeEntrega", timeFormat.format(restaurante.getTiempoEstimadoDeEntrega()));
            mav.addObject("menus", menus.getContent());
            mav.addAllObjects(PagingAndSorting.generalPagingAndSorting(menus, request, (String) request.getSession().getAttribute("searchWord"), null, "restaurante"));
            return mav;
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
        return null;
    }
    
}
