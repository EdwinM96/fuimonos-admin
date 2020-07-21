/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.controller.api;

import com.fuimonosapp.commons.APIResponseBody;
import com.fuimonosapp.domain.*;
import com.fuimonosapp.dto.UsuarioDTO;
import com.fuimonosapp.service.UsuarioService;
import com.fuimonosapp.util.APIAuthentication;
import com.fuimonosapp.vo.UsuarioVO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    APIAuthentication auth = new APIAuthentication();
    
    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody(required = false) String usuario, @RequestBody(required = false) String contrasena){
        ResponseEntity re = auth.authenticateRequest(usuario, contrasena);
        if(re!=null){return re;}
        Usuario user = uService.findByUsername(usuario);
        UsuarioDTO uDTO = new UsuarioDTO();
        uDTO.setImagenDePerfil(user.getImagenPerfil());
        uDTO.setApellido(uDTO.getApellido());
        uDTO.setNombre(user.getNombre());
        uDTO.setCelular(user.getCelular());
        uDTO.setUsuario(user.getUsername());
        return new ResponseEntity(uDTO, HttpStatus.OK);
    }


    @PostMapping(value = "/registro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody UsuarioVO usuarioVO) throws IOException {
        Date fechaNacimiento = null;
        if (!uService.emailIsAvailable(usuarioVO.getEmail())) {
            return new ResponseEntity("Ya hay una cuenta creada con este correo.", HttpStatus.CONFLICT);
        }
        if (usuarioVO.getUsername() != null) {
            if (!uService.usernameIsAvailable(usuarioVO.getUsername())) {
                return new ResponseEntity("Ya hay una cuenta creada con este nombre de usuario.", HttpStatus.CONFLICT);
            }
        }
        if (!uService.celularIsAvailable(usuarioVO.getCelular())) {
            return new ResponseEntity("Ya hay una cuenta creada con este numero de telefono.", HttpStatus.CONFLICT);
        }
        if (usuarioVO.getFechaDeNacimiento() != null) {
            if (usuarioVO.getFechaDeNacimiento().contains("/")) {
                try {
                    fechaNacimiento = dFormat.parse(usuarioVO.getFechaDeNacimiento());
                } catch (Exception e) {
                    return new ResponseEntity("La fecha de nacimiento está en un formato incompatible", HttpStatus.BAD_REQUEST);
                }
            } else {
                try {
                    fechaNacimiento = new Date(Integer.parseInt(usuarioVO.getFechaDeNacimiento()));
                } catch (Exception e) {
                    return new ResponseEntity("La fecha de nacimiento está en un formato incompatible", HttpStatus.BAD_REQUEST);
                }
            }
        }
        Byte[] imageBytes = null;
        if (usuarioVO.getImagen() != null) {
            imageBytes = new Byte[usuarioVO.getImagen().getBytes().length];
            try {
                for (int i = 0; i < usuarioVO.getImagen().getBytes().length; i++) {
                    imageBytes[i] = usuarioVO.getImagen().getBytes()[i];
                }
            } catch (Exception e) {
                return new ResponseEntity("La imagen de perfil está en un formato incompatible", HttpStatus.BAD_REQUEST);
            }
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioVO.getEmail());
        usuario.setUsername(usuarioVO.getUsername());
        usuario.setPass(usuarioVO.getContrasena());
        usuario.setNombre(usuarioVO.getNombre());
        usuario.setApellido(usuarioVO.getApellido());
        usuario.setCelular(usuarioVO.getCelular());
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setImagenPerfil(imageBytes);
        usuario = uService.saveUsuario(usuario);

        return new ResponseEntity(usuario, HttpStatus.OK);
    }

}
