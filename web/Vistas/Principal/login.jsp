<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%@page import="Include.Usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    
    <title>Museo Nacional Antropolog&iacute;</title>
      <c:set var="req" value="${pageContext.request}" />
	<c:set var="uri" value="${req.requestURI}" />
	<c:set var="url">${req.requestURL}</c:set>
	<base href="http://localhost:26683/SistemMuna/" /> 
	<!--<base href="http://sistemmuna.j.sphere48.com/muna/" />-->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/formlogin.css">
        <!-- icon -->
        <link rel="icon" href="resources/imagenes/iconos/login.png" >

</head>
<body>

	 <div class="wrapper">
            
            <form class="login" method="post" id="frm-login" action="Login">
                <div align ="center">
                     <p><h4 style =" color:orange">MUSEO NACIONAL DE ANTROPOLOGIA</h4>
		<img src ="resources/imagenes/login4.jpg" width= "225" height="175" align="center"><p>
		</div>
                 <p align="center" class="title" >INICAR SESI&Oacute;N</p>
                
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="text" name="usuario" id="usuario" placeholder="Nombre de Usuario" autofocus/>
                
               
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" name="clave" id="clave"  placeholder="Contraseña" />
                 
                <button  type="submit" value="Iniciar Sesion" id="btn-login">Iniciar Sesion</button>
           </form>

        </div>		
         <!-- JavaScript -->
         <script type="text/javascript" src="resources/javascript/jquery-3.2.1.js"></script>
         <script type="text/javascript" src="resources/javascript/jquery.validate.min.js"></script>
         <script type="text/javascript" src="resources/javascript/main.js"></script>
         
</body>
</html>