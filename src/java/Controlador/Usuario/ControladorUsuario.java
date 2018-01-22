package Controlador.Usuario;

import Include.Log.Log;
import Include.Usuario.Usuario;
import Modelo.Log.ModeloLog;
import Modelo.Usuario.ModeloUsuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    ModeloUsuario mu = new ModeloUsuario();
    public int ultimo_id_insertado = -1;
    public String error = "";
    int id_usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public void crear_log(String accion){
        ModeloLog ml = new ModeloLog();
        Log log = new Log();
        log.setId_usuario(this.getId_usuario());
        log.setAccion(accion);
        ml.insertar(log);
     }
    public boolean validar(Usuario u){
       
         boolean result = mu.Autenticar(u);
        if(result){
            this.crear_log("El siguiente usuario ha iniciado sesion:" + u.getUsuario());
        }
        return result;
    }
    public boolean insertar(Usuario u){
     
        boolean result = mu.insertarusuario(u);
        if(result){
            this.crear_log("Insert en la tabla usuario con el id " + this.ultimo_id_insertado);
        }
        return result;
    }

    /**
     *
     * @param u
     * @param clave
     * @return
     */
    public boolean actualizar(Usuario u){
        
        boolean result = mu.actualizar(u);
        this.error = mu.error;
        if(result){
            this.crear_log("Update en la tabla usuario con el id " + u.getId_usuario());
        }
        return result;
    }
    public boolean eliminar(int id_usuario){
       
        boolean result = mu.eliminar_usuario(id_usuario);
        this.error = mu.error;
        if(result){
            this.crear_log("Elimacion en la tabla usuario con el id " + id_usuario);
        }
        return result;
    }
    public List<Usuario> listar(){
        List<Usuario> lista_usuarios = new ArrayList<>();
        lista_usuarios = this.mu.listar_usuarios();
        this.crear_log("Consulta el listado de usuarios");
        return lista_usuarios;
    }
   public List<Usuario> listarusu_repo(String nombre,String tipoBuscar){
        List<Usuario> lista_usuarios = new ArrayList<Usuario>();
        lista_usuarios = this.mu.listar_usuariosrepor(nombre, tipoBuscar);
        return lista_usuarios;
    }
    public String getViewUser(Usuario u){
         String htmlcode = "";
         htmlcode += "<b> <p> Bienvenido "+ u.getUsuario() + "</b></p>" +"<a href='CerrarSesion' > Cerrar Sesion</a>";
        return htmlcode;
    }
    public Usuario getUsuario(int id_usuario){
        this.crear_log("Obtiene los detalles del usuario con el id: " + id_usuario);
        return mu.obtener_usuario_por_id(id_usuario);
    }
}
