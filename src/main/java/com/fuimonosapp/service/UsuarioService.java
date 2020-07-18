/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.UsuarioRepository;
import com.fuimonosapp.domain.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP PC
 */

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository uRepo;
    
    public Usuario saveUsuario(Usuario usuario){
        usuario.setFechaCreacion(new Date());
        return uRepo.saveAndFlush(usuario);
    }
    
    public boolean usernameIsAvailable(String username){
        return uRepo.findOneByUsername(username) == null;
    }
    
    public boolean emailIsAvailable(String email){
        return uRepo.findOneByEmail(email) == null;
    }
    
}
