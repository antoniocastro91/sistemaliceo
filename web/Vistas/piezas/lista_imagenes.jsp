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
    Controlador.Inventario.ControladorInventario controladorIF = new ControladorInventario();
     List<Inventario>  lista_inventario = controladorIF.listar();
%>
<jsp:include page="../common/header.jsp"/>
<div class="container">
    <% for(int i = 0; i < lista_inventario.size(); i++){
        String imagenes[] = lista_inventario.get(i).getImagenes() != null ?  lista_inventario.get(i).getImagenes().split(";"): null;
        String imagen = imagenes != null ? imagenes[0] : "";
        if(lista_inventario.get(i).getDescripcion().length() > 50){
            lista_inventario.get(i).setDescripcion(lista_inventario.get(i).getDescripcion().substring(0, 50));
        }
    %>

        <div class="col-xs-12 col-sm-3 col-lg-2">
            <div class="card text-center">
                <img class="img" src="resources/imagenes/<%= lista_inventario.get(i).getIdInventario() + "/" + imagen%>" height="200px"/>
                <div class="contenido">
                    <h1><%=lista_inventario.get(i).getNombrePieza()%></h1>
                    <h3><%=lista_inventario.get(i).getNumInventario()%></h3>
                    <p><%=lista_inventario.get(i).getDescripcion()%></p>
                    
                </div>
                <div class="card-footer">
                    <a class="btn btn-info btn-block" style="border-radius: 0px;"  href="Vistas/piezas/Modificar.jsp?id_inventario=<%= lista_inventario.get(i).getIdInventario()%>">Detalles</a>
                </div>
            </div>
            
        </div>

    <%
    }
    %>
</div>
    <script>
        $(function () {
            $.each($('.card-footer'), function(){
                $(this).css("margin-top", ($(this).parent().height() - $(this).parent().find('img').height() - $(this).parent().find('.contenido').height()- $(this).outerHeight() - 10) + "px");
             });
            
        });


    </script>
<jsp:include page="../common/footer.jsp"/>