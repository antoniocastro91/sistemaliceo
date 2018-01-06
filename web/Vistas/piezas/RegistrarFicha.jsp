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
                <div class="main-login-ficha main-center-ficha">
                    <form class="" method="post" id="frm-actuapieza" action="modificar_Piezas" enctype="multipart/form-data">
                         <h3 align="center">Formulario para el Registro de una Ficha.</h3>
                          <input type="hidden" name="id" id="id" value="<%= ficha.getIdPieza() %>"/>
                          <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Nombre de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-font"></i></span>
                                               <input type="text" id="nombre" name="nombre"  value="<%= ficha.getNombre() %>"  class="form-control" placeholder="Nombre" required=""/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Forma de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-screenshot"></i></span>
                                               <input type="text" id="forma" name="forma"  value="<%= ficha.getForma()%>"  class="form-control" placeholder="Forma"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Material de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-tags"></i></span>
                                               <input type="text" id="material" name="material" value="<%= ficha.getMaterial()%>"    class="form-control" placeholder="Material"/>
                                         </div>
                                </div>
                         </div>
                        <div class="row">
                              <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">T&eacute;cnica de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-text-width"></i></span>
                                               <input type="text" id="tecnica" name="tecnica" value="<%= ficha.getTecnica()%>"  class="form-control" placeholder="Tecnica"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Color de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-adjust"></i></span>
                                               <input type="text" id="color" name="color"  value="<%= ficha.getColor()%>"  class="form-control" placeholder="Color"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Periodo de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="periodo" name="periodo"  value="<%= ficha.getPeriodo()%>"  class="form-control" placeholder="Periodo"/>
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-6">
                                  <label for="name" class="cols-sm-3 control-label">Clasificaci&oacute; de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-tasks"></i></span>
                                               <input type="text" id="clasificacion" name="clasificacion" value="<%= ficha.getClasificacion()%>"  class="form-control" placeholder="Clasificacion"/>
                                         </div>
                                </div>
                       
                               
                              <div class="form-group col-md-2">
                                  <label for="name" class="cols-sm-3 control-label">Alto</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-vertical"></i></span>
                                               <input type="text" id="alto" name="alto"  value="<%= ficha.getAlto()%>" class="form-control" placeholder="Alto"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Ancho</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-sound-stereo"></i></span>
                                               <input type="text" id="ancho" name="ancho" value="<%= ficha.getAncho()%>"  class="form-control" placeholder="Ancho"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Largo</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-horizontal"></i></span>
                                               <input type="text" id="largo" name="largo" value="<%= ficha.getLargo()%>"  class="form-control" placeholder="Largo"/>
                                         </div>
                                </div>
                               </div> 
                         <div class="row">
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Di&aacute;metro</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-modal-window"></i></span>
                                          <input type="text" id="diametro" name="diametro" value="<%= ficha.getDiamtero()%>"  class="form-control" placeholder="Diam"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Grosor</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-equalizer"></i></span>
                                          <input type="text" id="grosor" name="grosor" value="<%= ficha.getGrosor()%>" class="form-control" placeholder="Grosor"/>
                                    </div>
                                </div>
                                    <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Peso</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-scale"></i></span>
                                          <input type="text" id="peso" name="peso" value="<%= ficha.getPeso()%>"  class="form-control" placeholder="Peso"/>
                                    </div>
                                </div>
                         </div>  
                            <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Procendecia</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-plane"></i></span>
                                               <input type="text" id="procedencia" name="procedencia" value="<%= ficha.getProcedencia()%>"  class="form-control" placeholder="Procendencia"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Condicion de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-exclamation-sign"></i></span>
                                               <input type="text" id="condicion" name="condicion" value="<%= ficha.getCondicion()%>"  class="form-control" placeholder="Condicion "/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">Forma de Adquisici&oacute;n</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-warning-sign"></i></span>
                                               <input type="text" id="formaadquisicion" name="formaadquisicion" value="<%= ficha.getFormaAdquisicion()%>"  class="form-control" placeholder="FormaAdquisicion"/>
                                         </div>
                                </div>
                         </div>
                             <div class="row">
                              <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Fecha de Adquisici&oacute;n</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="date" id="fechaadquisi" name="fechaadquisi" value="<%= ficha.getFAdquisicion()%>"  class="form-control"/>
                                         </div>
                                </div>
                                 <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">R&eacute;gimen de propiedad</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-flag"></i></span>
                                               <input type="text" id="regimenpro" name="regimenpro" value="<%= ficha.getRegimen()%>"  class="form-control" placeholder="Regimen"/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Custodio</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                               <input type="text" id="custodio" name="custodio" value="<%= ficha.getCustodio()%>"  class="form-control" placeholder="Custodio" />
                                         </div>
                                </div>
                         </div>
                                
                           
                             
                                <div class="form-group ">
                                    <button type="submit" id="btn-registro" class="btn btn-primary btn-lg btn-block login-button">Actualizar</button>
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
    $('#frm-registousuario').submit(function(e){
        e.preventDefault();
        var data = $(this).serialize();
        $.post("CrearFicha", data, function(respuesta){
            if(respuesta == 1){
                alert("Pieza insertada correctamente");
            }else{
                alert("Ocurriò un error al insertar la pieza, por favor intente nuevamente");
            }
        });
    });
</script>
<jsp:include page="../common/footer.jsp"/>
