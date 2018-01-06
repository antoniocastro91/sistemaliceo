/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Include.Usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
    private Integer id_usuario;
    private Integer rol_id;
    private String usuario;
    private String clave;
    private String email;
    private Integer estado=1;
    private Integer nivel=1;
    private String usuariocreacion;
    private String fechacreacion;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    
 
    public Usuario(Integer id_usuario,Integer rol_id, String usuario, String clave, String email, Integer estado, Integer nivel,String usuariocreacion,String fechacreacion)
    {
        this.id_usuario = id_usuario;
        this.rol_id = rol_id;
        this.usuario = usuario;
        this.clave = clave;
        this.email = email;
        this.estado = estado;
        this.nivel = nivel;
        this.usuariocreacion = usuariocreacion;
        this.fechacreacion = fechacreacion;
        
       
    }
    public Usuario(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    
        
    }
    public Usuario(){
    
    }
    public Usuario(String usuario){
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }
    
}
	
      