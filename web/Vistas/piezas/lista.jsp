<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%@page import="Include.Usuario.Usuario"%>
<%@page import="Controlador.Inventario.ControladorInventario"%>
<%@page import="Include.Inventario.Inventario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>

<% 
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
    Controlador.Inventario.ControladorInventario controladorIF = new ControladorInventario();
     List<Inventario>  lista_inventario = controladorIF.listar();
     Usuario user = null;
    ControladorUsuario cu = null;
     if(usuario != ""){
        cu = new ControladorUsuario();
        user = new Usuario(usuario.toString());
        user.setNivel(Integer.parseInt(session.getAttribute("nivel").toString()));
    }
%>
<jsp:include page="../common/header.jsp"/>
<div class ="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-hover table-striped">
                <thead >
                    <tr>
                        <th>Id_Inv</th>
                        <th>Nº Inv</th>
                        <th>Nombre</th>
                        <th>Forma</th>
                        <th>Material</th>
                        <th>Tecnica</th>
                        <th>Color</th>
                        <th>Periodo</th>
                        <th>Clasificacion</th>
                        <% 
                        if(user != null){
                        if (user.getNivel() == 1){ %>
                        <th>Opciones</th>
                           <% } 
                         }%>    
                    </tr>
                </thead>
                <tbody >
                    <%
                        for(int i = 0; i < lista_inventario.size(); i++){
                    %>
                    <tr>
                        <td><%=lista_inventario.get(i).getIdInventario()%></td>
                        <td><%=lista_inventario.get(i).getNumInventario()%></td>
                        <td><%=lista_inventario.get(i).getNombrePieza()%></td>
                        <td><%=lista_inventario.get(i).getForma()%></td>
                        <td><%=lista_inventario.get(i).getNombre_Material()%></td>
                        <td><%=lista_inventario.get(i).getNombre_Tecnica()%></td>
                        <td><%=lista_inventario.get(i).getColor()%></td>
                        <td><%=lista_inventario.get(i).getPeriodo()%></td>
                        <td><%=lista_inventario.get(i).getClasificacion()%></td>
                          <% 
                        if(user != null){
                        if (user.getNivel() == 1){ %>
                        <td>
                            <a class="btn btn-warning btn-xs" href="Vistas/piezas/Modificar.jsp?id_inventario=<%= lista_inventario.get(i).getIdInventario()%>"><i class="glyphicon glyphicon-pencil"></i></a>
                            <button class="btn btn-danger btn-xs" onclick="eliminar_pieza(<%= lista_inventario.get(i).getIdInventario()%>)"><i class="glyphicon glyphicon-trash"></i></button>
                        </td>
                            <% } 
                         }%>
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
                        function eliminar_pieza(id_pieza){
                            var r = confirm("Esta seguro que desea eliminar el usuario?");
                            if (r === true) {
                                $.post('eliminar_Piezas', {id:id_pieza}, function(respuesta){
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