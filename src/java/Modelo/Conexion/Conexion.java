/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antonio
 */
public class Conexion {
    
    //private String PASSWORD="RBYhqx43843";
    //private String HOST = "mariadb24335-sistemamuna.j.facilcloud.com";
    private String USERNAME="root";
    private String PASSWORD="root";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE="sistemmuna";
    private String CLASSNAME="com.mysql.jdbc.Driver";
    private String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    private Connection con;
     public Conexion(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } 
        catch (ClassNotFoundException e)
        {
            System.err.println("Error"+e);
        }catch(SQLException e)
        {
                System.err.println("Error"+e);
        
        }
    }
  public Connection getConexion()
    {
        return con;
    }
    public static void main(String[] args)
    {
        Conexion con = new Conexion();
    }
    public int loguear(String usuario, String clave){
        Connection co;
        PreparedStatement pst;
        ResultSet rs;
        int a =0;   
        String sql ="select nivel from usuario u, rol r where usuario='" + usuario +"' and clave= Md5("+ clave+") and u.estado=1 and u.estado = r.estado"; 
        try {
            Class.forName(this.CLASSNAME);
            co=DriverManager.getConnection(
            this.URL,this.USERNAME, this.PASSWORD);
            pst = co.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                a = rs.getInt(1);
            }
            co.close();
        } catch (ClassNotFoundException | SQLException e){}
    return a;
    }
}
