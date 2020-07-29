<%-- 
    Document   : agregar-restaurante
    Created on : 21/06/2020, 11:35:44 PM
    Author     : HP PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                                        <a href="${pageContext.request.contextPath}/dashboard" class="mm-active">
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
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="main-card mb-3 card">
                                        <div class="card-header">Agregando Nuevo Restaurante
                                            <!-- <p style="color: red">Please note that saving the changes will override all previous information.</p> -->
                                        </div>
                                        <form:form method="POST" action="${pageContext.request.contextPath}/restaurante/crear" enctype="multipart/form-data">
                                            <div class="row mt-4 mb-5">
                                                <div class="col-lg-1"></div> 
                                                <div class="col-sm-9 col-md-7 col-lg-4 col-11 mx-auto">
                                                    <div class="form-label-group">
                                                        <label for="username">Usuario: <font color="red">*</font></label>
                                                        <input type="text" id="username" class="form-control" placeholder="Usuario" name="username"  required>
                                                    </div>
                                                    <div class="form-label-group mt-2">
                                                        <label for="nombre">Nombre: <font color="red">*</font></label>
                                                        <input type="text" id="nombre" class="form-control" placeholder="Nombre"  name="nombre" required>
                                                    </div>
                                                    <div class="form-label-group mt-2">
                                                        <label for="horario_de_apertura">Horario de apertura: <font color="red">*</font></label>
                                                        <input type="time" id="horario_de_apertura" class="form-control" placeholder="Horario de apertura"  pattern="dd-MM-yy" type="date" name="horario_de_apertura" required>
                                                    </div>
                                                    <div class="form-label-group mt-2">
                                                        <label for="horario_de_cierre">Horario de cierre: <font color="red">*</font></label>
                                                        <input type="time" id="horario_de_cierre" class="form-control" placeholder="Horario de cierre"  pattern="dd-MM-yy" type="date" name="horario_de_cierre" required>
                                                    </div>
                                                    <div class="form-label-group mt-2">
                                                        <label for="tiempo_estimado_de_entrega">Tiempo estimado de entrega: <font color="red">*</font></label>
                                                        <input type="text" id="tiempo_estimado_de_entrega" class="form-control"   name="tiempo_estimado_de_entrega" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" required >
                                                    </div>

                                                    <div class="form-label-group mt-2">
                                                        <label for="imagen_de_portada">Imagen de portada <font color="red">*</font></label>
                                                        <input type="file" accept="image/x-png,image/gif,image/jpeg" src="" id="imagen_de_portada" class="form-control"  name="imagen_de_portada" required>
                                                    </div>

                                                    <div class="form-label-group mt-2">
                                                        <label for="departamento"> Departamento:</label>
                                                        <select id="departamento" name="departamento" class="form-control" >

                                                            <c:forEach items="${departamentos}" var="departamento">
                                                                <option value="${departamento.departamento_id}"/>${departamento.nombre_departamento}</option>
                                                            </c:forEach>

                                                        </select> 

                                                    </div>
                                                </div>                                                                               
                                                <div class="col-sm-9 col-md-7 col-lg-4 col-11 mx-auto">
                                                    <!--<div class="form-label-group">
                                                        <label for="descuento">Descuento</label>
                                                        <input type="number" id="descuento" class="form-control" placeholder="Descuento"  name="descuento">
                                                    </div>-->
                                                    <div class="form-label-group">
                                                        <label for="password">Contraseña: <font color="red">*</font></label>
                                                        <input type="password" id="password" class="form-control" placeholder="Contraseña" name="pass"  required>
                                                    </div>
                                                    <div class="form-label-group">
                                                        <label for="nit">NIT: </label>
                                                        <input type="text" id="nit" class="form-control" placeholder="NIT"  name="nit">
                                                    </div>
                                                    <div class="form-label-group">
                                                        <label for="representante">Correo electrónico: <font color="red">*</font></label>
                                                        <input type="text" id="representante" class="form-control" placeholder="Correo eletrónico"  name="correo" required>
                                                    </div>
                                                    <div class="form-label-group">
                                                        <label for="representante">Representante:</label>
                                                        <input type="text" id="representante" class="form-control" placeholder="Representante"  name="representante">
                                                    </div>
                                                    <div class="form-label-group mt-2">
                                                        <label for="numero_de_contacto">Numero de Contacto:</label>
                                                        <input type="text" id="numero_de_contacto" class="form-control" placeholder="Numero de Contacto"  name="numero_de_contacto">
                                                    </div>
                                                    <div class="form-label-group mt-2">
                                                        <label for="comision">Comision sobre Negocio (%) <font color="red">*</font></label>
                                                        <input type="number" id="comision" class="form-control" placeholder="Comision"  name="comision" required>
                                                    </div>
                                                    <div class="form-label-group mt-2">
                                                        <label for="cargosExtras">Cargos extras:</label>
                                                        <input type="number" id="cargosExtras" class="form-control" step="0.01" placeholder="Cargos extras"  name="cargosExtras">
                                                    </div>

                                                </div>


                                            </div>
                                            <div class="text-center mb-5 mt-3">
                                                <button type="submit" class="btn btn-success btn-lg" style="padding-top:10px;padding-bottom:10px;padding-left:30px;padding-right:30px;font-size: 18px; margin-right:10px">Guardar</button>
                                                <a href="${pageContext.request.contextPath}/restaurantes">
                                                    <button type="button" class="btn btn-danger btn-lg" style="padding-top:10px;padding-bottom:10px;padding-left:30px;padding-right:30px;font-size: 18px; margin-left:10px">Cancelar</button>
                                                </a>
                                            </div>
                                        </form:form>
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
            <script type="text/javascript" src="<c:url value="/resources/dashboard.js"/>"></script>   
        </body>
    </html>
