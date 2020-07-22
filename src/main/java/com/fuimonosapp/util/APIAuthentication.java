/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.util;

import com.fuimonosapp.commons.APIResponseBody;
import com.fuimonosapp.service.UsuarioService;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
    
    Logger l = Logger.getLogger("log");
    
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
    
    public ResponseEntity<Object> authenticateRequest(HttpServletRequest req){
        //TODO: Authenticate through correct encryption
        String authentication = req.getHeader("Authentication");
        if(authentication==null){return new ResponseEntity(APIResponseBody.MISSING_BASIC, HttpStatus.UNAUTHORIZED);}
        if(!authentication.contains("Basic ")){
            return new ResponseEntity(APIResponseBody.MISSING_BASIC, HttpStatus.UNAUTHORIZED);
        }
        authentication = authentication.replace("Basic ", "");
        try{
            authentication = new String(Base64.getDecoder().decode(authentication), StandardCharsets.UTF_8);
        }
        catch(Exception e){
            return new ResponseEntity(APIResponseBody.INCORRECT_ENCODE, HttpStatus.UNAUTHORIZED);
        }
        if(!authentication.contains(":")){
            return new ResponseEntity(APIResponseBody.INCORRECT_USER_PASSWORD_CONCATE, HttpStatus.UNAUTHORIZED);
        }
        String username = authentication.substring(0, authentication.indexOf(":"));
        l.info("-------------------------------Username-------------------'"+username+"'");
        String password = authentication.substring(authentication.indexOf(":"));
        l.info("-------------------------------Password-------------------'"+password+"'");
        if(uService.authenticate(username, password)){
            return null;
        }
        else{
                return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);
            }        
    }

    public APIAuthentication() {
    }
    
}
