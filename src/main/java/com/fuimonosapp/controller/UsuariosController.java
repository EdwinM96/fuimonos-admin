/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller;

import com.fuimonosapp.service.UsuarioService;
import com.fuimonosapp.util.SessionUtils;
import com.fuimonosapp.domain.*;
import com.fuimonosapp.util.PagingAndSorting;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;

/**
 *
 * @author HP PC
 */

@Controller
public class UsuariosController {
    
    @Autowired
    UsuarioService us;
    
    @GetMapping("/usuarios")
    public ModelAndView findUsers(@RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "searchWord",required=false ) String searchWord,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
            return null;
        }
        
        
        
        ModelAndView mv = new ModelAndView("usuario/usuarios");
        Page<Usuario> usuarios = us.findUsuarios(page);
        if(searchWord!=null){
            if(searchWord!=""){
                usuarios = us.findUsuarioBySearchWord(page,searchWord);
                mv.addObject("usuarioFilter", searchWord);
            }
        }
        mv.addObject("usuarios", usuarios.getContent());
        mv.addObject("usuarioActualizado", request.getParameter("usuarioActualizado"));
        mv.addAllObjects(PagingAndSorting.generalPagingAndSorting(usuarios, request, searchWord, null, "usuarios"));
        
        return mv;
    } 
    
    @GetMapping("/usuario/cambiarEstatus")
    public void cambiarEstatus(@RequestParam("id")Integer idUsuario,
            HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(!SessionUtils.assertLogin(request)){
            response.sendRedirect(request.getContextPath() + "/");
        }
        Usuario usuario = us.findById(idUsuario);
        usuario.setHabilitado(!usuario.getHabilitado());
        us.updateUsuario(usuario);
        response.sendRedirect(request.getContextPath() + "/usuarios?usuarioActualizado=true");
    }
    
}
