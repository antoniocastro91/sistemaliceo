<%@page import="Include.Ficha.Ficha"%>
<%@page import="Controlador.Ficha.ControladorFicha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    ControladorFicha controladorFicha = new ControladorFicha();
    Ficha ficha = new Ficha();
    ficha = controladorFicha.getFicha(Integer.parseInt(request.getParameter("id_pieza").toString()));
%>
<jsp:include page="../common/header.jsp"/>
           <div class="container">
            <div class="row main">
                <div class="main-login main-center">
                    <form class="" method="post" id="frm-actuapieza" action="modificar_Piezas">
                         <h3 align="center">Formulario para la edicion de Pieza.</h3>
                        <input type="hidden" name="id" id="id" value="<%= ficha.getIdPieza() %>"/>
                          <div class="row">
                            <div class="form-group col-md-6">
                                    <label for="name" class="cols-sm-3 control-label">Ingrese el nombre de la Pieza</label>
                                        <div class="input-group">
                                              <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                              <input type="text" id="nombre" name="nombre" value="<%= ficha.getNombre() %>"  class="form-control" placeholder="Ingrese el nombre"/>
                                        </div>
                            </div>
                                 <div class="form-group">
                                    <label for="name" class="control-label">Ingrese la forma de la Pieza</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" id="forma" name="forma" value="<%= ficha.getForma() %>"  class="form-control" placeholder="Ingrese la forma"/>
                                        </div>
                                </div>
                            </div>  
                               <div class="row">
                                   <div class="form-group col-md-6">
                                    <label for="name" class="cols-sm-3 control-label">Ingrese el color de la Pieza</label>
                                        <div class="input-group">
                                             <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                             <input type="text" name="color" id="color" value="<%= ficha.getColor() %>"  class="form-control" placeholder="Ingrese el color "/>
                                         </div>
                                   </div>
                                    <div class="form-group">
                                     <label for="name" class="control-label">Ingrese el periodo de la Pieza</label>
                                        <div class="input-group">
                                             <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                             <input id="periodo" name="periodo" type="text"  value="<%= ficha.getPeriodo() %>" class="form-control" placeholder="Ingrese el periodo"/>
                                        </div>
                                   </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6">
                                       <label for="text" class="cols-sm-3 control-label">Ingrese el peso de la Pieza</label>
                                          <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input id="peso" name="peso" type="text"  value="<%= ficha.getPeso()%>" class="form-control" placeholder="Ingrese el peso"/>     
                                          </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group ">
                                        <button type="submit" id="btn-registro" class="btn btn-primary btn-lg btn-block login-button">Actualizar</button>
                                    </div> 
                                </div>
                    </form>
                </div>
            </div>
        </div>
                                                  <script>
                                                    $(document).ready(function(){
                                                        $("#frm-actuapieza").submit(function(e){
                                                            e.preventDefault();
                                                            var data = $(this).serialize();
                                                            $.post('modificar_Piezas', data, function(res, est, jqXHR){
                                                                if(res == 'ok'){
                                                                    alert("pieza modificada correctamente");
                                                                    setTimeout(function(){
                                                                        window.location = "Vistas/piezas/lista.jsp";   
                                                                    },100);
                                                                }else{
                                                                    alert("Ocurrio un error al modificar la pieza")
                                                                }
                                                            });
                                                        });
                                                      
                                                    });
                                                </script>
<jsp:include page="../common/footer.jsp"/>           