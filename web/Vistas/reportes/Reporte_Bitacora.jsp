<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Include.Usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<%
    HttpSession sesion = request.getSession(true);
    String usuario = sesion.getAttribute("usuario") == null ? "" : sesion.getAttribute("usuario").toString();
    String url = response.encodeRedirectURL(request.getContextPath() + "/Vistas/Principal/login.jsp");
    if(usuario == ""){
        response.sendRedirect(url);
        return;
    }
    Object nivel = sesion.getAttribute("nivel") == null ? null : sesion.getAttribute("nivel");
    if (Integer.parseInt(nivel.toString()) != 1){
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Vistas/Principal/principal.jsp"));
    }
    
    ControladorUsuario cu = new ControladorUsuario();
    List<Usuario> lista_usuario = cu.listar();
%>
   <style>
        
    .main-center-reporte{
    margin-top: 10px;
    margin: 0 auto;
    max-width: 800px;
    padding: 10px 40px;
    background:#fff;
    color: #fff;
    text-shadow: none;
    -webkit-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);
    -moz-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);
    box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);
    
    .main-reporte{
    background-color: #c7ddef;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}

}

    </style>
<div class ="container">
  <div class="row main">
    <div class="main-center-reporte">
        <form class=" frm-registrousuario" name= "reporte" action="ServletLogUsuarios"> 
            <fieldset class="form-control input-group">               
                <legend>B&uacute;squeda por</legend>
                    <div class="row" align="center">
                        
                        <div class="form-group col-md-4">
                            <label for="name"  align="center">Seleccione un usuario</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user fa fa-user fa" aria-hidden="true"></i></span>
                                    <select id="selectusuario" name="selectusuario" class="form-control">
                                        <option value="0">Todos</option>
                                        <% for(int i=0; i < lista_usuario.size(); i++ ){ %>
                                        <option value="<%=lista_usuario.get(i).getId_usuario() %>"><%= lista_usuario.get(i).getUsuario()%></option>
                                        <% } %>
                                        
                                    </select>
                                </div>
                         </div>
                        <div class="form-group col-md-4">
                            <label for="name"  align="center">Desde</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-user fa" aria-hidden="true"></i></span>
                                    <input id="fechadesde" type="text" name="fechadesde"  class="form-control" />
                                </div>
                         </div>
                        <div class="form-group col-md-4">
                            <label for="name"  align="center">Hasta</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-user fa" aria-hidden="true"></i></span>
                                    <input id="fechahasta" type="text" name="fechahasta"  class="form-control" />
                                </div>
                         </div>
                     </div> 
                    <div class="row" align="center">
                        <div class="col-md-2"></div>
                        <div class="form-group col-md-7">
                            <a id="btn-consultar" class="btn btn-primary btn-lg btn-block login-button"><i class="glyphicon glyphicon-search"> Buscar</i></a>
                        </div> 
                   </div>     
            </fieldset>
            </form>  
        </div>  
    </div>  
</div> 
    <script>
       $(document).ready(function(){
           var consultar = false;
           $("#fechadesde").keydown(function(e){
               if(e.which == 13){
                   e.preventDefault();
                   consultar_usuariolog();
               }
           });
           $("#fechahasta").keydown(function(e){
               if(e.which == 13){
                   e.preventDefault();
                   consultar_usuariolog();
               }
           });
          $("#btn-consultar").click(function(e){
              consultar_usuariolog();
          }); 
       });
       
       function consultar_usuariolog(){
           $.get('ServletLogUsuarios',{selectusuario:$("#selectusuario").val(),fechadesde:$("#fechadesde").val(),fechahasta:$("#fechahasta").val(),consultar:true}, function(respuesta){
                  if(respuesta == "ok"){
                      $("form").submit();
                      return true;
                  }else{
                      alert("No se ha encontrado ninguna pieza");
                      return false;
                  }
              });
       }
        
    </script>

<jsp:include page="../common/footer.jsp"/>