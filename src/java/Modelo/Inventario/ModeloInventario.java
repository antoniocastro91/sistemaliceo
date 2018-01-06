/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Inventario;

import Include.Inventario.Inventario;
import Modelo.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloInventario extends Conexion{
    private Conexion c = new Conexion();
    public String error = "";
       public boolean insertarinventario(Inventario i){
        boolean flag = false;
         PreparedStatement pst = null;
         PreparedStatement pst1 = null;
        try{
            String sql="INSERT INTO `sistemmuna`.`piezas` (`Nombre`, `Forma`, `Material`, `Tecnica`, `Color`, `Periodo`, `Clasificacion`, `Alto`, `Ancho`, `Largo`, `Diamtero`, `Grosor`, `Peso`, `Procedencia`, `Condicion`, `FormaAdquisicion`, `FAdquisicion`, `Regimen`, `Custodio`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            pst = getConexion().prepareStatement(sql);
            pst.setString(1, i.getNombrePieza());
            pst.setString(2, i.getForma());
            pst.setString(3, i.getMaterial());
            pst.setString(4, i.getTecnica());
            pst.setString(5, i.getColor());
            pst.setString(6, i.getPeriodo());
            pst.setString(7, i.getClasificacion());
            pst.setDouble(8, i.getAlto());
            pst.setDouble(9, i.getAncho());
            pst.setDouble(10, i.getLargo());
            pst.setDouble(11, i.getDiamtero());
            pst.setDouble(12, i.getGrosor());
            pst.setDouble(13, i.getPeso());
            pst.setString(14, i.getProcedencia());
            pst.setString(15, i.getCondicion());
            pst.setString(16, i.getFormaAdquisicion());
            pst.setString(17, i.getFAdquisicion());
            pst.setString(18, i.getRegimen());
            pst.setString(19, i.getCustodio());
            
            String sql1="INSERT INTO `sistemmuna`.`inventarios` (`NumInventario`,  `Descripcion`, `NombrePieza`, `Forma`, `Material`, `Tecnica`, `Color`, `Periodo`, `Clasificacion`, `Alto`, `Ancho`, `Largo`, `Diamtero`, `Grosor`, `Peso`, `Procedencia`, `Condicion`, `FormaAdquisicion`, `FAdquisicion`, `Regimen`, `Custodio`, `FInventario`, `RealizadoPor`,  `Observaciones`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst1 = getConexion().prepareStatement(sql1);
            pst1.setString(1, i.getNumInventario());
            pst1.setString(2, i.getDescripcion());
            pst1.setString(3, i.getNombrePieza());
            pst1.setString(4, i.getForma());
            pst1.setString(5, i.getMaterial());
            pst1.setString(6, i.getTecnica());
            pst1.setString(7, i.getColor());
            pst1.setString(8, i.getPeriodo());
            pst1.setString(9, i.getClasificacion());
            pst1.setDouble(10, i.getAlto());
            pst1.setDouble(11, i.getAncho());
            pst1.setDouble(12, i.getLargo());
            pst1.setDouble(13, i.getDiamtero());
            pst1.setDouble(14, i.getGrosor());
            pst1.setDouble(15, i.getPeso());
            pst1.setString(16, i.getProcedencia());
            pst1.setString(17, i.getCondicion());
            pst1.setString(18, i.getFormaAdquisicion());
            pst1.setString(19, i.getFAdquisicion());
            pst1.setString(20, i.getRegimen());
            pst1.setString(21, i.getCustodio()); 
            pst1.setString(22, i.getFInventario());                      
            pst1.setString(23, i.getRealizadoPor());
            pst1.setString(24, i.getObservaciones());

              if(pst.executeUpdate() == 1 && pst1.executeUpdate() == 1 ){
            flag = true;
             }
        
        }catch (Exception e) {
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
  public List<Inventario> listar_Inventario() {
        List<Inventario> lista_inventarios = new ArrayList<>();
        try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select * from invetarios");
            while (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdInventario(rs.getInt("IdInventario"));
                inventario.setNumInventario(rs.getString("NumInventario"));
                inventario.setDescripcion(rs.getString("Descripcion"));
                inventario.setNombrePieza(rs.getString("NombrePieza"));
                inventario.setForma(rs.getString("Forma"));
                inventario.setMaterial(rs.getString("Material"));
                inventario.setTecnica(rs.getString("Tecnica"));
                inventario.setColor(rs.getString("Color"));
                inventario.setPeriodo(rs.getString("Periodo"));
                inventario.setClasificacion(rs.getString("Clasificacion"));
                inventario.setAlto(rs.getDouble("Alto"));
                inventario.setAncho(rs.getDouble("Ancho"));
                inventario.setLargo(rs.getDouble("Largo"));
                inventario.setDiamtero(rs.getDouble("Diametro"));
                inventario.setGrosor(rs.getDouble("Grosor"));
                inventario.setPeso(rs.getDouble("Peso"));
                inventario.setProcedencia(rs.getString("Procedencia"));
                inventario.setCondicion(rs.getString("Condicion"));
                inventario.setFormaAdquisicion(rs.getString("FormaAdquisicion"));
                inventario.setFAdquisicion(rs.getString("FAdquisicion"));
                inventario.setRegimen(rs.getString("Regimen"));
                inventario.setCustodio(rs.getString("Custodio"));
                inventario.setFInventario(rs.getString("FInventario"));
                inventario.setRealizadoPor(rs.getString("RealizadoPor"));
                inventario.setActualizadoPor(rs.getString("ActualizadoPor"));
                inventario.setObservaciones(rs.getString("Observaciones"));
                lista_inventarios.add(inventario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_inventarios;
    }
     public Inventario obtener_inventario_por_id(int id_inventario){
     Inventario inventario = new Inventario();
     PreparedStatement pst = null;
        try {
            String sql="select * from inventarios where IdInventario = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, id_inventario);
            pst.executeQuery();
            ResultSet rs = pst.getResultSet();
            while (rs.next()) {
                inventario.setIdInventario(rs.getInt("IdPieza"));
                inventario.setNumInventario(rs.getString("NumInventario"));
                inventario.setDescripcion(rs.getString("Descripcion"));
                inventario.setNombrePieza(rs.getString("NombrePieza"));
                inventario.setForma(rs.getString("Forma"));
                inventario.setMaterial(rs.getString("Material"));
                inventario.setTecnica(rs.getString("Tecnica"));
                inventario.setColor(rs.getString("Color"));
                inventario.setPeriodo(rs.getString("Periodo"));
                inventario.setClasificacion(rs.getString("Clasificacion"));
                inventario.setAlto(rs.getDouble("Alto"));
                inventario.setAncho(rs.getDouble("Ancho"));
                inventario.setLargo(rs.getDouble("Largo"));
                inventario.setDiamtero(rs.getDouble("Diametro"));
                inventario.setGrosor(rs.getDouble("Grosor"));
                inventario.setPeso(rs.getDouble("Peso"));
                inventario.setProcedencia(rs.getString("Procedencia"));
                inventario.setCondicion(rs.getString("Condicion"));
                inventario.setFormaAdquisicion(rs.getString("FormaAdquisicion"));
                inventario.setFAdquisicion(rs.getString("FAdquisicion"));
                inventario.setRegimen(rs.getString("Regimen"));
                inventario.setCustodio(rs.getString("Custodio"));
                inventario.setFInventario(rs.getString("FInventario"));
                inventario.setRealizadoPor(rs.getString("RealizadoPor"));
                inventario.setActualizadoPor(rs.getString("ActualizadoPor"));
                inventario.setObservaciones(rs.getString("Observaciones"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return inventario;      
    }
     
     public boolean actualizar (Inventario i){
     boolean resultado = false;
        PreparedStatement pst1= null;
        try{
            String sql = "update inventarios set NumInventario = ?,  Descripcion = ? , NombrePieza = ?, Forma = ?, Material = ?, Tecnica = ?, Color = ?, Periodo = ?, Clasificacion  = ?, Alto = ?, Ancho = ?, Largo = ?, Diamtero = ?, Grosor = ?, Peso = ?, Procedencia = ?, Condicion = ?, FormaAdquisicion = ?, FAdquisicion = ?, Regimen = ?, Custodio = ?, FInventario = ?, RealizadoPor = ?, ActualizadoPor = ?, Observaciones = ? where IdPieza = ?";
            pst1 = getConexion().prepareStatement(sql);
            pst1.setString(1, i.getNumInventario());
            pst1.setString(2, i.getDescripcion());
            pst1.setString(3, i.getNombrePieza());
            pst1.setString(4, i.getForma());
            pst1.setString(5, i.getMaterial());
            pst1.setString(6, i.getTecnica());
            pst1.setString(7, i.getColor());
            pst1.setString(8, i.getPeriodo());
            pst1.setString(9, i.getClasificacion());
            pst1.setDouble(10, i.getAlto());
            pst1.setDouble(11, i.getAncho());
            pst1.setDouble(12, i.getLargo());
            pst1.setDouble(13, i.getDiamtero());
            pst1.setDouble(14, i.getGrosor());
            pst1.setDouble(15, i.getPeso());
            pst1.setString(16, i.getProcedencia());
            pst1.setString(17, i.getCondicion());
            pst1.setString(18, i.getFormaAdquisicion());
            pst1.setString(19, i.getFAdquisicion());
            pst1.setString(20, i.getRegimen());
            pst1.setString(21, i.getCustodio()); 
            pst1.setString(22, i.getFInventario());                      
            pst1.setString(23, i.getRealizadoPor());
            pst1.setString(24, i.getActualizadoPor());
            pst1.setString(25, i.getObservaciones());
            pst1.setInt(26, i.getIdInventario());
            if(pst1.executeUpdate() >= 1){
                resultado = true;
                this.error = "No error";
            }else{
                this.error = "Error";
                resultado = false;
            }
        }catch (Exception e) {
            this.error = e.getMessage();
             System.err.println(e.getMessage());
        }finally{
            try {
                if(getConexion()!= null) getConexion().close();
                if(pst1 != null) pst1.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return resultado;      
    }
     
     public boolean eliminar_inventario(int id_inventario){
     PreparedStatement pst = null;
     boolean resultado = false;
        try {
            String sql="delete from inventarios where IdInventario = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, id_inventario);
            resultado = pst.executeUpdate() >= 1;
        } catch (SQLException e) {
            e.printStackTrace();
            this.error = e.getMessage();
        }
        return resultado;
    }
    
      
}
