<%-- 
    Document   : dashboard
    Created on : 13/06/2020, 10:55:07 PM
    Author     : HP PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- CSS only -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
   
    </head>
    <body>
        <h1>Hello World from dashboard!</h1>
        <a href="${pageContext.request.contextPath}/logout"><button type="button" class="btn btn-primary">Logout</button></a>
    
            <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Population</th>
                <th>pass</th>
            </tr>
                
              <c:forEach items="${restaurantes}" var="restaurante" >
                <tr>
                    <td>${restaurante.restaurante_id}</td>
                    <td>${restaurante.nombre}</td>
                    <td>${restaurante.username}</td>
                    <td>${restaurante.pass}</td>
                </tr>
              </c:forEach>
    </body>
</html>
