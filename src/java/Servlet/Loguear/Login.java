/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Loguear;

import Controlador.Usuario.ControladorUsuario;
import Include.Usuario.Usuario;
import Modelo.Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
       PrintWriter out = response.getWriter();
      
       String usuario = request.getParameter("usuario");
       String clave = request.getParameter("clave");
       Usuario u = new Usuario(usuario, clave);
       Conexion cn = new Conexion();
        HttpSession sesion = request.getSession(true);
        Controlador.Usuario.ControladorUsuario cu = new ControladorUsuario();
      
       if(cu.validar(u)){
           //sesion.removeValue("id_usuario");
            
            Usuario usu = cn.loguear(usuario, clave);
            sesion.setAttribute("usuario", usu.getUsuario()); 
            sesion.setAttribute("nivel", usu.getNivel());
            sesion.setAttribute("id_usuario", usu.getId_usuario());
            if(usu.getUsuario() != null){
                  cu.setId_usuario(Integer.parseInt(sesion.getAttribute("id_usuario").toString()));
                cu.crear_log("El siguiente usuario ha iniciadio sesion " + sesion.getAttribute("usuario"));
                response.getWriter().print("ok");
               
            }else{
                response.getWriter().print("error");
            }
       }else {
           response.getWriter().print("error");
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
