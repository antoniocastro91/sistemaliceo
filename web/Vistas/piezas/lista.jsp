<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<jsp:include page="../common/header.jsp"/>
<%@page import="Include.Ficha.Ficha"%>
<%@page import="Controlador.Ficha.ControladorFicha"%>
<% 
    ControladorFicha controladorIF = new ControladorFicha();
    List<Ficha> lista_fichas = controladorIF.listar();
%>
<div class ="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Forma</th>
                        <th>Material</th>
                        <th>Tecnica</th>
                        <th>Color</th>
                        <th>Periodo</th>
                        <th>Peso</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(int i = 0; i < lista_fichas.size(); i++){
                    %>
                    <tr>
                        <td><%=lista_fichas.get(i).getNombre()%></td>
                        <td><%=lista_fichas.get(i).getForma()%></td>
                        <td><%=lista_fichas.get(i).getMaterial()%></td>
                        <td><%=lista_fichas.get(i).getTecnica()%></td>
                        <td><%=lista_fichas.get(i).getColor()%></td>
                        <td><%=lista_fichas.get(i).getPeriodo()%></td>
                        <td><%=lista_fichas.get(i).getPeso()%></td>
                        <td>
                            <a class="btn btn-warning btn-xs" href="Vistas/piezas/RegistrarFicha.jsp?id_pieza=<%= lista_fichas.get(i).getIdPieza() %>"><i class="glyphicon glyphicon-pencil"></i></a>
                            <button class="btn btn-danger btn-xs" onclick="eliminar_pieza(<%= lista_fichas.get(i).getIdPieza()%>)"><i class="glyphicon glyphicon-trash"></i></button>
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