/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Reportes;

import Controlador.Inventario.ControladorInventario;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antonio Castro
 */
@WebServlet(name = "ServletPiezas", urlPatterns = {"/ServletPiezas"})
public class ServletPiezas extends HttpServlet {

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
            ControladorInventario ci = new ControladorInventario();
            ci.setId_usuario(Integer.parseInt(sesion.getAttribute("id_usuario").toString()));
            ci.crear_log("Consultó el Reporte de la pieza con el siguiente dato: " + request.getParameter("txtpieza"));
            
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
                String nombrepieza = request.getParameter("txtpieza");
                try {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null; 
                Class.forName("com.mysql.jdbc.Driver");
                con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemmuna", "root", "root");
                st = con.createStatement();
                rs = st.executeQuery("select i.IdInventario, i.NumInventario,i.Descripcion,"
                        + "i.NombrePieza,i.Forma,i.Color, i.Periodo,i.Imagenes , m.material, t.Tecnica, "
                        + "i.Alto,i.Diamtero,i.Ancho,i.Grosor,i.Largo,i.Peso,i.Procedencia, i.Condicion,"
                        + "i.FormaAdquisicion,i.FAdquisicion,i.Regimen,i.Custodio,i.FInventario,i.RealizadoPor,"
                        + "i.Observaciones  "
                        + "from inventarios i "
                        + "join materiales m on i.IdMaterial = m.IdMaterial "
                        + "join tecnicas t on i.IdTecnica = t.IdTecnica where NombrePieza = '" + nombrepieza + "' or NumInventario like '%"+nombrepieza+"%' or i.Imagenes like '%"+ nombrepieza+"%.jpg' or i.Imagenes like '%"+ nombrepieza+"%.png'");
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
                 OutputStream out = response.getOutputStream();
                String nombrepieza = request.getParameter("txtpieza");
            try {
                try {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null; 
                
                Class.forName("com.mysql.jdbc.Driver");
                con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemmuna", "root", "root");
                st = con.createStatement();
                rs = st.executeQuery("select i.IdInventario, i.NumInventario,i.Descripcion,"
                        + "i.NombrePieza,i.Forma,i.Color, i.Periodo,i.Imagenes , m.material, t.Tecnica, "
                        + "i.Alto,i.Diamtero,i.Ancho,i.Grosor,i.Largo,i.Peso,i.Procedencia, i.Condicion,"
                        + "i.FormaAdquisicion,i.FAdquisicion,i.Regimen,i.Custodio,i.FInventario,i.RealizadoPor,"
                        + "i.Observaciones  "
                        + "from inventarios i "
                        + "join materiales m on i.IdMaterial = m.IdMaterial "
                        + "join tecnicas t on i.IdTecnica = t.IdTecnica where NombrePieza = '" + nombrepieza + "' or NumInventario like '%"+nombrepieza+"%' or i.Imagenes like '%"+ nombrepieza+"%.jpg' or i.Imagenes like '%"+ nombrepieza+"%.png'");
                     
                 
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
                Font detallesfuente = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK);
                Font fondescripgral = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
                //NombrePrinciapal
                
                Paragraph par2 = new Paragraph();
                par2.add(new Phrase("Reporte Individual de Piezas:", fondescrip));
                par2.setAlignment(Element.ALIGN_LEFT);
                par2.add(new Phrase(Chunk.NEWLINE));           
                par2.add("\n");
                documento.add(par2);
               
                //NumeroInventario
                Paragraph numinv = new Paragraph();
                //Descripcion
                Paragraph descripcion = new Paragraph();
                Paragraph detalles = new Paragraph();
                Paragraph med = new Paragraph();
                Paragraph medespacio = new Paragraph();
                //NombrePieza
                Paragraph nompieza = new Paragraph();
                Paragraph forma = new Paragraph();
                Paragraph material = new Paragraph();
                Paragraph tecnica = new Paragraph();
                Paragraph color = new Paragraph();
                Paragraph periodo = new Paragraph();
                Paragraph alto = new Paragraph();
                Paragraph diametro = new Paragraph();
                Paragraph ancho = new Paragraph();
                Paragraph grosor = new Paragraph();
                Paragraph largo = new Paragraph();
                Paragraph peso = new Paragraph();
                Paragraph procedencia = new Paragraph();
                Paragraph estado = new Paragraph();
                Paragraph formaadquisi = new Paragraph();
                Paragraph fechaadquisi = new Paragraph();
                Paragraph regimen = new Paragraph();
                Paragraph custodio = new Paragraph();
                Paragraph fechainv = new Paragraph();
                Paragraph realizadopor = new Paragraph();
                Paragraph observaciones = new Paragraph();

                //TablaImagenes
                PdfPTable tablaimagenes = new PdfPTable(4);  
                
                Paragraph nuevalinea = new Paragraph();
                nuevalinea.add("\n");
                
           
                PdfPTable tablanompro = new PdfPTable(2); 
                PdfPCell bordes = new PdfPCell();
                PdfPCell bordes2 = new PdfPCell();

                while(rs.next()){
                 tablaimagenes= new PdfPTable(4);
                 tablanompro = new PdfPTable(2);
                 bordes= new PdfPCell();
                 bordes2= new PdfPCell();
                
                 numinv = new Paragraph();
                 descripcion = new Paragraph();
                 detalles = new Paragraph();
                 med = new Paragraph();
                 medespacio = new Paragraph();
                
                 nompieza = new Paragraph();
                 forma = new Paragraph();
                 material = new Paragraph();
                 tecnica = new Paragraph();
                 color = new Paragraph();
                 periodo = new Paragraph();
                 alto = new Paragraph();
                 diametro = new Paragraph();
                 ancho = new Paragraph();
                 grosor = new Paragraph();
                 largo = new Paragraph();
                 peso = new Paragraph();
                 procedencia = new Paragraph();
                 estado = new Paragraph();
                 formaadquisi = new Paragraph();
                 fechaadquisi = new Paragraph();
                 regimen = new Paragraph();
                 custodio = new Paragraph();
                 fechainv = new Paragraph();
                 realizadopor = new Paragraph();
                 observaciones = new Paragraph();
                
                 numinv.add(new Phrase("Num Inventario: ",fondescripgral));
                 numinv.setAlignment(Element.ALIGN_CENTER);
                 numinv.add(new Phrase(rs.getString(2),fondescrip));
                 

                 String imagenes[] = rs.getString(8) != null ? rs.getString(8).split(";") : null;
                 String ruta =null;
                 if(imagenes!=null){
                     for (String imagen : imagenes) {
                         ruta = null;
                        if (imagen.length()>0) {
                            ruta = request.getServletContext().getRealPath("Imagenes/" + rs.getString(1)+"/" + imagen);
                        }
                        if(ruta!=null){
                            ruta = ruta.replace("\\", "\\\\");
                            Image imagen2 = Image.getInstance(ruta);
                            imagen2.setAlignment(Element.ALIGN_CENTER);
                            imagen2.scaleToFit(100, 150);
                            PdfPCell  celda1 = new PdfPCell(imagen2);
                            tablaimagenes.addCell(celda1);
                        }  }
                 }
                 descripcion.add(new Phrase("Descripcion: ",fondescripgral));
                 descripcion.add(new Phrase(rs.getString(3),fondescrip));
                 

                 detalles.add(new Phrase("Detalles: ",detallesfuente)); 
                 detalles.setAlignment(Element.ALIGN_LEFT);
                 
                 nompieza.add(new Phrase("NombrePieza: ",fondescripgral));
                 nompieza.add(new Phrase(rs.getString(4) , fondescrip)); 
                 forma.add(new Phrase("Forma: ",fondescripgral));
                 forma.add(new Phrase(rs.getString(5) , fondescrip));
                 
                 material.add(new Phrase("Material: ",fondescripgral));
                 material.add(new Phrase(rs.getString(9) , fondescrip)); 
                 tecnica.add(new Phrase("Tecnica de ELAB: ",fondescripgral));
                 tecnica.add(new Phrase(rs.getString(10) , fondescrip));
                 
                 color.add(new Phrase("Color: ",fondescripgral));
                 color.add(new Phrase(rs.getString(6) , fondescrip)); 
                 periodo.add(new Phrase("Periodo: ",fondescripgral));
                 periodo.add(new Phrase(rs.getString(7) , fondescrip));
          
                 tablanompro.setWidthPercentage(100);
                
                 med.add(new Phrase("Medidas: ",detallesfuente ));
                 medespacio.add(new Phrase(" "));
                 alto.add(new Phrase("Alto: ",fondescripgral ));
                 alto.add(new Phrase(rs.getString(11) , fondescrip));
                 diametro.add(new Phrase("Diamtero: ",fondescripgral ));
                 diametro.add(new Phrase(rs.getString(12) , fondescrip));
                 ancho.add(new Phrase("Ancho: ",fondescripgral ));
                 ancho.add(new Phrase(rs.getString(13) , fondescrip));
                 grosor.add(new Phrase("Grosor: ",fondescripgral ));
                 grosor.add(new Phrase(rs.getString(14) , fondescrip));
                 
                 largo.add(new Phrase("Largo : ",fondescripgral ));
                 largo.add(new Phrase(rs.getString(15) , fondescrip));
                 peso.add(new Phrase("Peso : ",fondescripgral ));
                 peso.add(new Phrase(rs.getString(16) , fondescrip));
                 
                 procedencia.add(new Phrase("Procedencia : ",fondescripgral ));
                 procedencia.add(new Phrase(rs.getString(17) , fondescrip));
                 estado.add(new Phrase("Estado de Conservacion : ",fondescripgral ));
                 estado.add(new Phrase(rs.getString(18) , fondescrip));       
                 
                 formaadquisi.add(new Phrase("Forma de Adquis : ",fondescripgral ));
                 formaadquisi.add(new Phrase(rs.getString(19) , fondescrip));
                 fechaadquisi.add(new Phrase("Fecha de Adquis : ",fondescripgral ));
                 fechaadquisi.add(new Phrase(rs.getString(20) , fondescrip)); 
                 
                 regimen.add(new Phrase("Regimen de Propiedad : ",fondescripgral ));
                 regimen.add(new Phrase(rs.getString(21) , fondescrip));
                 custodio.add(new Phrase("Custodio : ",fondescripgral ));
                 custodio.add(new Phrase(rs.getString(22) , fondescrip)); 
                 
                 fechainv.add(new Phrase("Fecha de Inv : ",fondescripgral ));
                 fechainv.add(new Phrase(rs.getString(23) , fondescrip));
                 realizadopor.add(new Phrase("Realizado Por : ",fondescripgral ));
                 realizadopor.add(new Phrase(rs.getString(24) , fondescrip));                 
                 
                 observaciones.add(new Phrase("Observaciones : ",fondescripgral ));
                 observaciones.add(new Phrase(rs.getString(25) , fondescrip));
                 
                 bordes.addElement(nompieza);
                 bordes2.addElement(forma);
                 bordes.addElement(material);
                 bordes2.addElement(tecnica);
                 bordes.addElement(color);
                 bordes2.addElement(periodo);
                 bordes.addElement(medespacio);
                 bordes2.addElement(medespacio);
                 bordes.addElement(med);
                 bordes2.addElement(medespacio);
                 bordes.addElement(alto);
                 bordes2.addElement(diametro);
                 bordes.addElement(ancho);
                 bordes2.addElement(grosor);
                 bordes.addElement(largo);
                 bordes2.addElement(peso);
                 bordes.addElement(medespacio);
                 bordes2.addElement(medespacio);
                 bordes.addElement(procedencia);
                 bordes2.addElement(estado);
                 bordes.addElement(formaadquisi);
                 bordes2.addElement(fechaadquisi);
                 bordes.addElement(regimen);
                 bordes2.addElement(custodio);
                 bordes.addElement(fechainv);
                 bordes2.addElement(realizadopor);
                 bordes.addElement(medespacio);
                 bordes2.addElement(medespacio);
            
                 tablanompro.addCell(bordes).setBorder(0);
                 tablanompro.addCell(bordes2).setBorder(0);
                 documento.add(numinv);
                documento.add(nuevalinea);
                documento.add(descripcion);
                documento.add(nuevalinea);
                documento.add(detalles);
                documento.add(tablanompro);
                documento.add(nuevalinea);
                
                documento.add(nuevalinea);
                documento.add(observaciones);
                documento.add(nuevalinea);
                documento.add(nuevalinea);
                documento.add(tablaimagenes);
                }
              
                /*documento.add(numinv);
                documento.add(nuevalinea);
                documento.add(descripcion);
                documento.add(nuevalinea);
                //documento.add(detalles);
                documento.add(tablanompro);
                documento.add(nuevalinea);
                
                documento.add(nuevalinea);
                documento.add(observaciones);
                documento.add(nuevalinea);
                documento.add(nuevalinea);
                documento.add(tablaimagenes);*/
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
