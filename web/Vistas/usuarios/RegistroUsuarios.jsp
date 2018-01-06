<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Include.Usuario.Usuario"%>
<%@page import="Controlador.Usuario.ControladorUsuario"%>
<% 

    ControladorUsuario controladorUsuario = new ControladorUsuario();
    Usuario usuario = new Usuario();


%>
<jsp:include page="../common/header.jsp"/>
            <div class="row main">
                <div class="main-login main-center">
                    <form class="" method="post" id="frm-registousuario" action="CrearUsuario">
                         <h3 align="center">Formulario para el Registro de Usuarios.</h3>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="name" class="cols-sm-3">Ingrese el Usuario</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Ingrese el Usuario"/>
                                    </div>
                                  </div>
                            <div class="form-group col-md-6">
                               <label for="name" class="control-label">Ingrese la Contraseña</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="password" name="clave" id="password" class="form-control" placeholder="Ingrese la Contraseña "/>
                                    </div>
                            </div>
                        </div>
                          
                        <div class="row">
                            <div class="form-group col-md-6">
                               <label for="name" class="control-label">Ingrese un correo electrónico</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input  id="email" name="email" type="text" class="form-control" placeholder="Ingrese un Correo"/>
                                    </div>
                           </div>
                            <div class="form-group col-md-6">
                                 <label for="name" class="cols-sm-3 control-label">Ingrese el Estado del Usuario</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <select type="number" id="estado" name="estado" class="form-control">
                                            <option <% if(usuario.getEstado()== 0){ %> selected <% }%> value="0">Inactivo</option>
                                            <option <% if(usuario.getEstado()== 1){ %> selected <% }%> value="1">Activo</option>
                                        </select>
                                    </div>
                            </div>
                        </div>
                                <div class="row">
                                 <div class="form-group col-md-6">
                                    <label for="text" class="cols-sm-3 control-label">Ingrese el Nivel del Usuario</label>
                                      <div class="input-group">
                                     <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <select type="number" id="nivel" name="nivel" class="form-control">
                                                  <option <% if(usuario.getNivel()== 1){ %> selected <% }%> value="1">Administrador</option>
                                                  <option <% if(usuario.getNivel()== 2){ %> selected <% }%> value="2">Usuario</option>
                                            </select>
                                      </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="text" class="control-label">Usuario Creación</label>
                                       <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" name="usucrea" id="usucrea" class="form-control" placeholder="Ingrese el usuario de creacion"/>
                                        </div>
                                   </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6">
                                       <label for="date" class="cols-sm-3 control-label">Fecha de Creacion</label>
                                           <div class="input-group">
                                               <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                               <input type="date" name="fechacrea" id="fechacrea" class="form-control"/>
                                            </div>
                                   </div>
                                </div>
                            
                               <div class="row">
                                    <div class="form-group ">
                                        <button type="submit" id="btn-registro" class="btn btn-primary btn-lg btn-block login-button">Ingresar</button>
                                    </div> 
                               </div>
                    </form>
                </div>
            </div>
        
<jsp:include page="../common/footer.jsp"/>