/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.util;

import com.fuimonosapp.commons.APIResponseBody;
import com.fuimonosapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP PC
 */
public class APIAuthentication {
    
    @Autowired
    UsuarioService uService;
    
    public ResponseEntity<Object> authenticateRequest(String username, String password){
        if(username == null || password == null){
            if(uService.authenticate(username, password)){
                return null;
            }
            else{
                return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);
            }
        }
        else{
            return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);
        }
    }

    public APIAuthentication() {
    }
    
}
