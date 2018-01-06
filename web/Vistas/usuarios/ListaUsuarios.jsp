<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<jsp:include page="../common/header.jsp"/>
<%@page import="Include.Usuario.Usuario"%>
<%@page import="Controlador.Usuario.ControladorUsuario"%>
<% 
    ControladorUsuario controladorUsuario = new ControladorUsuario();
    List<Usuario> lista_usuarios = controladorUsuario.listar();
%>
<div class ="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Nivel</th>
                        <th>Estado</th>
                        <th>Email</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(int i = 0; i < lista_usuarios.size(); i++){
                    %>
                    <tr>
                        <td><%=lista_usuarios.get(i).getUsuario()%></td>
                        <td><%=lista_usuarios.get(i).getNivel()%></td>
                        <td>
                            <% if(lista_usuarios.get(i).getEstado() == 1) {%>
                                Activo
                            <% } else{%>
                                Inactivo
                            <% } %>
                        </td>
                        <td><%=lista_usuarios.get(i).getEmail()%></td>
                        <td>
                            <a class="btn btn-warning btn-xs" href="Vistas/usuarios/modificar.jsp?id_usuario=<%= lista_usuarios.get(i).getId_usuario() %>"><i class="glyphicon glyphicon-pencil"></i></a>
                            <button class="btn btn-danger btn-xs" onclick="eliminar_usuario(<%= lista_usuarios.get(i).getId_usuario() %>)"><i class="glyphicon glyphicon-trash"></i></button>
                        </td> 
                    </tr>
                    <%        
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
                    <script>
                        function eliminar_usuario(id_usuario){
                            var r = confirm("Esta seguro que desea eliminar el usuario?");
                            if (r === true) {
                                $.post('usuario_eliminar', {id:id_usuario}, function(respuesta){
                                   if(respuesta == 'ok'){
                                       window.location.reload();
                                   } else{
                                       alert("Ocurrio un error al intentar eliminar el usuario, por favor intente de nuevo")
                                   }
                                });
                            } else {
                                txt = "You pressed Cancel!";
                            }
                        }
                    </script>
<jsp:include page="../common/footer.jsp"/>