/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Log;

import Include.Log.Log;
import Modelo.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio Castro
 */
public class ModeloLog extends Conexion {
    private Conexion c = new Conexion();
    public String error = "";

    public boolean insertar(Log l){
        boolean flag = false;
        PreparedStatement pst= null;
        try{
            String sql="insert into log (id_usuario,hora,accion) values (?,?,?)";
            pst = getConexion().prepareStatement(sql);

            pst.setInt(1, l.getId_usuario());
            pst.setString(2,l.getHora());
            pst.setString(3, l.getAccion());

            if(pst.executeUpdate() == 1){
                flag = true;
            }

        }catch (Exception e) {
                System.err.println(e.getMessage());
                this.error = e.getMessage();
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
    
    
    
    public List<Log>listar(){
        List<Log> lista_logs = new ArrayList<>();
        try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select u.usuario, l.hora, l.accion from log l join usuario u on u.id= l.id_usuario");
            while (rs.next()) {
                
                Log usuario = new Log();
                usuario.setNombre_usuario(rs.getString("usuario"));
                usuario.setHora(rs.getString("hora"));
                usuario.setAccion(rs.getString("accion"));
                lista_logs.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_logs;      
    }
    public List<Log>listar_log_by_user_id(int id_usuario){
        List<Log> lista_logs = new ArrayList<>();
        try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select u.usuario, l.hora, l.accion from log l join usuario u on u.id= l.id_usuario where l.id_usuario=" + id_usuario);
            while (rs.next()) {
                Log usuario = new Log();
                usuario.setNombre_usuario(rs.getString("usuario"));
                usuario.setHora(rs.getString("hora"));
                usuario.setAccion(rs.getString("accion"));
                lista_logs.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_logs;
    } 
}
