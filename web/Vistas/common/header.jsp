<%@page import="Include.Usuario.Usuario"%>
<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
    Object usuario = sesion.getAttribute("usuario") == null ? null : sesion.getAttribute("usuario");
    Usuario user = null;
    ControladorUsuario cu = null;
    if(usuario != null){
        cu = new ControladorUsuario();
        user = new Usuario(usuario.toString());
        user.setNivel(Integer.parseInt(session.getAttribute("nivel").toString()));
    }
%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
    <title>Menu Principal</title>
      <c:set var="req" value="${pageContext.request}" />
	<c:set var="uri" value="${req.requestURI}" />
	<c:set var="url">${req.requestURL}</c:set>
	<base href="http://localhost:8080/SistemMuna/" />
        
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">    
         <link rel="stylesheet" href="resources/css/RegistrarFicha.css">
         <link rel="stylesheet" href="resources/css/RegistrarUsuario.css">
          <link rel="stylesheet" href="resources/css/RegistrarInventario.css">
         <style>
		.carousel-inner > .item > img,
		.carousel-inner > .item > a > img {
			height: 400px;
			margin: auto;
		}
	</style>
         <!-- Icon -->
         <link rel="icon" href="resources/imagenes/iconos/icono-menu.png" >
          <!-- JavaScript -->
          <script type="text/javascript" src="resources/javascript/jquery-3.2.1.js"></script>
         <script type="text/javascript" src="resources/javascript/bootstrap.min.js" ></script>
         <script type="text/javascript" src="resources/javascript/jquery.validate.min.js"></script>
         <script type="text/javascript" src="resources/javascript/main.js"></script>
         <script>
            $('.carousel').carousel({
                interval: 1000 //changes the speed
            })
        </script>
  </head>
    <body>
        <nav class="navbar navbar-default">
      <header class="main-bar header-layout-center-logo">
           <a href="principal.jsp">
               <img class="img-responsive img-rounded"  src="resources/imagenes/menu1.jpg"/>
            </a>
          
      </header>
               <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="Vistas/Principal/principal.jsp">Menu Principal</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                 <li class="dropdown">
                   <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Piezas<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                     <li><a href="Vistas/piezas/lista.jsp">Consultar</a></li>
                     <li><a href="Vistas/piezas/RegistrarFicha.jsp">Ingresar</a></li>
                    
                   </ul>
                 </li>
                 <% 
                     if(user != null){
                       if (user.getNivel() == 1){ %>
                     <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Inventario<span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <li><a href="Vistas/inventario/Lista.jsp">Consultar</a></li>
                        <li><a href="Vistas/inventario/RegistrarInventario.jsp">Ingresar</a></li>
                      </ul>
                    </li>
                   <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuarios <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                         <li><a href="Vistas/usuarios/ListaUsuarios.jsp">Consultar</a></li>
                         <li><a href="Vistas/usuarios/RegistroUsuarios.jsp">Ingresar</a></li>
                     </ul>
                    </li>
                         <% } 
               }%>
                  </ul>
                          
             
                  <ul class="nav navbar-nav navbar-right pull-right">
                     <%  if(user != null){ %>
                     <%=  cu.getViewUser(user)%>
                     <%   }else{
                            response.getWriter().print("Por favor inicie sesion ");
                            response.getWriter().print("<a href='Vistas/Principal/login.jsp'> Iniciar Sesion</a>");
                        }
                    %>
                     
                  </ul>
                </div><!-- /.navbar-collapse -->
              </div><!-- /.container-fluid -->
            </nav>
    
