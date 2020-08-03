/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.util;

import com.fuimonosapp.domain.Administrador;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author HP PC
 */
public class SessionUtils {
    public static boolean assertLogin(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("adminUser")!=null){
            if(session.getAttribute("adminUser").getClass().equals(Administrador.class)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if(session.getAttribute("adminUser")!=null){
            if(session.getAttribute("adminUser").getClass().equals(Administrador.class)){
                return true;
            }
        }
        try {
            response.sendRedirect(request.getContextPath() + "/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
