<%@page import="Controlador.Usuario.ControladorUsuario"%>
<%
    HttpSession sesion = request.getSession(false);
    String usuario = sesion.getAttribute("usuario") == null ? "" : sesion.getAttribute("usuario").toString();
    String url = response.encodeRedirectURL(request.getContextPath() + "/Vistas/Principal/login.jsp");
    if(usuario == ""){
        response.sendRedirect(url);
        return;
    }
 
    ControladorUsuario controladorUsuario = new ControladorUsuario();
    controladorUsuario.setId_usuario(Integer.parseInt(session.getAttribute("id_usuario").toString()));
%>
<jsp:include page="../common/header.jsp"/>
    <div class="container">
	<!-- carousel -->
            <div class="row">
                    <div class="col-xs-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                      <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                      <div class="item active">
                          <img src="resources/imagenes/carousel/3.jpg" alt="...">
                      </div>
                      <div class="item">
                          <img src="resources/imagenes/carousel/4.jpg" alt="...">
                      </div>
                      <div class="item">
                          <img src="resources/imagenes/carousel/5.jpg" alt="...">
                      </div>
                      <div class="item">
                          <img src="resources/imagenes/carousel/6.jpg" alt="...">
                      </div>
                      <div class="item">
                          <img src="resources/imagenes/carousel/7.jpg" alt="...">
                      </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                    </a>
                  </div>
                    </div>
            </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="card text-white bg-info mb-10">
                    <div class="card-header"><b>RESEÑA HIST&Oacute;RICA</b></div><br>
                    <div class="card-body">
                        <p class="card-text" align="justify">
                            El Museo Nacional de Antropología fue creado por Decreto Ejecutivo el 1 de febrero de 1883 y fundado el 9 de octubre del mismo año. Inició su funcionamiento en las instalaciones del antiguo edificio de la Universidad Nacional; en 1902 fue trasladado a la Villa España y se decretó una segunda regulación que lo definiría como un museo científico, industrial y de agricultura; desde 1904 hasta 1911, las instalaciones del museo estaban ubicadas en la finca Modelo, ahora Zoológico Nacional, pero en ese mismo año se ordenó su primer cierre; en 1927, el museo fue trasladado a los pabellones que anteriormente fueron utilizados por el Hospital Militar, y, en 1942, el museo se traslada hacia su ubicación actual en la avenida Revolución, frente a la entonces Feria Internacional, hoy Centro Internacional de Ferias y Convenciones (CIFCO).
                        </p>
                    </div>
                    <div class="card-body">
                        <p class="card-text" align="justify">
                            El Museo Nacional de Antropología Dr. David J. Guzmán se dedica a administrar y promover una colección de objetos creados <img class="img-responsive" src="resources/imagenes/MUNA_01.jpg" width="12%" height="12%" style=" float:right;"> por las culturas en el territorio nacional, con el fin de brindar este legado como un patrimonio cultural de las generaciones pasadas, actuales y futuras.
                            El Museo Nacional es concebido como un medio de educación permanente para todos los sectores sociales del país, dado que su misión es la de propiciar el acercamiento y reflexión de los salvadoreños a su identidad y diversidad cultural, por medio de exposiciones permanentes, itinerantes y temporales, así como de investigaciones, publicaciones y programas didácticos en los campos de la Arqueología, la Antropología y la Historia, como testimonio de los procesos sociales de los diferentes grupos humanos que habitaron y habitan a lo largo y ancho del territorio nacional.</p>
                    </div>
                </div>
            </div>
        </div>
</div>
<jsp:include page="../common/footer.jsp"/>