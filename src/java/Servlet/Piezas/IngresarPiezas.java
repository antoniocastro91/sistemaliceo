/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Piezas;

import Controlador.Inventario.ControladorInventario;
import Include.Inventario.Inventario;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Antonio Castro
 */
@MultipartConfig
@WebServlet(name = "IngresarPiezas", urlPatterns = {"/piezas_Ingresar"})
public class IngresarPiezas extends HttpServlet {
    private String UPLOAD_DIRECTORY = "";
    private static String nombre_imagen = "";
    private static String error = "";
    private static List<FileItem> imagenes = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            this.UPLOAD_DIRECTORY = this.getServletContext().getRealPath("Imagenes");
            Inventario inv = new Inventario();
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    inv = this.obtener_datos(request,inv, item.getFieldName(), item.getString());
                } else{
                    if(item.getName().length() > 0){
                        imagenes.add(item);
                        String img = inv.getImagenes() != null ? inv.getImagenes() + ";" +item.getName() : item.getName();
                        inv.setImagenes(img);
                    }
                }
            }
            
        HttpSession sesion = request.getSession(true);
        ControladorInventario  ci= new ControladorInventario();
        ci.setId_usuario(Integer.parseInt(sesion.getAttribute("id_usuario").toString()));
          
        if(ci.insertar(inv)){
            if(this.subir_imagen(imagenes, ci.ultimo_id_insertado)){
                response.getWriter().print("1");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Pieza Ingresada correctamente');");
                out.println("</script>");
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Vistas/piezas/lista.jsp"));
            }else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Pieza no isertada');");
                out.println("</script>");
                response.getWriter().print("0");
                out.print(this.error);
            }
        }else{
            response.getWriter().print("0");
            out.print(ci.error);
        }
       }catch(Exception e){
           response.getWriter().println("Error");
       }
        
    }
    
    private Inventario obtener_datos(HttpServletRequest request,Inventario i, String campo, String valor){
        HttpSession sesion = request.getSession(true);
        String usu = sesion.getAttribute("usuario") == null ? "" : sesion.getAttribute("usuario").toString();
        switch(campo){
            case "numinv":
                i.setNumInventario(valor);
                break;
            case "descrip":
                i.setDescripcion(valor);
                break;
            case "nombre":
                i.setNombrePieza(valor);
                break;
            case "forma":
                i.setForma(valor);
                break;
            case "material":
                i.setIdMaterial(Integer.parseInt(valor));
                break;
            case "tecnica":
                i.setIdTecnica(Integer.parseInt(valor));
                break;
            case "color":
                i.setColor(valor);
                break;
            case "periodo":
                i.setPeriodo(valor);
                break;
            case "clasificacion":
                i.setClasificacion(valor);
                break;
            case "alto":
                i.setAlto(valor);
                break;
            case "ancho":
                i.setAncho(valor);
                break;
            case "largo":
                i.setLargo(valor);
                break;
            case "diametro":
                i.setDiamtero(valor);
                break;
            case "grosor":
                i.setGrosor(valor);
                break;
            case "peso":
                i.setPeso(valor);
                break;
            case "procedencia":
                i.setProcedencia(valor);
                break;
            case "condicion":
                i.setCondicion(valor);
                break;
            case "formaadquisicion":
                i.setFormaAdquisicion(valor);
                break;
            case "regimenpro":
                i.setRegimen(valor);
                break;
            case "custodio":
                i.setCustodio(valor);
                break;
            case "fechaadquisi":
               try {
                i.setFAdquisicion(new SimpleDateFormat("yyyy-MM-dd").parse(valor)) ;
                } catch (Exception ex) {
                    
                }
                break;
            case "fechainv":
                try {
                i.setFInventario(new SimpleDateFormat("yyyy-MM-dd").parse(valor)) ;
                } catch (Exception ex) {
                    
                }
                break;
            case "realizadopor":
                i.setRealizadoPor(usu);
            case "observaciones":
                i.setObservaciones(valor) ;
                break;
        }
        return i;
    }
    
    private boolean subir_imagen(List<FileItem> imagenes, int id_pieza)throws ServletException, IOException {
        try{
            for(FileItem item : imagenes){
                if(!item.isFormField() && item.getName().length() > 0){
                    nombre_imagen = item.getName();
                    File filePath = new File(UPLOAD_DIRECTORY + File.separator + id_pieza);
                    if (!filePath.exists()) {
                        filePath.mkdirs();
                    }
                    item.write( new File(UPLOAD_DIRECTORY + File.separator + id_pieza + File.separator + nombre_imagen));
                }
            }
           //File uploaded successfully
            return true;
        } catch (Exception ex) {
            this.error = ex.getMessage();
           return false;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
