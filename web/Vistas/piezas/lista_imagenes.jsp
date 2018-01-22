<%@page import="Modelo.Materiales.ModeloMateriales"%>
<%@page import="Include.Materiales.Materiales"%>
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
    List<Inventario>  lista_inventario;
    String nombre_pieza = "";
    int filtro_tipo = 0;
    int total_registros = 0;
    int limite = 20;
    int pagina_actual = 0;
    if(request.getParameter("filtro_tipo")!= null){
        String[] filtros = new String[4];
        filtros[0] = request.getParameter("filtro_tipo");
        filtros[1] = request.getParameter("nombre_pieza");
        filtros[2] = request.getParameter("limite");
        filtros[3] = request.getParameter("pagina_actual");
        
        filtro_tipo = Integer.parseInt(filtros[0]);
        nombre_pieza = filtros[1];
        limite = Integer.parseInt(filtros[2]);
        pagina_actual = Integer.parseInt(filtros[3]);
        
        controladorIF.setInicio(limite*pagina_actual);
        controladorIF.setTotal_mostrar(limite);
        
        if(Integer.parseInt(filtros[0])>0){
            lista_inventario = controladorIF.listar(filtros);
            total_registros = controladorIF.total_registros(filtros);
        }else{
            lista_inventario = controladorIF.listar();
            total_registros = controladorIF.total_registros();
        }
    }else{
        lista_inventario = controladorIF.listar();
        total_registros = controladorIF.total_registros();
    }
    total_registros /= limite;
    ModeloMateriales material = new ModeloMateriales();
     List<Materiales>  lista_materiales = material.listar_materiales();
      
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<div class="container">
    <div class="row">
        <form action="Vistas/piezas/lista_imagenes.jsp" >
            <input type="hidden" name="pagina_actual" value="0">
            <div class="col-xs-12 col-md-3">
                <label for="limite">Por Pagina</label>
                <select name="limite" id="filtro_tipo" class="form-control">
                    <option value="20" <%= limite==20 ?"selected": "" %>>20</option>
                    <option value="50" <%= limite==50 ?"selected": "" %>>50</option>
                    <option value="100" <%= limite==100 ?"selected": "" %>>100</option>
                </select>
            </div>
                <div class="col-xs-12 col-md-3">
                <label for="filtro_tipo">Tipo de Material</label>
                <select name="filtro_tipo" id="filtro_tipo" class="form-control">
                    <option value="0">Seleccione una opción</option>
                    <%
                        for(int i=0;i<lista_materiales.size();i++){%>
                        <option value="<%= lista_materiales.get(i).getIdMaterial() %>" <%= filtro_tipo ==  lista_materiales.get(i).getIdMaterial() ? "selected": ""%>><%= lista_materiales.get(i).getMaterial() %></option>
                    <%    }   %>
                </select>
            </div>
                <div class="col-xs-12 col-md-3">
                    <label for="">Busqueda</label>
                    <input type="text" class="form-control" name="nombre_pieza">
                </div>
                <div class="col-xs-12 col-md-1">
                    <label for="" style="color:transparent">a</label>
                    <button class="btn btn-block" id="btn-busqueda">
                        <i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
        </form>
    </div>
        
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
              
            if(total_registros>0){
           %>
           
           <div class="row">
               <div class="col-xs-12">
                   <nav aria-label="Page navigation">
                    <ul class="pagination">
                      <li>
                        <a href="Vistas/piezas/lista_imagenes.jsp?pagina_actual=0&limite=<%= limite%>&filtro_tipo=<%= filtro_tipo%>&nombre_pieza=<%= nombre_pieza%>" aria-label="Previous">
                          <span aria-hidden="true">&laquo;</span>
                        </a>
                      </li>
                      <% for(int i= 0; i<total_registros;i++){ %>
                      <li class="<%= i==pagina_actual?"active":""%>" ><a href="Vistas/piezas/lista_imagenes.jsp?pagina_actual=<%= i%>&limite=<%= limite%>&filtro_tipo=<%= filtro_tipo%>&nombre_pieza=<%= nombre_pieza%>"><%= i+1 %></a></li>
                      <% } %>
                      <li>
                        <a href="Vistas/piezas/lista_imagenes.jsp?pagina_actual=<%= total_registros-1%>&limite=<%= limite%>&filtro_tipo=<%= filtro_tipo%>&nombre_pieza=<%= nombre_pieza%>" aria-label="Next">
                          <span aria-hidden="true">&raquo;</span>
                        </a>
                      </li>
                    </ul>
                  </nav>
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
            $("#btn-busqueda").click(function(){
                
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
                $("#nombre").html("<b   >Nombre :</b>" + respuesta.Nombre);
                $("#forma").html("<b>Forma </b>:" + respuesta.Forma);
                $("#material").html("<b>Material :</b>" + respuesta.Material);
                $("#descrip").html("<b>Descripcion: </b>"+ respuesta.Descripcion);
                    $("#miModal").modal("show");
            });
        }
    </script>
<jsp:include page="../common/footer.jsp"/>