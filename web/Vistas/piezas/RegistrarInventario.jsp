<%@page import="Include.Tecnicas.Tecnicas"%>
<%@page import="Modelo.Tecnicas.ModeloTecnicas"%>
<%@page import="Include.Materiales.Materiales"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Materiales.ModeloMateriales"%>
<%@page import="Modelo.Conexion.Conexion"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Conexion con = new Conexion();
    HttpSession sesion = request.getSession(true);
    String usuario = sesion.getAttribute("usuario") == null ? "" : sesion.getAttribute("usuario").toString();
    String url = response.encodeRedirectURL(request.getContextPath() + "/Vistas/Principal/login.jsp");
    if(usuario == ""){
        response.sendRedirect(url);
        return;
    }
    Object nivel = sesion.getAttribute("nivel") == null ? null : sesion.getAttribute("nivel");
    if (Integer.parseInt(nivel.toString()) == 3){
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Vistas/Principal/principal.jsp"));
    }
    ModeloMateriales mm = new ModeloMateriales();
    List<Materiales> lista_mat = mm.listar_materiales();
    
    ModeloTecnicas mt = new ModeloTecnicas();
    List<Tecnicas> lista_tec = mt.listar_tecnicas();
%> 
<jsp:include page="../common/header.jsp"/>
 <div class="container">
            <div class="row main">
                <div class="main-ficha main-center-inven">
                    <form class="" method="post" id="frm-registropieza" action="piezas_Ingresar" enctype="multipart/form-data">
                         <h3 align="center">Formulario para el Registro de Inventario.</h3>
                         
                         <div class="row">
                             <div class="form-group col-md-5">
                                     <label for="name" class="cols-sm-3 control-label">Inv Nº</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class=" glyphicon glyphicon-barcode"></i></span>
                                               <input type="text" id="numinv" name="numinv" class="form-control" required="" placeholder="Ingrese el numero de Inventario"/>
                                         </div>
                                </div>
                         </div>    
                         <div class="row">
                              <div class="form-group col-md-12">
                                     <label for="name" class="cols-sm-3 control-label">Descripcion</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
                                               <textarea id="descrip" name="descrip" required=""  style="color: black;" rows="2" cols="168"></textarea> 
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Nombre de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-font"></i></span>
                                               <input type="text" id="nombre" required="" name="nombre" class="form-control" placeholder="Nombre"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Forma de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-screenshot"></i></span>
                                               <input type="text" id="forma" required="" name="forma" class="form-control" placeholder="Forma"/>
                                         </div>
                                </div>

                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Material de la Pieza</label>
                                        <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-screenshot"></i></span>
                                                 <select type="text" id="material" name="material" required="" class="form-control">
                                                    <option selected > Seleccione el Material</option>
                                                        <% for(int i=0; i < lista_mat.size(); i++ ){ %>
                                                          <option value="<%=lista_mat.get(i).getIdMaterial()%>"><%= lista_mat.get(i).getMaterial()%></option>
                                                       <% } %>
                                                 </select>
                                         </div>
                                </div>
                         </div>
                        <div class="row">
                              <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">T&eacute;cnica de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-text-width"></i></span>
                                               <select type="text" id="tecnica" required="" name="tecnica" class="form-control">   
                                               <option selected > Seleccione la Tecnica</option>
                                                    <% for(int i=0; i < lista_tec.size(); i++ ){ %>
                                                          <option value="<%=lista_tec.get(i).getIdTecnica()%>"><%= lista_tec.get(i).getTecnica()%></option>
                                                    <% } %>
                                                 </select>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Color de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-adjust"></i></span>
                                               <input type="text" id="color" required="" name="color" class="form-control" placeholder="Color"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Periodo de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="periodo" required="" name="periodo" class="form-control" placeholder="Periodo"/>
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-6">
                                  <label for="name" class="cols-sm-3 control-label">Clasificaci&oacute; de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-tasks"></i></span>
                                               <input type="text" id="clasificacion"  name="clasificacion" class="form-control" placeholder="Clasificacion"/>
                                         </div>
                                </div>
                       
                               
                              <div class="form-group col-md-2">
                                  <label for="name" class="cols-sm-3 control-label">Alto</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-vertical"></i></span>
                                               <input type="text" id="alto" required="" name="alto" class="form-control" placeholder="Alto"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Ancho</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-sound-stereo"></i></span>
                                               <input type="text" id="ancho" required="" name="ancho" class="form-control" placeholder="Ancho"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Largo</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-horizontal"></i></span>
                                               <input type="text" id="largo" required="" name="largo" class="form-control" placeholder="Largo"/>
                                         </div>
                                </div>
                               </div> 
                         <div class="row">
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Di&aacute;metro</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-modal-window"></i></span>
                                          <input type="text" id="diametro" required="" name="diametro" class="form-control" placeholder="Diam"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Grosor</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-equalizer"></i></span>
                                          <input type="text" id="grosor" required="" name="grosor" class="form-control" placeholder="Grosor"/>
                                    </div>
                                </div>
                                    <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Peso</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-scale"></i></span>
                                          <input type="text" id="peso" required="" name="peso" class="form-control" placeholder="Peso"/>
                                    </div>
                                </div>
                         </div>  
                            <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Procendecia</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-plane"></i></span>
                                               <input type="text" id="procedencia" required="" name="procedencia" class="form-control" placeholder="Procendencia"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Condicion de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-exclamation-sign"></i></span>
                                               <input type="text" id="condicion" required="" name="condicion" class="form-control" placeholder="Condicion "/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">Forma de Adquisici&oacute;n</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-warning-sign"></i></span>
                                               <input type="text" id="formaadquisicion" required="" name="formaadquisicion" class="form-control" placeholder="FormaAdquisicion"/>
                                         </div>
                                </div>
                         </div>
                             <div class="row">
                              <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Fecha de Adquisici&oacute;n</label>
                                  <div class="input-group date" >
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="fechaadquisi" required="" name="fechaadquisi" class="form-control"/>
                                         </div>
                                </div>
                                 
                                 <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">R&eacute;gimen de propiedad</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-flag"></i></span>
                                               <input type="text" id="regimenpro" required="" name="regimenpro" class="form-control" placeholder="Regimen"/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Custodio</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                               <input type="text" id="custodio" required="" name="custodio" class="form-control" placeholder="Custodio" />
                                         </div>
                                </div>
                         </div>
                             <div class="row">
                              <div class="form-group col-md-6">
                                     <label for="name" class="cols-sm-3 control-label">Fecha de inventario</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="fechainv" required="" name="fechainv" class="form-control"/>
                                         </div>
                                </div>
                              <div style="display:none;" class="form-group col-md-6">
                                     <label type="hidden" for="name" class="control-label">Realizado por</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                               <input type="hidden" id="realizadopor" name="realizadopor" class="form-control" placeholder="Ingrese el tipo de  Material"/>
                                         </div>
                                </div>
                         </div>
                        <div class="row">
                              <div class="form-group col-md-12">
                                     <label for="name" class="control-label">Observaciones</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
                                               <textarea  id="observaciones" required="" name="observaciones" style="color: black;" rows="2" cols="168">
                                                </textarea> 
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                             <div class="form-group col-md-3">
                                    <input type="file" id="files" name="files[]" />
                                    <br />
                                    <output id="list"></output>
                            </div> 
                              <div class="form-group col-md-3">
                                    <input type="file" id="filesb" name="filesb[]" />
                                    <br />
                                    <output id="listb"></output>
                            </div> 
                              <div class="form-group col-md-3">
                                    <input type="file" id="filesc" name="files[]" />
                                    <br />
                                    <output id="listc"></output>
                            </div> 
                              <div class="form-group col-md-3">
                                    <input type="file" id="filesd" name="files[]" />
                                    <br />
                                    <output id="listd"></output>
                            </div> 
                         </div>   
                         <div class="row">
                              <div class="form-group col-md-12">
                                  <button type="submit" id="btn-registro" class="btn btn-primary btn-lg btn-block login-button">Ingresar</button>
                              </div>
                         </div>
                         
                    </form>
                </div>
            </div>
 </div>
        <script>
            function archivo(evt) {
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
               if($(evt.currentTarget).attr("id") == "files"){
                   document.getElementById("list").innerHTML =   ['<img class="thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
               }
               if($(evt.currentTarget).attr("id") == "filesb"){
                   document.getElementById("listb").innerHTML =   ['<img class="thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
               }
               if($(evt.currentTarget).attr("id") == "filesc"){
                   document.getElementById("listc").innerHTML =   ['<img class="thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
               }
               if($(evt.currentTarget).attr("id") == "filesd"){
                   document.getElementById("listd").innerHTML =   ['<img class="thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
               }
                      
               };
           })(f);
 
           reader.readAsDataURL(f);
       }
}
            //document.getElementById('files').addEventListener('change', archivo, false);
            $(document).ready(function(){
          $("input[type=file]").change(function(e){
              archivo(e);
          });
      });
        </script>
<jsp:include page="../common/footer.jsp"/>
