/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import org.springframework.stereotype.Service;
import com.fuimonosapp.domain.Administrador;
import com.fuimonosapp.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author HP PC
 */
@Service
public class AdministradorService {
    
    @Autowired
    AdministradorRepository adminRepo;
    
    public Administrador crearAdministrador(Administrador administrador){
        return adminRepo.saveAndFlush(administrador);
    }
    
}
