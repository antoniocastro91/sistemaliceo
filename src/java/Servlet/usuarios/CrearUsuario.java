/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.usuarios;

import java.io.IOException;
import Include.Usuario.Usuario;
import Controlador.Usuario.ControladorUsuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author antonio
 */
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
public class CrearUsuario extends HttpServlet {

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
       try{
        HttpSession sesion = request.getSession(true);
        String usu = sesion.getAttribute("usuario") == null ? "" : sesion.getAttribute("usuario").toString();
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
    
        
        response.setContentType("text/html;charset=UTF-8");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String email = request.getParameter("email");
        Integer estado = Integer.parseInt(request.getParameter("estado"));
	Integer nivel = Integer.parseInt(request.getParameter("nivel"));
	String usuariocreacion = usu;
	String fechacreacion = formateador.format(ahora);
     
        Usuario usuario1 = new Usuario(null, null,usuario, clave,email, estado, nivel,usuariocreacion, fechacreacion);
        Controlador.Usuario.ControladorUsuario cu = new ControladorUsuario();
        
        if(cu.insertar(usuario1)){
            response.getWriter().print("1");
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Vistas/usuarios/ListaUsuarios.jsp"));
        }else{
            response.getWriter().print("0");
        }
       }catch(Exception e){
           System.out.println("hubo error");
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
