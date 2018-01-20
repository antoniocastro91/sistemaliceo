<%@page import="Modelo.Conexion.Conexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Controlador.Inventario.ControladorInventario"%>
<%@page import="Include.Inventario.Inventario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Conexion con = new Conexion();
    HttpSession sesion = request.getSession(true);
    Object nivel = sesion.getAttribute("nivel") == null ? null : sesion.getAttribute("nivel");
    String usuario = sesion.getAttribute("usuario") == null ? "" : sesion.getAttribute("usuario").toString();
    String url = response.encodeRedirectURL(request.getContextPath() + "/Vistas/Principal/login.jsp");
    if(usuario == ""){
        response.sendRedirect(url);
        return;
    }
    
    if (Integer.parseInt(nivel.toString()) == 3){
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Vistas/Principal/principal.jsp"));
    }
    Controlador.Inventario.ControladorInventario controladorinventario = new ControladorInventario();
    Inventario ficha = new Inventario();
    ficha = controladorinventario.getInventario(Integer.parseInt(request.getParameter("id_inventario").toString()));
    /*ficha.setFAdquisicion(new SimpleDateFormat("dd-mm-yyyy").parse(ficha.getFAdquisicion()).toString());*/
%>
<jsp:include page="../common/header.jsp"/>
           <div class="container">
            <div class="row main">
                <div class="main-login main-center-inven">
                    <form class="" method="post" id="frm-actuapieza" action="modificar_Piezas" enctype="multipart/form-data">
                         <h3 align="center">Formulario para la edicion de Pieza.</h3>
                         <input type="hidden" name="id" id="id" value="<%= ficha.getIdInventario()%>" />
                             
                         <div class="row">
                             <div class="form-group col-md-5">
                                     <label for="name" class="cols-sm-3 control-label">Inv Nº</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class=" glyphicon glyphicon-barcode"></i></span>
                                               <input type="text" id="numinv"  name="numinv" value="<%= ficha.getNumInventario()%>" class="form-control" placeholder="Ingrese el numero de Inventario"/>
                                         </div>
                                </div>
                         </div>    
                         <div class="row">
                              <div class="form-group col-md-12">
                                     <label for="name" class="cols-sm-3 control-label">Descripcion</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
                                               <textarea class="form-control" id="descrip"  name="descrip"  style="color: black;" rows="2"><%= ficha.getDescripcion()%></textarea> 
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Nombre de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-font"></i></span>
                                               <input type="text" id="nombre" name="nombre" value="<%= ficha.getNombrePieza()%>" class="form-control" placeholder="Nombre"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Forma de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-screenshot"></i></span>
                                               <input type="text" id="forma" name="forma" value="<%= ficha.getForma()%>" class="form-control" placeholder="Forma"/>
                                         </div>
                                </div>
                                  <%
                                         Statement statement = con.getConexion().createStatement();
                                         ResultSet rs = statement.executeQuery("select * from Materiales");        
                                 %>
                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Material de la Pieza</label>
                                        <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-screenshot"></i></span>
                                                 <select type="text" id="material" name="material" class="form-control">
                                                    <option selected > Seleccione el Material</option>

                                                     <% while(rs.next()) { %>
                                                     <option value="<%=rs.getString("IdMaterial")%>" <%= ficha.getIdMaterial() == Integer.parseInt(rs.getString("IdMaterial")) ? "selected":"" %>> <%= rs.getString("Material")%></option> 
                                                     <% }%>    
                                                 </select>
                                         </div>
                                </div>
                         </div>
                        <div class="row">
                                <%
                                        Statement statementt = con.getConexion().createStatement();
                                        ResultSet rss = statementt.executeQuery("select * from tecnicas");        
                                 %>
                              <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">T&eacute;cnica de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-text-width"></i></span>
                                               <select type="text" id="tecnica" name="tecnica" class="form-control">   
                                               <option selected > Seleccione la Tecnica</option>

                                                     <% while(rss.next()) { %>
                                                     <option value="<%=rss.getString("IdTecnica")%>" <%= ficha.getIdTecnica()== Integer.parseInt(rss.getString("IdTecnica")) ? "selected":"" %>> <%=rss.getString("Tecnica")%></option> 
                                                     <% }%>    
                                                 </select>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Color de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-adjust"></i></span>
                                               <input type="text" id="color" name="color" value="<%= ficha.getColor()%>" class="form-control" placeholder="Color"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Periodo de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="periodo" name="periodo"  value="<%= ficha.getPeriodo()%>" class="form-control" placeholder="Periodo"/>
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-6">
                                  <label for="name" class="cols-sm-3 control-label">Clasificaci&oacute; de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-tasks"></i></span>
                                               <input type="text" id="clasificacion" name="clasificacion" value="<%= ficha.getClasificacion()%>" class="form-control" placeholder="Clasificacion"/>
                                         </div>
                                </div>
                       
                               
                              <div class="form-group col-md-2">
                                  <label for="name" class="cols-sm-3 control-label">Alto</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-vertical"></i></span>
                                               <input type="text" id="alto" name="alto" value="<%= ficha.getAlto()%>" class="form-control" placeholder="Alto"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Ancho</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-sound-stereo"></i></span>
                                               <input type="text" id="ancho" name="ancho" value="<%= ficha.getAncho()%>" class="form-control" placeholder="Ancho"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Largo</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-horizontal"></i></span>
                                               <input type="text" id="largo" name="largo" value="<%= ficha.getLargo()%>" class="form-control" placeholder="Largo"/>
                                         </div>
                                </div>
                               </div> 
                         <div class="row">
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Di&aacute;metro</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-modal-window"></i></span>
                                          <input type="text" id="diametro" name="diametro" value="<%= ficha.getDiamtero()%>" class="form-control" placeholder="Diam"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Grosor</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-equalizer"></i></span>
                                          <input type="text" id="grosor" name="grosor" value="<%=ficha.getGrosor()%>" class="form-control" placeholder="Grosor"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Peso</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-scale"></i></span>
                                          <input type="text" id="peso" name="peso" value="<%= ficha.getPeso()%>" class="form-control" placeholder="Peso"/>
                                    </div>
                                </div>
                         </div>  
                            <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Procendecia</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-plane"></i></span>
                                               <input type="text" id="procedencia" name="procedencia" value="<%= ficha.getProcedencia()%>" class="form-control" placeholder="Procendencia"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Condicion de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-exclamation-sign"></i></span>
                                               <input type="text" id="condicion" name="condicion" value="<%= ficha.getCondicion()%>" class="form-control" placeholder="Condicion "/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">Forma de Adquisici&oacute;n</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-warning-sign"></i></span>
                                               <input type="text" id="formaadquisicion" name="formaadquisicion" value="<%= ficha.getFormaAdquisicion()%>" class="form-control" placeholder="FormaAdquisicion"/>
                                         </div>
                                </div>
                         </div>
                             <div class="row">
                              <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Fecha de Adquisici&oacute;n</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="fechaadquisi" name="fechaadquisi" value="<%= ficha.getFAdquisicion()%>" class="form-control"/>
                                         </div>
                                </div>
                                 <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">R&eacute;gimen de propiedad</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-flag"></i></span>
                                               <input type="text" id="regimenpro" name="regimenpro" value="<%= ficha.getRegimen()%>" class="form-control" placeholder="Regimen"/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Custodio</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                               <input type="text" id="Custodio" name="Custodio" value="<%= ficha.getCustodio()%>" class="form-control" placeholder="Custodio" />
                                         </div>
                                </div>
                         </div>
                             <div class="row">
                              <div class="form-group col-md-6">
                                     <label for="name" class="cols-sm-3 control-label">Fecha de inventario</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="fechainv" name="fechainv" value="<%= ficha.getFInventario()%>" class="form-control"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-6">
                                     <label for="name" class="control-label">Realizado por</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                               <input type="text" id="realizadopor" name="realizadopor" value="<%= ficha.getRealizadoPor()%>" class="form-control"/>
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-12">
                                     <label for="name" class="control-label">Observaciones</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
                                               <textarea class="form-control" id="observaciones" name="observaciones"  style="color: black;" rows="2"><%= ficha.getObservaciones()%></textarea> 
                                         </div>
                                </div>
                         </div>
                                <input type="hidden" name="imagenes" value="<%=ficha.getImagenes()%>"/>  
                                <div class="row" id="fila_imagenes">
                                       <% 
                                           String imagenes[] = ficha.getImagenes().split(";");
                                           int i = 0;
                                           for(String imagen: imagenes){
                                      %>
                                       <div class="form-group col-md-3">
                                           <input type="file" id="files_<%= ++i%>" name="files_<%= i%>" />
                                             <br />
                                             <output id="list_<%= i%>"><img class="img img-rounded img-responsive" src="Imagenes/<%= ficha.getIdInventario() + "/" + imagen%>" width="250px"/></output>
                                       </div> 
                                       <% 
                                           }
                                       %>
                                       <a class="btn btn-xs" id="agregar_campo_imagen"><span class="glyphicon glyphicon-plus"></span></a>
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
            var i = <%= ++i%>;
          $(document).ready(function(){
              $("#agregar_campo_imagen").click(function(){
                  $("#fila_imagenes > a:last").before('<div class="form-group col-md-3"><input type="file" id="files_'+i+'" name="files_'+i+'" />' +
                                                      '<br />' +
                                                      '<output id="list_'+i+'"></output>' +
                                              '</div> ');
                                      i++;
              });
              /*$("#frm-actuapieza").submit(function(e){
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
              });*/
               $("#fila_imagenes").on("change","input[type=file]",function(e){
                    archivo(e, $(this).attr('id').split("_")[1]);
                });

          });
          
          function archivo(evt, id) {
                 var files = evt.target.files; // FileList object
                    //Obtenemos la imagen del campo "file". 
                   for (var i = 0, f; f = files[i]; i++) {         
           //Solo admitimos imágenes.
           if (!f.type.match('image.*')) {
                continue;
           }
       
           var reader = new FileReader();
           
           reader.onload = (function(theFile) {
               return function(e) {
                // Creamos la imagen.
                document.getElementById("list_"+ id).innerHTML =   ['<img class="img img-rounded img-responsive" width="250px" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
               };
           })(f);
 
           reader.readAsDataURL(f);
       }
}
      </script>
<jsp:include page="../common/footer.jsp"/>           