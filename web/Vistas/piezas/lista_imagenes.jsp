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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <img class="img" src="Imagenes/<%= lista_inventario.get(i).getIdInventario() + "/" + imagen%>" height="200px"/>
                <div class="contenido">
                    <h1><%=lista_inventario.get(i).getNombrePieza()%></h1>
                    <h3><%=lista_inventario.get(i).getNumInventario()%></h3>
                    <p style="font-size:12px; "><%=lista_inventario.get(i).getDescripcion()%></p>
                </div>
                    <div class="card-footer">
                    <!--<a class="btn btn-info btn-block" style="border-radius: 0px;"  href="Vistas.jsp?id_inventario=">Detalles</a> -->
                        <button class="btn btn-info btn-block" style="border-radius: 0px;" onclick="verdetalle('<%= lista_inventario.get(i).getIdInventario()%>')" >Ver detalle </button>
                   </div>
                </div>
            </div>
           <%
              }
           %>         
              
                     <div  class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
                                    </button>
                                    <h4 class="modal-title text-center"  id="myModalLabel" >INFORMACI&Oacute;N DE LA PIEZA</h4>
                                </div>
                                
                                <div class="modal-body text-center" >
                                    <div id="img" ></div>
                                    <h4 id="numeinv" align="center">Numero Inventario </h4>
                                    <p id="nombre" align="left"></p>
                                    <p id="forma" align="left">Forma</p>
                                    <p id="material" align="left">Material</p>
                                    <p id="descrip" align="justify">Descripcion</p>
                                </div>
                            </div>
                        </div>
                    </div>
</div>
 
                            
    <script>
        $(function () {
            $.each($('.card-footer'), function(){
                $(this).css("margin-top", ($(this).parent().outerHeight() - $(this).parent().find('img').outerHeight() - $(this).parent().find('.contenido').outerHeight()- $(this).outerHeight() - 10) + "px");
             });
            
        });
        function verdetalle(id_inventario){
            $.get('Piezas_Detalle', {id:id_inventario}, function(respuesta){
                respuesta=JSON.parse(respuesta);
                var imagen= respuesta.Imagen.split(";");
                if(imagen[0]!=""){
                    imagen = imagen[0];
                    var src = "<img width='250px' src='Imagenes/" + respuesta.IdInventario+ "/"+ imagen +"'/>";
                    $("#img").html(src);
                }else{
                    imagen = "";
                    $("#img").html("");
                }
                
                $("#numeinv").html("<b>Numero de Inventario: </b>" + respuesta.NumInventario);
                $("#nombre").html("<b>Nombre :</b>" + respuesta.Nombre);
                $("#forma").html("<b>Forma </b>:" + respuesta.Forma);
                $("#material").html("<b>Material :</b>" + respuesta.Material);
                $("#descrip").html("<b>Descripcion: </b>"+ respuesta.Descripcion);
                    $("#miModal").modal("show");
            });
        }
    </script>
<jsp:include page="../common/footer.jsp"/>