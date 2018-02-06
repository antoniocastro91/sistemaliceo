/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Reportes;

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

/**
 *
 * @author Antonio Castro
 */
@WebServlet(name = "ServletLogUsuarios", urlPatterns = {"/ServletLogUsuarios"})
public class ServletLogUsuarios extends HttpServlet {

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
                     String selectusuario = request.getParameter("selectusuario");
                     String fechadesde = request.getParameter("fechadesde");
                     String fechahasta = request.getParameter("fechahasta");
                try {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null; 
                Class.forName("com.mysql.jdbc.Driver");
                con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemmuna", "root", "root");
                st = con.createStatement();
                String sql = "";
                if(selectusuario.equals("0")){
                    sql = "Select * from sistemmuna.log  where hora >= str_to_date('"+ fechadesde+"', \"%Y-%m-%d\") and hora < str_to_date('"+fechahasta+"', \"%Y-%m-%d\") + interval 1 day";
                    
                }else{
                    sql = "Select * from sistemmuna.log where log.id_usuario="+selectusuario+" and hora >= str_to_date('"+ fechadesde+"', \"%Y-%m-%d\") and hora < str_to_date('"+fechahasta+"', \"%Y-%m-%d\") + interval 1 day";
                }
                rs = st.executeQuery(sql);
                if (con != null){     
                    
                    int total = 0;
                    while (rs.next()){
                       //Obtienes la data que necesitas...
                       total++;
                    }
                    if(total > 0 ){
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
        
        try {
            OutputStream out = response.getOutputStream();
        String selectusuario = request.getParameter("selectusuario");
        String fechadesde = request.getParameter("fechadesde");
        String fechahasta = request.getParameter("fechahasta");
                Connection con = null;
                Statement st = null;
                ResultSet rs = null; 
                Class.forName("com.mysql.jdbc.Driver");
                con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemmuna", "root", "root");
                st = con.createStatement();
                
              String sql = "";
                if(selectusuario.equals("0")){
                    sql = "Select u.usuario,date_format(hora,'%d-%m-%Y %h:%i:%s'),accion from sistemmuna.log join usuario u on u.id = log.id_usuario  where hora >= str_to_date('"+ fechadesde+"', \"%Y-%m-%d\") and hora < str_to_date('"+fechahasta+"', \"%Y-%m-%d\") + interval 1 day";
                    
                }else{
                    sql = "Select u.usuario,date_format(hora,'%d-%m-%Y %h:%i:%s'),accion from sistemmuna.log join usuario u on u.id = log.id_usuario  where log.id_usuario="+selectusuario+" and hora >= str_to_date('"+ fechadesde+"', \"%Y-%m-%d\") and hora < str_to_date('"+fechahasta+"', \"%Y-%m-%d\") + interval 1 day";
                }
                rs = st.executeQuery(sql);
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
                Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
                Paragraph par2 = new Paragraph();
                par2.add(new Phrase("Bitacora de Usuarios:", fondescrip));
                par2.setAlignment(Element.ALIGN_LEFT);
                par2.add(new Phrase(Chunk.NEWLINE));           
                par2.add("\n");
                documento.add(par2);
                
                PdfPTable tabla = new PdfPTable(3);      
                tabla.setWidthPercentage(100);
                float[] medidaCeldas = {1.50f,2.10f, 5.00f};
                PdfPCell celda1 = new PdfPCell(new Paragraph("Usuario", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK))); 
                celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda1.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda2 = new PdfPCell(new Paragraph("Hora", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK))); 
                celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda2.setVerticalAlignment(Element.ALIGN_CENTER);
                PdfPCell celda3 = new PdfPCell(new Paragraph("Accion", FontFactory.getFont("Arial", 12,Font.BOLDITALIC , BaseColor.BLACK))); 
                  celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
                  celda3.setVerticalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda1).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda2).setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celda3).setBackgroundColor(BaseColor.LIGHT_GRAY);
                
                tabla.setWidths(medidaCeldas);
                BaseColor bs = new BaseColor(224,224,224);
                int cambiocolor = 0;
                      while (rs.next()){
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
                                             }else{
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    }
                    cambiocolor++;
                  }
                documento.add(tabla);
                documento.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
    } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
