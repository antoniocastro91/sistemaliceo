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
       String usuario = request.getParameter("usuario");
       String clave = request.getParameter("clave");
       PrintWriter out = response.getWriter();
       Usuario u = new Usuario(usuario, clave);
       ControladorUsuario cu = new ControladorUsuario();
       Conexion cn = new Conexion();
       if(cu.validar(u)){
            HttpSession sesion = request.getSession(true);
            switch(cn.loguear(usuario, clave))
            {
                case 1:
                       sesion.setAttribute("usuario", usuario); 
                       sesion.setAttribute("nivel", 1);
                       response.getWriter().print("principal");
                break;
                case 2:
                        sesion.setAttribute("usuario", usuario);
                        sesion.setAttribute("nivel",2);
                        response.getWriter().print("principal");
                break;        
                case 3:
                   sesion.setAttribute("usuario", usuario);
                   sesion.setAttribute("nivel", 3);
                   response.getWriter().print("lista_imagenes");
                break;  
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