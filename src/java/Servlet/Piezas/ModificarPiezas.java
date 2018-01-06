    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Piezas;

import Controlador.Ficha.ControladorFicha;
import Include.Ficha.Ficha;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio Castro
 */
@WebServlet(name = "ModificarPiezas", urlPatterns = {"/modificar_Piezas"})
public class ModificarPiezas extends HttpServlet {

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
           Controlador.Ficha.ControladorFicha controladorFicha= new ControladorFicha();
            Ficha u = new Ficha();
            
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String forma = request.getParameter("forma");
            String material = request.getParameter("material");
            String tecnica = request.getParameter("tecnica");
            String color = request.getParameter("color");
            String periodo = request.getParameter("periodo");
            String clasificacion = request.getParameter("clasificacion");            
            String alto = request.getParameter("alto");            
            String ancho = request.getParameter("ancho");            
            String largo = request.getParameter("largo");            
            String diametro = request.getParameter("diametro");            
            String grosor = request.getParameter("grosor");            
            String peso = request.getParameter("peso");
            String procedencia = request.getParameter("procedencia");
            String condicion = request.getParameter("condicion");
            String formaadquisi = request.getParameter("formaadquisicion");
            String fechaadquisi= request.getParameter("fechaadquisi");
            String regimen = request.getParameter("regimenpro");
            String custodio = request.getParameter("custodio");
            
            u.setNombre(nombre);
            u.setIdPieza(Integer.parseInt(id));
            u.setForma(forma);
            u.setMaterial(material);
            u.setTecnica(tecnica);
            u.setColor(color);
            u.setPeriodo(periodo);
            u.setClasificacion(clasificacion);
            u.setAlto(Double.parseDouble(alto));
            u.setAncho(Double.parseDouble(ancho));
            u.setLargo(Double.parseDouble(largo));
            u.setDiamtero(Double.parseDouble(diametro)); 
            u.setGrosor(Double.parseDouble(grosor));
            u.setPeso(Double.parseDouble(peso));
            u.setProcedencia(procedencia); 
            u.setCondicion(condicion);
            u.setFormaAdquisicion(formaadquisi);
            u.setFAdquisicion(fechaadquisi);
            u.setRegimen(regimen);
            u.setCustodio(custodio);

            if(controladorFicha.actualizar(u)){
                out.print("ok");
            }else{
                out.println("error");
                out.println(controladorFicha.error);
            }
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
