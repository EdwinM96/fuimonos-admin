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
        if(username != null && password != null){
            if(uService.authenticate(username, password) != null){
                return null;
            }
            else{
                l.info("Authentication credentials were present");
                return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);
            }
        }
        else{
            l.info("Username: "+ username + "   Password: "+password);
            l.info("Authentication credentials were not present");
            return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);
        }
    }
    
   
    //TODO: Authenticate through correct encryption
    public ResponseEntity<Object> authenticateRequest(HttpServletRequest req){
        
        String authorization = req.getHeader("Authorization");
        if(authorization==null){return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);}
        l.info("Authentication token:      " + authorization);
        if(!authorization.contains("Basic ")){
            return new ResponseEntity(APIResponseBody.MISSING_BASIC, HttpStatus.UNAUTHORIZED);
        }
        authorization = authorization.replace("Basic ", "");
        try{
            authorization = new String(Base64.getDecoder().decode(authorization), StandardCharsets.UTF_8);
        }
        catch(Exception e){
            return new ResponseEntity(APIResponseBody.INCORRECT_ENCODE, HttpStatus.UNAUTHORIZED);
        }
        if(!authorization.contains(":")){
            return new ResponseEntity(APIResponseBody.INCORRECT_USER_PASSWORD_CONCATE, HttpStatus.UNAUTHORIZED);
        }
        String username = authorization.substring(0, authorization.indexOf(":"));
        String password = authorization.substring(authorization.indexOf(":")+1);
        if(password == null || username == null){return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);}
        l.info("Password: "+password);
        l.info("User: "+ username);
        if(authenticateRequest(username, password) == null){
            return null;
        }
        else{
                return new ResponseEntity(APIResponseBody.MISSING_AUTHORIZATION, HttpStatus.UNAUTHORIZED);
            }        
    }

    public APIAuthentication() {
    }
    
}
