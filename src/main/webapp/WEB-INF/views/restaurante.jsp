<%-- 
    Document   : restaurantes
    Created on : 14/06/2020, 04:11:29 PM
    Author     : HP PC
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
        <table>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Pass</th>
            </tr>
                
              <c:forEach items="${restaurantes}" var="restaurante" >
                <tr>
                    <td>${restaurante.restaurante_id}</td>
                    <td>${restaurante.nombre}</td>
                    <td>${restaurante.username}</td>
                    <td>${restaurante.pass}</td>
                </tr>
              </c:forEach>
        </table>
    </body>
</html>
