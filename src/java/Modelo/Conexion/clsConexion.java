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
public class clsConexion {
     Connection cn;
      private String USERNAME="root";
      private String PASSWORD="root";
      private String HOST = "localhost";
      private String PORT = "3306";
      private String DATABASE="SistemMuna";
      private String CLASSNAME="com.mysql.jdbc.Driver";
      private String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
 
     private boolean cnFree = true;
     public clsConexion(){
   try {
            Class.forName(CLASSNAME);
            cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } 
        catch (ClassNotFoundException e)
        {
            System.err.println("Error"+e);
        }catch(SQLException e)
        {
                System.err.println("Error"+e);
        
        }
    }
}
    

