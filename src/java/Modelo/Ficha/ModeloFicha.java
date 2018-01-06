package Modelo.Ficha;

import Include.Ficha.Ficha;
import Modelo.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloFicha extends Conexion{
    private Conexion c = new Conexion();
    public String error = "";
       public boolean insertarficha(Ficha f){
        boolean flag = false;
         PreparedStatement pst = null;
         PreparedStatement pst1 = null;
        try{
            String sql="insert into piezas (Nombre,Forma, Color, Periodo, Peso) values (?,?,?,?,?)";
            pst = getConexion().prepareStatement(sql);
            pst.setString(1, f.getNombre());
            pst.setString(2, f.getForma());
            pst.setString(3, f.getColor());
            pst.setString(4, f.getPeriodo());
            pst.setDouble(5, f.getPeso());
            
         
          if(pst.executeUpdate() == 1 ){
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
  public List<Ficha> listar_Fichas() {
        List<Ficha> lista_fichas = new ArrayList<>();
        try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select * from piezas");
            while (rs.next()) {
                Ficha ficha = new Ficha();
                ficha.setIdPieza(rs.getInt("IdPieza"));
                ficha.setNombre(rs.getString("Nombre"));
                ficha.setForma(rs.getString("Forma"));
                ficha.setMaterial(rs.getString("Material"));
                ficha.setTecnica(rs.getString("Tecnica"));
                ficha.setColor(rs.getString("Color"));
                ficha.setPeriodo(rs.getString("Periodo"));
                ficha.setPeso(rs.getDouble("Peso"));
                lista_fichas.add(ficha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista_fichas;
    }
     public Ficha obtener_ficha_por_id(int id_pieza){
     Ficha ficha = new Ficha();
     PreparedStatement pst = null;
        try {
            String sql="select * from piezas where IdPieza = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, id_pieza);
            pst.executeQuery();
            ResultSet rs = pst.getResultSet();
            while (rs.next()) {
                ficha.setIdPieza(rs.getInt("IdPieza"));
                ficha.setNombre(rs.getString("Nombre"));
                ficha.setForma(rs.getString("Forma"));
                ficha.setMaterial(rs.getString("Material"));
                ficha.setTecnica(rs.getString("Tecnica"));
                ficha.setColor(rs.getString("Color"));
                ficha.setPeriodo(rs.getString("Periodo"));
                ficha.setClasificacion(rs.getString("Clasificacion"));
                ficha.setAlto(rs.getDouble("Alto"));
                ficha.setAncho(rs.getDouble("Ancho"));
                ficha.setLargo(rs.getDouble("Largo"));
                ficha.setDiamtero(rs.getDouble("Diamtero"));
                ficha.setGrosor(rs.getDouble("Grosor"));
                ficha.setPeso(rs.getDouble("Peso"));
                ficha.setProcedencia(rs.getString("Procedencia"));               
                ficha.setCondicion(rs.getString("Condicion"));
                ficha.setFormaAdquisicion(rs.getString("FormaAdquisicion"));
                ficha.setFAdquisicion(rs.getString("FAdquisicion"));
                ficha.setRegimen(rs.getString("Regimen"));
                ficha.setCustodio(rs.getString("Custodio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ficha;      
    }
     
     public boolean actualizar (Ficha f){
     boolean resultado = false;
        PreparedStatement pst1= null;
        try{
            String sql = "update piezas set Nombre = ?, Forma = ?, Material = ?, Tecnica = ?, Color = ?, Periodo = ?, Clasificacion  = ?, Alto = ?, Ancho = ?, Largo = ?, Diamtero = ?, Grosor = ?, Peso = ?, Procedencia = ?, Condicion = ?, FormaAdquisicion = ?, FAdquisicion = ?, Regimen = ?, Custodio = ? where IdPieza = ?";
            pst1 = getConexion().prepareStatement(sql);
            pst1.setString(1, f.getNombre());
            pst1.setString(2, f.getForma());
            pst1.setString(3, f.getMaterial());
            pst1.setString(4, f.getTecnica());
            pst1.setString(5, f.getColor());
            pst1.setString(6, f.getPeriodo());
            pst1.setString(7, f.getClasificacion());
            pst1.setDouble(8, f.getAlto());
            pst1.setDouble(9, f.getAncho());
            pst1.setDouble(10, f.getLargo());
            pst1.setDouble(11, f.getDiamtero());
            pst1.setDouble(12, f.getGrosor());
            pst1.setDouble(13, f.getPeso());
            pst1.setString(14, f.getProcedencia());
            pst1.setString(15, f.getCondicion());
            pst1.setString(16, f.getFormaAdquisicion());
            pst1.setString(17, f.getFAdquisicion());
            pst1.setString(18, f.getRegimen());
            pst1.setString(19, f.getCustodio());
            pst1.setInt(20, f.getIdPieza());
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
     
     public boolean eliminar_pieza(int id_pieza){
     PreparedStatement pst = null;
     boolean resultado = false;
        try {
            String sql="delete from piezas where IdPieza = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, id_pieza);
            resultado = pst.executeUpdate() >= 1;
        } catch (SQLException e) {
            e.printStackTrace();
            this.error = e.getMessage();
        }
        return resultado;
    }
    
      
}
