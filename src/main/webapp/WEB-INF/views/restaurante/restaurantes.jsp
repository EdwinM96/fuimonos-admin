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
        <title>Fuimonos</title>
        <!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="<c:url value="/resources/dashboard.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/metismenu/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.13.0/css/all.css">
        <style>
            .hamburger-box .hamburger-inner,
            .hamburger-box .hamburger-inner::before,
            .hamburger-box .hamburger-inner::after {
                background-color: white !important;
            }

            .hamburger--emphatic.is-active .hamburger-inner::before {
                background-color: white !important;
            }

            .hamburger--emphatic.is-active .hamburger-inner::after {
                background-color: white !important;
            }
        </style>
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
            <div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
                <div class="app-header header-shadow" style="background-color: #7F224A; color: white;">
                    <div class="app-header__logo">
                        <div class="logo-src" style="color:white; margin-left: 55px; font-size: 24px; margin-bottom: 28px; max-width: auto">
                            <img src="<c:url value="/resources/img/logo.png"/>" class="logo-img" style="max-width: 60px;">
                        </div>
                        <div class="header__pane ml-auto">
                            <div>
                                <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                                    <span class="hamburger-box" >
                                        <span class="hamburger-inner" ></span>
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="app-header__mobile-menu">
                        <div>
                            <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                            </button>
                        </div>
                    </div>
                    <div class="app-header__menu">
                        <span>
                            <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                                <span class="btn-icon-wrapper">
                                    <i class="fa fa-ellipsis-v fa-w-6"></i>
                                </span>
                            </button>
                        </span>
                    </div>    <div class="app-header__content">
                        <div class="app-header-left">
                        </div>

                    </div>
                </div>               <div class="app-main">
                    <div class="app-sidebar sidebar-shadow">
                        <div class="app-header__logo">
                            <div class="logo-src"></div>
                            <div class="header__pane ml-auto">
                                <div>
                                    <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                                        <span class="hamburger-box">
                                            <span class="hamburger-inner"></span>
                                        </span>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="app-header__mobile-menu">
                            <div>
                                <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                                    <span class="hamburger-box">
                                        <span class="hamburger-inner"></span>
                                    </span>
                                </button>
                            </div>
                        </div>
                        <div class="app-header__menu">
                            <span>
                                <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                                    <span class="btn-icon-wrapper">
                                        <i class="fa fa-ellipsis-v fa-w-6"></i>
                                    </span>
                                </button>
                            </span>
                        </div>    <div class="scrollbar-sidebar">
                            <div class="app-sidebar__inner">
                                <ul class="vertical-nav-menu">
                                    <li class="app-sidebar__heading">Administrador</li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/dashboard" class="">
                                            <i class="metismenu-icon pe-7s-display2"></i>
                                            Inicio
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/logout" class="">
                                            <i class="metismenu-icon pe-7s-back"></i>
                                            Cerrar Sesión
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>    
                    <div class="app-main__outer">

                        <div class="app-main__inner">
                            <c:if test="${creatingAccountSuccess}">
                                <div class="alert alert-success" role="alert">
                                    Restaurante creado!
                                </div>
                            </c:if>
                            <c:if test="${deletingAccountSuccess}">
                                <div class="alert alert-success" role="alert">
                                    Restaurante eliminado!
                                </div>
                            </c:if>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="main-card mb-3 card">
                                        <form method="GET" action="${pageContext.request.contextPath}/restaurantes">
                                            <div class="card-header" style="font-weight:bold;font-size: 16px;">

                                                Restaurantes
                                                <div class="search-word mt-2 mb-2 pl-4 pr-2"><input type="search" maxlength="24" class="form-control" placeholder="Buscar..." name="searchWord" value="${restauranteFilter}" onsearch="onClear(this)"></div>
                                                <div class=""><button type="submit" class="btn btn-success">Buscar</button></div>

                                                <div class="btn-actions-pane-right">
                                                    <a href="${pageContext.request.contextPath}/restaurante/crear"><button type="button" class="btn-success btn">+ Agregar Restaurante</button></a>
                                                </div>
                                            </div>
                                        </form>
                                        <div class="table-responsive">
                                            <table class="align-middle mb-0 table table-borderless table-striped table-hover">
                                                <thead>
                                                    <tr>
                                                        <th style="width:8%"></th>
                                                        <th>Nombre</th>
                                                        <th>Representante</th>
                                                        <th style="width:13%"></th>
                                                        <th style="width:5%"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${restaurantes}" var="restaurante" varStatus="index">
                                                        <tr>
                                                            <td class="text-center" style="font-weight: bold">

                                                                ${(index.index + 1)}.
                                                            </td>
                                                            <td>${restaurante.nombre}</td>
                                                            <td>${restaurante.representante}</td>
                                                            <td>
                                                                <a href="${pageContext.request.contextPath}/restaurante?id=${restaurante.restauranteId}">
                                                                    <button class="btn btn-primary">Ver detalles</button>
                                                                </a>
                                                            </td>
                                                            <td class="justify-content-end">
                                                                <a>
                                                                    <button type="button" class="btn btn-danger" onclick="llenarModalEliminar(${restaurante.restauranteId}, '${restaurante.nombre}')">&times;</button>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>

                                        </div>
                                        <div class="d-block text-center card-footer">
                                            <nav aria-label="...">
                                                <ul class="pagination justify-content-center">
                                                    <li class="page-item ${firstPage?'disabled':''}">
                                                        <a class="page-link" href="${lastPageUrl}" tabindex="-1">Previous</a>
                                                    </li>
                                                    <li class="page-item ${firstPage?'active':''}"><a class="page-link" href="${firstPageUrl}">${firstPageNumber!=null?firstPageNumber:1}</a></li>
                                                        <c:if test="${secondPageExist}">
                                                        <li class="page-item ${secondPage?'active':''}">
                                                            <a class="page-link" href="${secondPageUrl}">${secondPageNumber}</a>
                                                        </li>
                                                    </c:if>
                                                    <c:if test="${thirdPageExist}">
                                                        <li class="page-item ${thirdPage?'active':''}"><a class="page-link" href="${thirdPageUrl}">${thirdPageNumber}</a></li>
                                                        </c:if>
                                                    <li class="page-item ${nextPageExist?'':'disabled'}">
                                                        <a class="page-link" href="${nextPageUrl}">Next</a>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="app-wrapper-footer">
                            <div class="app-footer">
                                <div class="app-footer__inner">

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="modal fade" id="deleteRestauranteModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Desea eliminar este restaurante?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="text-center" id="nombreRestauranteModal" style="font-weight: bold; font-size:24px"></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <a href="" id="modalDeleteLink"><button type="button" class="btn btn-danger">Eliminar</button></a>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript">
                function llenarModalEliminar(id, nombreRestaurante) {
                    document.getElementById("modalDeleteLink").href = "${pageContext.request.contextPath}/restaurante/delete?id=" + id;
                    var labelDiv = document.getElementById("nombreRestauranteModal");
                    while (labelDiv.firstChild) {
                        labelDiv.removeChild(labelDiv.firstChild);
                    }
                    var labelContent = document.createTextNode(nombreRestaurante);
                    labelDiv.appendChild(labelContent);
                    $('#deleteRestauranteModal').modal('toggle')
                }

            </script>
            <script>

                function onClear(field) {
                    if (field.value === null) {
                        window.location.replace("${pageContext.request.contextPath}/restaurantes");
                    } else if (field.value === "") {
                        window.location.replace("${pageContext.request.contextPath}/restaurantes");
                    }
                }
            </script>
            <!-- <table>
                 <tr>
                     <th>Id</th>
                     <th>Nombre</th>
                     <th>Usuario</th>
                     <th>Pass</th>
                 </tr>
 
            <c:forEach items="${restaurantes}" var="restaurante" >
                <tr>
                    <td>${restaurante.restauranteId}</td>
                    <td>${restaurante.nombre}</td>
                    <td>${restaurante.username}</td>
                    <td>${restaurante.pass}</td>
                </tr>
            </c:forEach>
        </table>

        <form class="form1" action="${pageContext.request.contextPath}/saveRestaurante" method="POST">
            <input class="name " type="text" align="center" placeholder="Usua"name="nombre">
            <input class="pass" type="password" align="center" placeholder="Contraseña" name="pass">
            <input class="username" type="text" align="center" placeholder="username" name="username">

            <button type="submit" class="submit">Ingresar</button>
        </form>

         <form class="form1" action="${pageContext.request.contextPath}/busqueda" method="POST">
            <label>Ingresar codigo de restaurante: </label>
            <input type="number" name="codigo">
            <br>
            <button type="submit" name="action" value="borrar">Borrar</button><br>
            <button type="submit" name="action" value="actualizar">Actualizar</button><br>

        </form>-->
            <script type="text/javascript" src="<c:url value="/resources/dashboard.js"/>"></script>
        </body>
    </html>
