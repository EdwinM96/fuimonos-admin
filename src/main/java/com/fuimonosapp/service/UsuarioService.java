/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.repository.UsuarioRepository;
import com.fuimonosapp.domain.*;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP PC
 */

@Service
public class UsuarioService {
    
    Logger l = Logger.getLogger("aaaa");
    
    @Autowired
    UsuarioRepository uRepo;
    
    public Usuario saveUsuario(Usuario usuario){
        usuario.setFechaCreacion(new Date());
        return uRepo.saveAndFlush(usuario);
    }
    
    public Usuario updateUsuario(Usuario usuario){
        return uRepo.saveAndFlush(usuario);
    }
    
    public boolean usernameIsAvailable(String username){
        return uRepo.findOneByUsername(username) == null;
    }
    
    public boolean emailIsAvailable(String email){
        return uRepo.findOneByEmail(email) == null;
    }
    
    public boolean celularIsAvailable(String celular){
        return uRepo.findOneByCelular(celular) == null;
    }

    public Usuario authenticate(String username, String password) {
        l.info("Entre a authenticate de Usuario Service");
        Usuario usuario = uRepo.findByUsername(username);
        return usuario;
    }
    
    public Boolean authentication (String username, String password){
        return !(uRepo.findByUsernameAndPass(username, password)==null);
    }

    public Usuario findByUsername(String username) {
        return uRepo.findOneByUsername(username);
    }
    
}
