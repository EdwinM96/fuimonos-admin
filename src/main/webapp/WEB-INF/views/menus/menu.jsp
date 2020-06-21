<%-- 
    Document   : menu
    Created on : 06-18-2020, 11:57:25 PM
    Author     : Javier
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-color: #F3EBF6;
                font-family: 'Ubuntu', sans-serif;
            }

            .main {
                background-color: #FFFFFF;
                width: 400px;
                height: 400px;
                margin: 7em auto;
                border-radius: 1.5em;
                box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
            }

            .sign {
                padding-top: 40px;
                color: #8C55AA;
                font-family: 'Ubuntu', sans-serif;
                font-weight: bold;
                font-size: 23px;
            }

            .un {
                width: 76%;
                color: rgb(38, 50, 56);
                font-weight: 700;
                font-size: 14px;
                letter-spacing: 1px;
                background: rgba(136, 126, 126, 0.04);
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                outline: none;
                box-sizing: border-box;
                border: 2px solid rgba(0, 0, 0, 0.02);
                margin-bottom: 50px;
                margin-left: 46px;
                text-align: center;
                margin-bottom: 27px;
                font-family: 'Ubuntu', sans-serif;
            }

            form.form1 {
                padding-top: 40px;
            }

            .pass {
                width: 76%;
                color: rgb(38, 50, 56);
                font-weight: 700;
                font-size: 14px;
                letter-spacing: 1px;
                background: rgba(136, 126, 126, 0.04);
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                outline: none;
                box-sizing: border-box;
                border: 2px solid rgba(0, 0, 0, 0.02);
                margin-bottom: 50px;
                margin-left: 46px;
                text-align: center;
                margin-bottom: 27px;
                font-family: 'Ubuntu', sans-serif;
            }


            .un:focus, .pass:focus {
                border: 2px solid rgba(0, 0, 0, 0.18) !important;

            }

            .submit {
                cursor: pointer;
                border-radius: 5em;
                color: #fff;
                background: linear-gradient(to right, #9C27B0, #E040FB);
                border: 0;
                padding-left: 40px;
                padding-right: 40px;
                padding-bottom: 10px;
                padding-top: 10px;
                font-family: 'Ubuntu', sans-serif;
                margin-left: 35%;
                font-size: 13px;
                box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
            }

            .forgot {
                text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
                color: #E1BEE7;
                padding-top: 15px;
            }

            a {
                text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
                color: #E1BEE7;
                text-decoration: none
            }

            @media (max-width: 600px) {
                .main {
                    border-radius: 0px;
                }
            </style>
        </head>
        <body>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>restaurante_id</th>

                </tr>

                <c:forEach items="${menus}" var="menu">
                    <tr>
                        <td>${menu.menu_id}</td>
                        <td>${menu.nombre_menu}</td>


                        <td>${menu.restaurante.nombre}</td>



                    </tr>
                </c:forEach>
            </table>

            <form class="form1" action="${pageContext.request.contextPath}/saveMenu" method="POST">
                <input class="name " type="text" align="center" placeholder="nombre"name="nombre_menu">

                <label for="restaurante"> Restaurante:</label>



                <select id="restaurante" name="restaurante"  >

                    <c:forEach items="${restaurantes}" var="restaurante">
                        <option value="<${restaurante.restaurante_id}>"/>${restaurante.username}</option>
                    </c:forEach>

                </select>   




                <button type="submit" class="submit">Ingresar</button>
            </form>

            
        </body>
    </html>
