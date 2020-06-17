<%-- 
    Document   : actualizarResta
    Created on : 06-17-2020, 01:06:26 AM
    Author     : Javier
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form class="form1" action="${pageContext.request.contextPath}/saveRestaurante" method="POST">
            <input type="hidden" field="*{restaurante_id}" readonly = "readonly"><br>
            <input class="name " type="text" align="center" placeholder="Usua"name="nombre" field="*{nombre}"><br>
            <input class="pass" type="password" align="center" placeholder="Contraseña" name="pass" field="*{pass}"><br>
                <input class="username" type="text" align="center" placeholder="username" name="username" field="*{username}">
                
                <button type="submit" class="submit">Ingresar</button>
            </form>
    </body>
</html>
