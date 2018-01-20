package Modelo.Usuario;

import Include.Usuario.Usuario;
import Modelo.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloUsuario extends Conexion {
    private Conexion c = new Conexion();
    public String error = "";
    
    public boolean Autenticar(Usuario u){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            String sql="call autenticar(?,?)";
            pst = getConexion().prepareStatement(sql);
            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getClave());
            rs = pst.executeQuery();
            if(rs.absolute(1)){
            flag = true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                 if(rs != null)rs.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return flag;
    }
    public boolean insertarusuario(Usuario u){
    boolean flag = false;
    PreparedStatement pst= null;
    try{
            String sql="insert into usuario (usuario,clave,email,estado,nivel,usuariocreacion, fechacreacion) values (?,Md5(?),?,?,?,?,?)";
            pst = getConexion().prepareStatement(sql);
      
            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getClave());
            pst.setString(3, u.getEmail());
            pst.setInt(4, u.getEstado());
            pst.setInt(5, u.getNivel());
            pst.setString(6, u.getUsuariocreacion());
            pst.setString(7, u.getFechacreacion());
            
              if(pst.executeUpdate() == 1){
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
    
    
    
    public List<Usuario>listar_usuarios(){
     List<Usuario> lista_usuarios = new ArrayList<>();
        try {
            Statement statement = this.c.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("select u.*, r.nombre from usuario u join rol r on u.nivel = r.id");
            while (rs.next()) {
                
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setNivel(rs.getInt("nivel"));
                usuario.setEstado(rs.getInt("estado"));
                usuario.setEmail(rs.getString("email"));               
                usuario.setNombre_nivel(rs.getString("nombre"));               
                lista_usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista_usuarios;      
    }
        public List<Usuario>listar_usuariosrepor(String nombres,String tipoBuscar){
          
            Conexion cn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql ="";
            try {
             
               this.c.getConexion();
                sql = "select * from usuario where usuario like ? or nivel like ? or estado like ? order by usuario asc";

            ps = getConexion().prepareStatement(sql);
            ps.setString(1, nombres.concat("%"));
            ps.setString(2, nombres.concat("%"));
            ps.setString(3, nombres.concat("%"));
            rs = ps.executeQuery();
            List<Usuario> lista = new ArrayList<Usuario>();
            Usuario u = null;
            while (rs.next()) {
                u = new Usuario();
                u.setId_usuario(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setNivel(rs.getInt("nivel"));
                u.setEstado(rs.getInt("estado"));
                u.setEmail(rs.getString("email"));               
                lista.add(u);
            } 
            return lista;
            }catch (Exception e) {
             this.error = e.getMessage();
             System.err.println(e.getMessage());   
            }return null;
    }
    
    public boolean actualizar (Usuario u){
     boolean resultado = false;
        PreparedStatement pst= null;
        try{
            String sql = "";
            if(u.getClave() == null){
                sql = "update usuario set nivel = ?, usuario = ? ,email = ?, estado = ? where id = ?";
                pst = getConexion().prepareStatement(sql);
                pst.setInt(1, u.getNivel());
                pst.setString(2, u.getUsuario());
                pst.setString(3, u.getEmail());
                pst.setInt(4, u.getEstado());
                pst.setInt(5, u.getId_usuario());
            }else{
                sql = "update usuario set nivel = ?, usuario = ? ,email = ?, clave = Md5(?), estado = ? where id = ?";
                pst = getConexion().prepareStatement(sql);
                pst.setInt(1, u.getNivel());
                pst.setString(2, u.getUsuario());
                pst.setString(3, u.getEmail());
                pst.setString(4, u.getClave());
                pst.setInt(5, u.getEstado());
                pst.setInt(6, u.getId_usuario());
            }
            
            
            
            if(pst.executeUpdate() >= 1){
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
                if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return resultado;      
    }
    
    public boolean eliminar_usuario(int id_usuario){
     PreparedStatement pst = null;
     boolean resultado = false;
        try {
            String sql="delete from usuario where id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, id_usuario);
            resultado = pst.executeUpdate() >= 1;
        } catch (SQLException e) {
            e.printStackTrace();
            this.error = e.getMessage();
        }
        return resultado;
    }
    
    public Usuario obtener_usuario_por_id(int id_usuario){
     Usuario usuario = new Usuario();
     PreparedStatement pst = null;
        try {
            String sql="select * from usuario where id = ?";
            pst = getConexion().prepareStatement(sql);
            pst.setInt(1, id_usuario);
            pst.executeQuery();
            ResultSet rs = pst.getResultSet();
            while (rs.next()) {
                usuario.setId_usuario(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setNivel(rs.getInt("nivel"));
                usuario.setEstado(rs.getInt("estado"));
                usuario.setEmail(rs.getString("email"));               
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return usuario;      
    }
}
