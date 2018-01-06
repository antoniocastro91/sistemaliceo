package Controlador.Usuario;

import Include.Usuario.Usuario;
import Modelo.Usuario.ModeloUsuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    ModeloUsuario mu = new ModeloUsuario();
    public String error = ""        ;
    
    public boolean crear(Usuario u){
        ModeloUsuario mu = new ModeloUsuario();
        return mu.crearUsuario(u);
    }
    public boolean validar(Usuario u){
        ModeloUsuario mu = new ModeloUsuario();
        return mu.Autenticar(u);
    }
    public boolean insertar(Usuario u){
        ModeloUsuario mu = new ModeloUsuario();
        return mu.insertarusuario(u);
    }

    /**
     *
     * @param u
     * @param clave
     * @return
     */
    public boolean actualizar(Usuario u){
        ModeloUsuario mu = new ModeloUsuario();
        boolean result = mu.actualizar(u);
        this.error = mu.error;
        return result;
    }
    public boolean eliminar(int id_usuario){
        ModeloUsuario mu = new ModeloUsuario();
        boolean result = mu.eliminar_usuario(id_usuario);
        this.error = mu.error;
        return result;
    }
    public List<Usuario> listar(){
        List<Usuario> lista_usuarios = new ArrayList<>();
        lista_usuarios = this.mu.listar_usuarios();
        return lista_usuarios;
    }
    public String getViewUser(Usuario u){
         String htmlcode = "";
         htmlcode += "<b> <p> Bienvenido "+ u.getUsuario() + "</b></p>" +"<a href='CerrarSesion'> Cerrar Sesion</a> ";
        return htmlcode;
    }
    public Usuario getUsuario(int id_usuario){
        return mu.obtener_usuario_por_id(id_usuario);
    }
}
