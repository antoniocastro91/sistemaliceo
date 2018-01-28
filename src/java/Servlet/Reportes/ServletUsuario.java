/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Reportes;

import Controlador.Usuario.ControladorUsuario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Antonio Castro
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {
    
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
            HttpSession sesion = request.getSession(true);
            ControladorUsuario cu = new ControladorUsuario();
            cu.setId_usuario(Integer.parseInt(sesion.getAttribute("id_usuario").toString()));
            cu.crear_log("Consultó el Reporte del Usuario con el siguiente dato: " + request.getParameter("txtusuario"));
           
            boolean consultar =  Boolean.parseBoolean(request.getParameter("consultar"));
            if(consultar){
                 this.consultar(request, response);
            }else{
                this.mostrarPdf(request, response);
            }
   }           
           protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            response.setContentType("text/html;charset=UTF-8"); 
            String nombreusuario = request.getParameter("txtusuario");
            String btnbuscartodos = request.getParameter("btnbuscartodos");
                try {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null; 
                Class.forName("com.mysql.jdbc.Driver");
                con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemmuna", "root", "root");
                st = con.createStatement();
                
               if(nombreusuario == nombreusuario && btnbuscartodos == ""){
                rs = st.executeQuery("select usuario, email, IF(estado = 1, 'Act','Inac') as Estado, IF (nivel = 1 ,'Admin', IF (nivel = 2, 'Usuario' , 'Invitado')) as Nivel, usuariocreacion,DATE_FORMAT(fechacreacion,\"%d-%m-%Y\") ,DATE_FORMAT(fechamodificacion,\"%d-%m-%Y\") from usuario order by usuario");
                }
                 if(btnbuscartodos == ""){
                rs = st.executeQuery("select usuario, email, IF(estado = 1, 'Act','Inac') as Estado, IF (nivel = 1 ,'Admin', IF (nivel = 2, 'Usuario' , 'Invitado')) as Nivel, usuariocreacion,DATE_FORMAT(fechacreacion,\"%d-%m-%Y\") ,DATE_FORMAT(fechamodificacion,\"%d-%m-%Y\") from usuario order by usuario");
                } 
                if(nombreusuario == nombreusuario){
                rs = st.executeQuery("select usuario, email, IF(estado = 1, 'Act','Inac') as Estado, IF (nivel = 1 ,'Admin', IF (nivel = 2, 'Usuario' , 'Invitado')) as Nivel, usuariocreacion, DATE_FORMAT(fechacreacion,\"%d-%m-%Y\") ,DATE_FORMAT(fechamodificacion,\"%d-%m-%Y\") from usuario Where usuario = '"+nombreusuario+"'");
                }

                if (con != null){     
                    
                    int total = 0;
                    while (rs.next()){
                       //Obtienes la data que necesitas...
                       total++;
                    }
                    if(total >= 0 ){
                       response.getWriter().print("ok");
                    }else{
                       response.getWriter().print("error");
                    }
                } 
                } catch (Exception e) {
                        response.getWriter().print("error");
                }          
           
           }
           
           protected void mostrarPdf (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            response.setContentType("application/pdf");
            OutputStream out = response.getOutputStream();
            String nombreusuario = request.getParameter("txtusuario");
            String btnbuscartodos = request.getParameter("btnbuscartodos");
                try {
                    try {
                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null; 
                     Class.forName("com.mysql.jdbc.Driver");
                     con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemmuna", "root", "root");
                     st = con.createStatement();
               if(nombreusuario == nombreusuario && btnbuscartodos == ""){
                rs = st.executeQuery("select usuario, email, IF(estado = 1, 'Act','Inac') as Estado, IF (nivel = 1 ,'Admin', IF (nivel = 2, 'Usuario' , 'Invitado')) as Nivel, usuariocreacion,DATE_FORMAT(fechacreacion,\"%d-%m-%Y\") ,DATE_FORMAT(fechamodificacion,\"%d-%m-%Y\") from usuario order by usuario");
                }
                 if(btnbuscartodos == ""){
                rs = st.executeQuery("select usuario, email, IF(estado = 1, 'Act','Inac') as Estado, IF (nivel = 1 ,'Admin', IF (nivel = 2, 'Usuario' , 'Invitado')) as Nivel, usuariocreacion,DATE_FORMAT(fechacreacion,\"%d-%m-%Y\") ,DATE_FORMAT(fechamodificacion,\"%d-%m-%Y\") from usuario order by usuario");
                } 
                if(nombreusuario == nombreusuario){
                rs = st.executeQuery("select usuario, email, IF(estado = 1, 'Act','Inac') as Estado, IF (nivel = 1 ,'Admin', IF (nivel = 2, 'Usuario' , 'Invitado')) as Nivel, usuariocreacion, DATE_FORMAT(fechacreacion,\"%d-%m-%Y\") ,DATE_FORMAT(fechamodificacion,\"%d-%m-%Y\") from usuario Where usuario = '"+nombreusuario+"'");
                }             
                
                    if (con != null){
                    try {
                         Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                documento.open(); 
               
                Paragraph par1 = new Paragraph();
                Image imagen1 = Image.getInstance("C:\\Users\\Antonio Castro\\Documents\\Sistema\\SistemMuna\\web\\resources\\imagenes\\cabecera.jpg");
                imagen1.setAlignment(Element.ALIGN_CENTER);
                imagen1.scaleToFit(1120, 130);
                documento.add(imagen1);
                documento.add(par1);
                
                Paragraph par2 = new Paragraph();
                Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLACK);
                par2.add(new Phrase("Reporte General de Usuarios:", fondescrip));
                par2.add("\n");
                par2.add("\n");
                documento.add(par2);
                
             
                
                PdfPTable tabla = new PdfPTable(7);      
                tabla.setWidthPercentage(100);
                float[] medidaCeldas = {3.00f,5.00f, 2.80f, 2.20f,  3.80f, 3.80f, 3.80f};
                PdfPCell celda1 = new PdfPCell(new Paragraph("Usuario", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK))); 
                celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda1.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda2 = new PdfPCell(new Paragraph("Email", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK))); 
                celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda2.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda3 = new PdfPCell(new Paragraph("Estado", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK))); 
                  celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
                  celda3.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda4 = new PdfPCell(new Paragraph("Rol", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK)));
                  celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
                  celda4.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda5 = new PdfPCell(new Paragraph("UCreacion", FontFactory.getFont("Arial", 12, Font.BOLDITALIC ,BaseColor.BLACK)));
                  celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
                  celda5.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda6 = new PdfPCell(new Paragraph("FCreacion", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK)));
                  celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
                  celda6.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda7 = new PdfPCell(new Paragraph("FModifica", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK)));
                  celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
                  celda7.setVerticalAlignment(Element.ALIGN_CENTER);
                tabla.setWidths(medidaCeldas);
                
                tabla.addCell(celda1).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda2).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda3).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda4).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda5).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda6).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda7).setBackgroundColor(BaseColor.LIGHT_GRAY);
                
                BaseColor bs = new BaseColor(224,224,224);
                int cambiocolor = 0;
                while(rs.next()){
                    
                    if(cambiocolor >0 && cambiocolor %2 == 1){
                PdfPCell celda = new PdfPCell(new Paragraph(rs.getString(1))); 

                celda.setBackgroundColor(bs);
                tabla.addCell(celda);
                
                celda = new PdfPCell(new Paragraph(rs.getString(2))); 

                celda.setBackgroundColor(bs);
                tabla.addCell(celda);
                
                celda = new PdfPCell(new Paragraph(rs.getString(3))); 
 
                celda.setBackgroundColor(bs);
                tabla.addCell(celda);
                
                celda = new PdfPCell(new Paragraph(rs.getString(4))); 

                celda.setBackgroundColor(bs);
                tabla.addCell(celda);
                
                celda = new PdfPCell(new Paragraph(rs.getString(5))); 

                celda.setBackgroundColor(bs);
                tabla.addCell(celda);
                
                celda = new PdfPCell(new Paragraph(rs.getString(6))); 

                celda.setBackgroundColor(bs);
                tabla.addCell(celda);
                
                celda = new PdfPCell(new Paragraph(rs.getString(7))); 

                celda.setBackgroundColor(bs);
                tabla.addCell(celda);
                    }else{
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                 
                    }
                    cambiocolor++;
                }
                
                documento.add(tabla);

                documento.close();
                        
                } catch (Exception e) {
                    e.getMessage();
                }
           }               
            } catch (Exception e){e.getMessage();} {
            }
            
        } catch (Exception e) {
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
