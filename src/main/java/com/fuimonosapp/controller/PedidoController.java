/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.PedidoService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.*;
import com.fuimonosapp.service.DriverService;
import com.fuimonosapp.util.PagingAndSorting;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP PC
 */
@Controller
public class PedidoController {
    
    @Autowired
    PedidoService ps;
    
    @Autowired
    DriverService ds;
    
    @GetMapping("/pedidos")
    public ModelAndView pedidos(@RequestParam(name = "page", defaultValue = "0")Integer page,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
        }
        
        ModelAndView mv = new ModelAndView("pedido/pedidos");
        Page<Pedido> pedidos = ps.findAll(page);
        mv.addObject("pedidos", pedidos.getContent());
        mv.addObject("drivers", ds.findAll());
        mv.addObject("pedidoActualizado", request.getParameter("pedidoActualizado"));
        mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(pedidos, request, null, null, "pedidos"));
        return mv;
    }
    
    @PostMapping("/pedido/actualizar")
    public void actualizarPedido(@RequestParam("id") Integer pedidoId,
            @RequestParam(name = "tiempoExtra", required = false) Integer tiempoExtra,
            @RequestParam(name = "driverAsignadoId", required = false) Integer driverAsignado,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
        }
        Pedido pedido = ps.findOne(pedidoId);
        if(tiempoExtra != null){
            if(pedido.getTiempoExtra()==null){ pedido.setTiempoExtra(LocalTime.MIN);}
            pedido.setTiempoExtra(pedido.getTiempoExtra().plusMinutes(tiempoExtra));
        }
        if(driverAsignado!=null){
            Driver driver = ds.findById(driverAsignado);
            pedido.setDriver_asignado(driver);
        }
        ps.update(pedido);
        response.sendRedirect(request.getContextPath() + "/pedidos?pedidoActualizado=true");
    }
    
}
