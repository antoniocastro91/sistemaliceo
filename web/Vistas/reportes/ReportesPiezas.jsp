<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

 %>
<jsp:include page="../common/header.jsp"/>
   <style>
        
    .main-center-usuario{
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
    
    .main-usuario{
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
    <div class="main-center-usuario">
        <form class=" frm-registropieza" name= "reporte" action="ServletPiezas"> 
            <fieldset class="form-control input-group">               
                <legend>B&uacute;squeda por</legend>
                    <div class="row" align="center">
                        <div class="form-group col-md-7">
                            <label for="name"  align="center">Ingrese un nombre de la pieza</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input id="txtpieza" type="text" name="txtpieza"  class="form-control" />
                                </div>
                         </div>
                     </div> 
                    <div class="row" align="center">
                        <div class="form-group col-md-6">
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
           $("#txtpieza").keydown(function(e){
               if(e.which == 13){
                   e.preventDefault();
                   consultar_pieza();
               }
           });
          $("#btn-consultar").click(function(e){
              consultar_pieza();
          }); 
       });
       
       function consultar_pieza(){
           $.get('ServletPiezas',{txtpieza:$("#txtpieza").val(),consultar:true}, function(respuesta){
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
