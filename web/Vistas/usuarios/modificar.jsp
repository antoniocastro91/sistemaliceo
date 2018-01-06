<%@page import="Include.Usuario.Usuario"%>
<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 

    ControladorUsuario controladorUsuario = new ControladorUsuario();
    Usuario usuario = new Usuario();
    usuario = controladorUsuario.getUsuario(Integer.parseInt(request.getParameter("id_usuario").toString()));

%>
<jsp:include page="../common/header.jsp"/>
<div class="row main">
                <div class="main-login main-center">
                    <form class="" method="post" id="frm-registousuario" action="usuario_Modificar">
                         <h3 align="center">Formulario para la edicion de Usuarios.</h3>
                         <input type="hidden" name="id" id="id" value="<%= usuario.getId_usuario() %>"/>
                         <div class="row">
                             <div class="form-group col-md-6">
                                <label for="name" class="cols-sm-3 control-label">Seleccione el Rol del Usuario</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <select type="number" id="nivel" name="nivel" class="form-control">
                                        <option <% if(usuario.getNivel()== 1){ %> selected <% }%> value="1">Administrador</option>
                                        <option <% if(usuario.getNivel()== 2){ %> selected <% }%> value="2">Usuario</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                               <label for="name" class="control-label">Ingrese el Usuario</label>
                                       <div class="input-group">
                                           <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                                <input type="text" id="usuario" name="usuario" value="<%= usuario.getUsuario() %>" class="form-control" placeholder="Ingrese el Usuario"/>
                                       </div>
                           </div>
                         </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                     <label for="text" class="cols-sm-3 control-label">Ingrese el Estado del Usuario</label>
                                      <div class="input-group">
                                     <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <select type="number" id="estado" name="estado" class="form-control">
                                            <option <% if(usuario.getEstado()== 0){ %> selected <% }%> value="0">Inactivo</option>
                                            <option <% if(usuario.getEstado()== 1){ %> selected <% }%> value="1">Activo</option>
                                        </select>
                                      </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="name" class="control-label">Ingrese un correo electrónico</label>
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                                <input id="email" name="email" type="text" value="<%= usuario.getEmail()%>" class="form-control" placeholder="Ingrese un Correo"/>
                                            </div>
                                </div>
                        </div>
                        <div class="row">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" id="chk_clave" name="cambiar_clave"> Cambiar Clave
                                </label>
                              </div>
                            <div class="form-group col-md-6 hidden" id="div_clave">
                              <label for="clave" class="cols-sm-3 control-label">Ingrese la Contraseña</label>
                                 <div class="input-group">
                                             <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                             <input type="password" name="clave" id="clave" class="form-control" placeholder="Ingrese la Contraseña "/>
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
                                                <script>
                                                    $(document).ready(function(){
                                                        $("#frm-registousuario").submit(function(e){
                                                            e.preventDefault();
                                                            var data = $(this).serialize();
                                                            $.post('usuario_Modificar', data, function(res, est, jqXHR){
                                                                if(res == 'ok'){
                                                                    alert("usuario modificado correctamente");
                                                                    setTimeout(function(){
                                                                        window.location = "Vistas/usuarios/ListaUsuarios.jsp";   
                                                                    },100);
                                                                }else{
                                                                    alert("Ocurrio un error al modificar el usuario")
                                                                }
                                                            });
                                                        });
                                                        $('#chk_clave').change(function(){
                                                            console.log($(this))
                                                           if($(this)[0].checked){
                                                               console.log('checked');
                                                               $('#div_clave').removeClass('hidden');
                                                           } else{
                                                               console.log('unchecked');
                                                               $('#div_clave').addClass('hidden');
                                                           }
                                                        });
                                                    });
                                                </script>
<jsp:include page="../common/footer.jsp"/>