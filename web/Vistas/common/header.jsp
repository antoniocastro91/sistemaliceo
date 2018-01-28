<%@page import="Include.Usuario.Usuario"%>
<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    HttpSession sesion = request.getSession(true);
    String usuario = sesion.getAttribute("usuario") == null ? "" : sesion.getAttribute("usuario").toString();   
    Usuario user = null;
    ControladorUsuario cu = null;
    if(usuario != ""){
        cu = new ControladorUsuario();
        user = new Usuario(usuario.toString());
        user.setNivel(Integer.parseInt(session.getAttribute("nivel").toString()));
    }
%>  
<!DOCTYPE html>
<html>
    <head>
    <title>Menu Principal</title>
      <c:set var="req" value="${pageContext.request}" />
	<c:set var="uri" value="${req.requestURI}" />
	<c:set var="url">${req.requestURL}</c:set>
	<base href="http://localhost:26683/SistemMuna/" /> 
	<!--<base href="http://sistemmuna.j.sphere48.com/muna/" />-->
        
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">    
         <link rel="stylesheet" href="resources/css/RegistrarFicha.css">
         <link rel="stylesheet" href="resources/css/RegistrarUsuario.css">
          <link rel="stylesheet" href="resources/css/RegistrarInventario.css">
          <link rel="stylesheet" href="resources/css/piezas/estilo.css">
          <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>
         <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/v/dt/jq-3.2.1/dt-1.10.16/datatables.min.css"/>
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
          
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-3.2.1/dt-1.10.16/datatables.min.js"></script>
         <script type="text/javascript" src="resources/javascript/bootstrap.js" ></script>
         <script type="text/javascript" src="resources/javascript/jquery.validate.min.js"></script>
         <script type="text/javascript" src="resources/javascript/main.js"></script>
         <script type="text/javascript" src="resources/javascript/validaciones.js"></script>
                 

        <script type="text/javascript" src="resources/js/moment.js"></script>
        <script type="text/javascript" src="resources/js/bootstrap-datetimepicker.js"></script>
              <script>
            
            $(document).ready(function(){
               $('#fechaadquisi').datetimepicker({locale: 'es', format: "YYYY-MM-DD"}); 
               $('#fechainv').datetimepicker({locale: 'es', format: "YYYY-MM-DD"}); 
               $('#fechadesde').datetimepicker({locale: 'es', format: "YYYY-MM-DD"}); 
               $('#fechahasta').datetimepicker({locale: 'es', format: "YYYY-MM-DD"}); 
               $('.carousel').carousel({
                interval: 5000 //changes the speed
            });
            });
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
                    <a class="navbar-brand" href="Vistas/Principal/principal.jsp"><i class="glyphicon glyphicon-home"> MUNA </i></a>
              
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <%
                        if (user.getNivel() != 3 ) { %>
                 <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i class="glyphicon glyphicon-folder-open"> Piezas </i><span class="caret"></span></a>
                   <ul class="dropdown-menu">
                       <li><a href="Vistas/piezas/lista.jsp"><i class="glyphicon glyphicon-search"> Consultar </i></a></li>
                       <li><a href="Vistas/piezas/RegistrarInventario.jsp"><i class="glyphicon glyphicon-plus"> Ingresar </i></a></li>
                   </ul>
                 </li>
                 <% 
                     if(user != null){
                       if (user.getNivel() == 1){ %>
                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="glyphicon glyphicon-user"> Usuarios </i> <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                         <li><a href="Vistas/usuarios/ListaUsuarios.jsp"><i class="glyphicon glyphicon-search"> Consultar </i></a></li>
                         <li><a href="Vistas/usuarios/RegistroUsuarios.jsp"><i class="glyphicon glyphicon-plus"> Ingresar </i></a></li>
                     </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i class=" glyphicon glyphicon-file" > Reportes </i><span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <li><a href="Vistas/reportes/ReportesPiezas.jsp"><i class="glyphicon glyphicon-book"> Reporte de Piezas </i></a></li>
                          <li><a href="Vistas/reportes/ReportesUsuarios.jsp"><i class="glyphicon glyphicon-user" > Reporte de Usuarios</i></a></li>
                          <li><a href="Vistas/reportes/Reporte_Bitacora.jsp"><i class="glyphicon glyphicon-user" > Reporte de Log Usuarios</i></a></li>
                      </ul>
                    </li>
               <% } %>
                     <%   }}else{ %>
                           <li><a href="Vistas/piezas/lista_imagenes.jsp"><i class="glyphicon glyphicon-search" > Consultar Piezas</i></a></li>
                       <% }%>
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
   