<%@page import="Controlador.Ficha.ControladorFicha"%>
<%@page import="Include.Ficha.Ficha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<% 

    Controlador.Ficha.ControladorFicha controladorFicha = new ControladorFicha();
    Ficha ficha = new Ficha();


%>
 <div class="container">
            <div class="row main">
                <div class="main-login main-center-inven">
                    <form class="" method="post" id="frm-registousuario" action="CrearFicha" enctype="multipart/form-data">
                         <h3 align="center">Formulario para el Registro de Inventario.</h3>
                         <div class="row">
                             <div class="form-group col-md-5">
                                     <label for="name" class="cols-sm-3 control-label">Inv Nº</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class=" glyphicon glyphicon-barcode"></i></span>
                                               <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Ingrese el numero de Inventario"/>
                                         </div>
                                </div>
                         </div>    
                         <div class="row">
                              <div class="form-group col-md-12">
                                     <label for="name" class="cols-sm-3 control-label">Descripcion</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
                                               <textarea style="color: black;" rows="2" cols="168">
                                                </textarea> 
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Nombre de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-font"></i></span>
                                               <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Forma de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-screenshot"></i></span>
                                               <input type="text" id="forma" name="forma" class="form-control" placeholder="Forma"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Material de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-tags"></i></span>
                                               <input type="text" id="material" name="material" class="form-control" placeholder="Material"/>
                                         </div>
                                </div>
                         </div>
                        <div class="row">
                              <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">T&eacute;cnica de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-text-width"></i></span>
                                               <input type="text" id="tecnica" name="tecnica" class="form-control" placeholder="Tecnica"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Color de la pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-adjust"></i></span>
                                               <input type="text" id="color" name="color" class="form-control" placeholder="Color"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Periodo de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="periodo" name="periodo" class="form-control" placeholder="Periodo"/>
                                         </div>
                                </div>
                         </div>
                         <div class="row">
                              <div class="form-group col-md-6">
                                  <label for="name" class="cols-sm-3 control-label">Clasificaci&oacute; de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-tasks"></i></span>
                                               <input type="text" id="clasificacion" name="clasificacion" class="form-control" placeholder="Clasificacion"/>
                                         </div>
                                </div>
                       
                               
                              <div class="form-group col-md-2">
                                  <label for="name" class="cols-sm-3 control-label">Alto</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-vertical"></i></span>
                                               <input type="text" id="alto" name="alto" class="form-control" placeholder="Alto"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Ancho</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-sound-stereo"></i></span>
                                               <input type="text" id="ancho" name="ancho" class="form-control" placeholder="Ancho"/>
                                         </div>
                                </div>
                               <div class="form-group col-md-2">
                                     <label for="name" class="control-label">Largo</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-option-horizontal"></i></span>
                                               <input type="text" id="periodo" name="periodo" class="form-control" placeholder="Largo"/>
                                         </div>
                                </div>
                               </div> 
                         <div class="row">
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Di&aacute;metro</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-modal-window"></i></span>
                                          <input type="text" id="diametro" name="diametro" class="form-control" placeholder="Diam"/>
                                    </div>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Grosor</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-equalizer"></i></span>
                                          <input type="text" id="grosor" name="grosor" class="form-control" placeholder="Grosor"/>
                                    </div>
                                </div>
                                    <div class="form-group col-md-2">
                                    <label for="name" class="control-label">Peso</label>
                                   <div class="input-group">
                                          <span class="input-group-addon"><i class="glyphicon glyphicon-scale"></i></span>
                                          <input type="text" id="peso" name="peso" class="form-control" placeholder="Peso"/>
                                    </div>
                                </div>
                         </div>  
                            <div class="row">
                              <div class="form-group col-md-4">
                                     <label for="name" class="cols-sm-3 control-label">Procendecia</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-plane"></i></span>
                                               <input type="text" id="procedencia" name="procedencia" class="form-control" placeholder="Procendencia"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-4">
                                     <label for="name" class="control-label">Condicion de la Pieza</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-exclamation-sign"></i></span>
                                               <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Condicion "/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">Forma de Adquisici&oacute;n</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-warning-sign"></i></span>
                                               <input type="text" id="formaadquisicion" name="formaadquisicion" class="form-control" placeholder="FormaAdquisicion"/>
                                         </div>
                                </div>
                         </div>
                             <div class="row">
                              <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Fecha de Adquisici&oacute;n</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="date" id="fechaadquisi" name="fechaadquisi" class="form-control"/>
                                         </div>
                                </div>
                                 <div class="form-group col-md-4">
                                  <label for="name" class="cols-sm-3 control-label">R&eacute;gimen de propiedad</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-flag"></i></span>
                                               <input type="text" id="regimenpro" name="regimenpro" class="form-control" placeholder="Regimen"/>
                                         </div>
                                </div>
                                  <div class="form-group col-md-4">
                                  <label for="name" class="control-label">Custodio</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                               <input type="text" id="Custodio" name="Custodio" class="form-control" placeholder="Custodio" />
                                         </div>
                                </div>
                         </div>
                             <div class="row">
                              <div class="form-group col-md-6">
                                     <label for="name" class="cols-sm-3 control-label">Fecha de inventario</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                               <input type="text" id="nombre" name="nombre" class="form-control"/>
                                         </div>
                                </div>
                              <div class="form-group col-md-6">
                                     <label for="name" class="control-label">Realizado por</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                               <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Ingrese el tipo de  Material"/>
                                         </div>
                                </div>
                         </div>
                        <div class="row">
                              <div class="form-group col-md-12">
                                     <label for="name" class="control-label">Observaciones</label>
                                        <div class="input-group">
                                               <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
                                               <textarea style="color: black;" rows="2" cols="168">
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
