/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.util;

import com.fuimonosapp.domain.Administrador;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
}
