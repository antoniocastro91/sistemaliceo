/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Usuario;

import Include.Usuario.Usuario;
import Modelo.Conexion.Conexion;
import Modelo.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Antonio Castro
 */
public class ModeloMostrarUsuario extends Conexion {
     private Conexion c = new Conexion();
    public boolean consultarusuario(Usuario u){
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql="Select usuario, clave from usuarios(?,?)";
            pst = getConexion().prepareStatement(sql);
            pst.setString(1,u.getUsuario());
            pst.setString(2, u.getClave());
              if(pst.executeUpdate() == 1){
            flag = true;
             }
        
        } catch (Exception e) {
          System.err.println(e.getMessage());
        }finally{
            try {
                if(getConexion()!= null) getConexion().close();
                if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    return flag;
    }
    
     public List<Usuario> listar_usuarios() {
          List<Usuario> lista_usuarios = new ArrayList<>();
      try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select * from usuarios");
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setUsuario(rs.getString("usuario"));
                
        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista_usuarios;
    }
}
