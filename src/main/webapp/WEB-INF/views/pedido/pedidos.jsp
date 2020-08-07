<%-- 
    Document   : pedidos
    Created on : 3/08/2020, 01:38:31 AM
    Author     : HP PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuimonos</title>
        <!-- CSS only -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/metismenu/dist/metisMenu.min.css">
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
    </head>
    <body>
       <!-- <h1>Hello World from dashboard!</h1>
        <a href="${pageContext.request.contextPath}/logout"><button type="button" class="btn btn-primary">Logout</button></a>
    
        <a href="restaurantes">Restaurantes</a>-->
       
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
                    <div class="app-header-right">
                        <div class="header-btn-lg pr-0">
                            <div class="widget-content p-0">
                                <div class="widget-content-wrapper">
                                </div>
                            </div>
                        </div>        </div>
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
                        <c:if test="${pedidoActualizado}">
                            <div class="alert alert-success" role="alert">
                                Pedido Actualizado!
                            </div>
                        </c:if>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="main-card mb-3 card">
                                        <div class="card-header" style="font-weight:bold;font-size: 16px;">
                                            Pedidos
                                           
                                        </div>
                                            
                                    <div class="table-responsive">
                                        <table class="align-middle mb-0 table table-borderless table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th style="width:8%"></th>
                                                    <th>Nombre</th>
                                                    <th>Resatuante</th>
                                                    <th>Driver</th>
                                                    <th>Total</th>
                                                    <th style="width:13%">Status</th>
                                                    <th style="width:5%"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${pedidos}" var="pedido" varStatus="index">
                                                    <tr>
                                                        <td class="text-center" style="font-weight: bold">

                                                            ${(index.index + 1)}.
                                                        </td>
                                                        <td>${pedido.usuario_id.nombre}&nbsp;${pedido.usuario_id.apellido}</td>
                                                        <td>${pedido.restaurante_id.nombre}</td>
                                                        <td>${pedido.driver_asignado.nombreDriver}</td>
                                                        <td>
                                                           <fmt:formatNumber  value="${pedido.total_de_pedido}" type="currency" pattern="$####.##" minFractionDigits="2" /> 
                                                        </td>
                                                        <td style="color:green">${pedido.status}</td>
                                                        <td></td>
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
                                        <script src="<c:url value="/resources/font-awesome/js/all.js"/>"></script>
                                        <script type="text/javascript" src="<c:url value="/resources/dashboard.js"/>"></script>
    </body>
</html>
