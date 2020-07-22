/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.commons;

/**
 *
 * @author HP PC
 */
public interface APIResponseBody {
    public String MISSING_AUTHORIZATION = "La autenticación ha fallado.";
    public String INCORRECT_ENCODE = "La encodificación utilizada sobre la autenticación es incorrecta";
    public String MISSING_BASIC = "La autenticación no contiene el parametro 'Basic'";
    public String INCORRECT_USER_PASSWORD_CONCATE = "La concatenación de el usuario y contraseño es incorrecta o carece del parametro de unión";
}
