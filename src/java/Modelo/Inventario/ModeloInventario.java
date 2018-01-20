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
    public int ultimo_id_insertado = -1;
       public boolean insertarinventario(Inventario i){
        boolean flag = false;
         PreparedStatement pst = null;
         PreparedStatement pst1 = null;
        try{
            String sql="INSERT INTO `sistemmuna`.`piezas` (`Nombre`, `Forma`, `Material`, `Tecnica`, `Color`, `Periodo`, "
                          + "`Clasificacion`, `Alto`, `Ancho`, `Largo`, `Diamtero`, `Grosor`, `Peso`, `Procedencia`, `Condicion`, "
                          + "`FormaAdquisicion`, `FAdquisicion`, `Regimen`, `Custodio`) "
                          + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(sql);
            pst.setString(1, i.getNombrePieza());
            pst.setString(2, i.getForma());
            pst.setInt(3, i.getIdMaterial());
            pst.setInt(4, i.getIdTecnica());
            pst.setString(5, i.getColor());
            pst.setString(6, i.getPeriodo());
            pst.setString(7, i.getClasificacion());
            pst.setString(8, i.getAlto());
            pst.setString(9, i.getAncho());
            pst.setString(10, i.getLargo());
            pst.setString(11, i.getDiamtero());
            pst.setString(12, i.getGrosor());
            pst.setString(13, i.getPeso());
            pst.setString(14, i.getProcedencia());
            pst.setString(15, i.getCondicion());
            pst.setString(16, i.getFormaAdquisicion());
            pst.setDate(17, new java.sql.Date(i.getFAdquisicion().getTime()));
            pst.setString(18, i.getRegimen());
            pst.setString(19, i.getCustodio());
            
            String sql1="INSERT INTO `sistemmuna`.`inventarios` (`NumInventario`,  `Descripcion`, `NombrePieza`, `Forma`, "
                          + "`IdMaterial`, `IdTecnica`, `Color`, `Periodo`, `Clasificacion`, `Alto`, `Ancho`, `Largo`, `Diamtero`, "
                          + "`Grosor`, `Peso`, `Procedencia`, `Condicion`, `FormaAdquisicion`, `FAdquisicion`, `Regimen`, `Custodio`, "
                          + "`FInventario`, `RealizadoPor`,  `Observaciones`, `Imagenes`) "
                          + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst1 = getConexion().prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
            pst1.setString(1, i.getNumInventario());
            pst1.setString(2, i.getDescripcion());
            pst1.setString(3, i.getNombrePieza());
            pst1.setString(4, i.getForma());
            pst1.setInt(5, i.getIdMaterial());
            pst1.setInt(6, i.getIdTecnica());
            pst1.setString(7, i.getColor());
            pst1.setString(8, i.getPeriodo());
            pst1.setString(9, i.getClasificacion());
            pst1.setString(10, i.getAlto());
            pst1.setString(11, i.getAncho());
            pst1.setString(12, i.getLargo());
            pst1.setString(13, i.getDiamtero());
            pst1.setString(14, i.getGrosor());
            pst1.setString(15, i.getPeso());
            pst1.setString(16, i.getProcedencia());
            pst1.setString(17, i.getCondicion());
            pst1.setString(18, i.getFormaAdquisicion());
            pst1.setDate(19, new java.sql.Date(i.getFAdquisicion().getTime()));
            pst1.setString(20, i.getRegimen());
            pst1.setString(21, i.getCustodio()); 
            pst1.setDate(22, new java.sql.Date(i.getFInventario().getTime()));                      
            pst1.setString(23, i.getRealizadoPor());
            pst1.setString(24, i.getObservaciones());
            pst1.setString(25, i.getImagenes());
            error = pst1.toString();
              if(pst.executeUpdate() == 1 && pst1.executeUpdate() == 1 ){
            flag = true;
             }
              
              try (ResultSet generatedKeys = pst1.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    this.ultimo_id_insertado = generatedKeys.getInt(1);
                }
                else {
                    this.ultimo_id_insertado = -1;
                }
            }catch(Exception e){
                this.error = e.getMessage();
            }
        
        }catch (Exception e) {
             error += (e.getMessage());
             this.ultimo_id_insertado = -1;
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
            ResultSet rs = statement.executeQuery("select i.*, m.material, t.Tecnica from inventarios i join materiales m on i.IdMaterial = m.IdMaterial join tecnicas t on i.IdTecnica = t.IdTecnica");
            while (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdInventario(rs.getInt("IdInventario"));
                inventario.setNumInventario(rs.getString("NumInventario"));
                inventario.setDescripcion(rs.getString("Descripcion"));
                inventario.setNombrePieza(rs.getString("NombrePieza"));
                inventario.setForma(rs.getString("Forma"));
                inventario.setIdMaterial(rs.getInt("IdMaterial"));
                inventario.setIdTecnica(rs.getInt("IdTecnica"));
                inventario.setColor(rs.getString("Color"));
                inventario.setPeriodo(rs.getString("Periodo"));
                inventario.setClasificacion(rs.getString("Clasificacion"));
                inventario.setAlto(rs.getString("Alto"));
                inventario.setAncho(rs.getString("Ancho"));
                inventario.setLargo(rs.getString("Largo"));
                inventario.setDiamtero(rs.getString("Diamtero"));
                inventario.setGrosor(rs.getString("Grosor"));
                inventario.setPeso(rs.getString("Peso"));
                inventario.setProcedencia(rs.getString("Procedencia"));
                inventario.setCondicion(rs.getString("Condicion"));
                inventario.setFormaAdquisicion(rs.getString("FormaAdquisicion"));
                inventario.setFAdquisicion(rs.getDate("FAdquisicion"));
                inventario.setRegimen(rs.getString("Regimen"));
                inventario.setCustodio(rs.getString("Custodio"));
                inventario.setFInventario(rs.getDate("FInventario"));
                inventario.setRealizadoPor(rs.getString("RealizadoPor"));
                inventario.setActualizadoPor(rs.getString("ActualizadoPor"));
                inventario.setObservaciones(rs.getString("Observaciones"));
                inventario.setImagenes(rs.getString("Imagenes"));
                inventario.setNombre_Material(rs.getString("material"));
                inventario.setNombre_Tecnica(rs.getString("tecnica"));
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
            String sql="select i.*, m.Material from inventarios i join Materiales m on m.IdMaterial = i.IdMaterial  where IdInventario = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, id_inventario);
            pst.executeQuery();
            ResultSet rs = pst.getResultSet();
            while (rs.next()) {
                inventario.setIdInventario(rs.getInt("IdInventario"));
                inventario.setNumInventario(rs.getString("NumInventario"));
                inventario.setDescripcion(rs.getString("Descripcion"));
                inventario.setNombrePieza(rs.getString("NombrePieza"));
                inventario.setForma(rs.getString("Forma"));
                inventario.setMaterial(rs.getString("Material"));
                inventario.setIdMaterial(rs.getInt("IdMaterial"));
                inventario.setIdTecnica(rs.getInt("IdTecnica"));
                inventario.setColor(rs.getString("Color"));
                inventario.setPeriodo(rs.getString("Periodo"));
                inventario.setClasificacion(rs.getString("Clasificacion"));
                inventario.setAlto(rs.getString("Alto"));
                inventario.setAncho(rs.getString("Ancho"));
                inventario.setLargo(rs.getString("Largo"));
                inventario.setDiamtero(rs.getString("Diamtero"));
                inventario.setGrosor(rs.getString("Grosor"));
                inventario.setPeso(rs.getString("Peso"));
                inventario.setProcedencia(rs.getString("Procedencia"));
                inventario.setCondicion(rs.getString("Condicion"));
                inventario.setFormaAdquisicion(rs.getString("FormaAdquisicion"));
                inventario.setFAdquisicion(rs.getDate("FAdquisicion"));
                inventario.setRegimen(rs.getString("Regimen"));
                inventario.setCustodio(rs.getString("Custodio"));
                inventario.setFInventario(rs.getDate("FInventario"));
                inventario.setRealizadoPor(rs.getString("RealizadoPor"));
                inventario.setActualizadoPor(rs.getString("ActualizadoPor"));
                inventario.setObservaciones(rs.getString("Observaciones"));
                inventario.setImagenes(rs.getString("Imagenes"));
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
            String sql = "update inventarios set NumInventario = ?,  Descripcion = ? , NombrePieza = ?, Forma = ?, IdMaterial = ?, IdTecnica = ?, Color = ?, Periodo = ?, Clasificacion  = ?, Alto = ?, Ancho = ?, Largo = ?, Diamtero = ?, Grosor = ?, Peso = ?, Procedencia = ?, Condicion = ?, FormaAdquisicion = ?, FAdquisicion = ?, Regimen = ?, Custodio = ?, FInventario = ?, RealizadoPor = ?, ActualizadoPor = ?, Observaciones = ?, Imagenes = ? where IdInventario = ?";
            pst1 = getConexion().prepareStatement(sql);
            pst1.setString(1, i.getNumInventario());
            pst1.setString(2, i.getDescripcion());
            pst1.setString(3, i.getNombrePieza());
            pst1.setString(4, i.getForma());
            pst1.setInt(5, i.getIdMaterial());
            pst1.setInt(6, i.getIdTecnica());
            pst1.setString(7, i.getColor());
            pst1.setString(8, i.getPeriodo());
            pst1.setString(9, i.getClasificacion());
            pst1.setString(10, i.getAlto());
            pst1.setString(11, i.getAncho());
            pst1.setString(12, i.getLargo());
            pst1.setString(13, i.getDiamtero());
            pst1.setString(14, i.getGrosor());
            pst1.setString(15, i.getPeso());
            pst1.setString(16, i.getProcedencia());
            pst1.setString(17, i.getCondicion());
            pst1.setString(18, i.getFormaAdquisicion());
            pst1.setDate(19, new java.sql.Date(i.getFAdquisicion().getTime()));
            pst1.setString(20, i.getRegimen());
            pst1.setString(21, i.getCustodio()); 
            pst1.setDate(22,new java.sql.Date(i.getFInventario().getTime()));                      
            pst1.setString(23, i.getRealizadoPor());
            pst1.setString(24, i.getActualizadoPor());
            pst1.setString(25, i.getObservaciones());
            pst1.setString(26, i.getImagenes());
            pst1.setInt(27, i.getIdInventario());
                if(pst1.executeUpdate() >= 1){
                resultado = true;
                this.error = "No error";
            }else{
                this.error = "Error";
                resultado = false;
            }
        }catch (Exception e) {
            this.error = e.getMessage() + "asd" ;
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
