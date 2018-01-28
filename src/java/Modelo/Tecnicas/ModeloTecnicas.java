package Modelo.Tecnicas;

import Include.Tecnicas.Tecnicas;
import Modelo.Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloTecnicas extends Conexion{
    private Conexion c = new Conexion();
    public String error = ""; 
    public List<Tecnicas> listar_tecnicas(){
     List<Tecnicas> lista_materiales = new ArrayList<>();
        try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select * from tecnicas");
            while (rs.next()) {
                
                Tecnicas tecnicas = new Tecnicas();
                tecnicas.setIdTecnica(rs.getInt("IdTecnica"));
                tecnicas.setTecnica(rs.getString("Tecnica"));
                            
                lista_materiales.add(tecnicas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista_materiales;      
    }
        
}


