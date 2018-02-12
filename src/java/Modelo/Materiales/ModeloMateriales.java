package Modelo.Materiales;

import Include.Materiales.Materiales;
import Include.Usuario.Usuario;
import Modelo.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloMateriales extends Conexion {
    private Conexion c = new Conexion();
    public String error = ""; 
    public List<Materiales> listar_materiales(){
     List<Materiales> lista_materiales = new ArrayList<>();
        try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select * from materiales");
            while (rs.next()) {
                
                Materiales material = new Materiales();
                material.setIdMaterial(rs.getInt("IdMaterial"));
                material.setMaterial(rs.getString("Material"));
                            
                lista_materiales.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista_materiales;      
    }
    
    public String consulta(){

      PreparedStatement pst = null;
     String sql= "Select * from materiales";
        try {
            pst = getConexion().prepareStatement(sql);
            pst.executeQuery();
            ResultSet rs = pst.getResultSet();
            
            while (rs.next()) {
                 Materiales material = new Materiales();
                 material.setIdMaterial(rs.getInt("IdMaterial"));
                 material.setMaterial(rs.getString("Material"));
                 
            }
            
        } catch (Exception e) {
        }
  

     
        return consulta();
    }
           
        
}
