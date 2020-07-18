/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller.api;

import com.fuimonosapp.domain.*;
import com.fuimonosapp.service.UsuarioService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP PC
 */

@RequestMapping("/api")
@RestController
public class UsuarioControllerAPI {
    
    @Autowired
    UsuarioService uService;
    
    DateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    @PostMapping(value = "/registro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestParam("email") String email, @RequestParam("username") String username,
            @RequestParam("password") String password, @RequestParam("nombre") String nombre, 
            @RequestParam("apellido") String apellido, @RequestParam(value = "fecha_de_nacimiento", required=false)String fechaDeNacimiento, 
            @RequestParam("celular")String celular, @RequestParam(value = "imagen_perfil", required=false) MultipartFile imagen) throws IOException{
        Date fechaNacimiento = null;
        if(!uService.emailIsAvailable(email)){
            return new ResponseEntity("Ya hay una cuenta creada con este correo.", HttpStatus.CONFLICT);
        }   
        if(!uService.usernameIsAvailable(username)){
            return new ResponseEntity("Ya hay una cuenta creada con este nombre de usuario.", HttpStatus.CONFLICT);
        }
        if(fechaDeNacimiento.contains("/")){
            try{
                fechaNacimiento = dFormat.parse(fechaDeNacimiento);
            }
            catch(Exception e){
                return new ResponseEntity("La fecha de nacimiento está en un formato incompatible", HttpStatus.BAD_REQUEST);
            }
        }
        else{
            try{
                fechaNacimiento = new Date(Integer.parseInt(fechaDeNacimiento));
            }
            catch(Exception e){
                return new ResponseEntity("La fecha de nacimiento está en un formato incompatible", HttpStatus.BAD_REQUEST);
            }
        }
        Byte[] imageBytes = null;
        if(imagen !=null){
        imageBytes = new Byte[imagen.getBytes().length];
        try{       
            for (int i = 0; i < imagen.getBytes().length; i++)
            {
                imageBytes[i] = imagen.getBytes()[i];
            }
        }
        catch(Exception e){
            return new ResponseEntity("La imagen de perfil está en un formato incompatible", HttpStatus.BAD_REQUEST);
        }
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPass(password);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCelular(celular);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setImagenPerfil(imageBytes);
        usuario = uService.saveUsuario(usuario);
                
        return new ResponseEntity(usuario,HttpStatus.OK );
    }
    
}
