/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Puntotransacciones
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("-- HttpSessionListener#sessionCreated invoked --");
      HttpSession session = se.getSession();
      System.out.println("session id: " + session.getId());
      session.setMaxInactiveInterval(24*60*60);//in seconds
    }
  

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
      System.out.println("-- HttpSessionListener#sessionDestroyed invoked --");
  }
}
