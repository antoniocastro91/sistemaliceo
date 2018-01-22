package Controlador.Inventario;


import Include.Inventario.Inventario;
import Include.Log.Log;
import Modelo.Inventario.ModeloInventario;
import Modelo.Log.ModeloLog;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio Castro
 */
public class ControladorInventario  {
    ModeloInventario mi = new ModeloInventario();
    public String error = "";
    public int ultimo_id_insertado = -1;
    public int inicio= 0;
    public int total_mostrar = 20;
    int id_usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
        mi.setInicio(inicio);
    }

    public int getTotal_mostrar() {
        return total_mostrar;
    }

    public void setTotal_mostrar(int total_mostrar) {
        this.total_mostrar = total_mostrar;
        mi.setTotal_mostrar(total_mostrar);
    }
    
    
     public boolean insertar(Inventario i){
        ModeloInventario mi = new ModeloInventario();
        boolean result = mi.insertarinventario(i);
        this.error = mi.error;
        this.ultimo_id_insertado = mi.ultimo_id_insertado;
        
        if(result){
            this.crear_log("Insert en la tabla inventario con el id " + this.ultimo_id_insertado);
        }
        return result;
    }
     
     public void crear_log(String accion){
        ModeloLog ml = new ModeloLog();
        Log log = new Log();
        log.setId_usuario(this.getId_usuario());
        log.setAccion(accion);
        ml.insertar(log);
     }
     
      public List<Inventario> listar(String[]... criterios){
            List<Inventario> lista_fichas = new ArrayList<>();
            lista_fichas = this.mi.listar_Inventario(criterios);
            this.crear_log("Consulta el listado de piezas");
            return lista_fichas;
        }
      public int total_registros(){
          return mi.total_inventarios();
      }
      
      public int total_registros(String[] criterio){
          return mi.total_inventarios(criterio);
      }
      
    public boolean actualizar(Inventario i){
        ModeloInventario mi = new ModeloInventario();
        boolean result = mi.actualizar(i);
        this.error = mi.error;
        if(result){
            this.crear_log("Update en la tabla inventario con el id " + i.getIdInventario());
        }
        return result;
    }
    
    public boolean eliminar(int id_inventario){
        ModeloInventario mi = new ModeloInventario();
        boolean result = mi.eliminar_inventario(id_inventario);
        this.error = mi.error;
        if(result){
            this.crear_log("Elimacion en la tabla inventario con el id " + id_inventario);
        }
        return result;
    }
    
    public Inventario getInventario(int id_inventario){
        this.crear_log("Obtiene los detalles de la pieza con el id: " + id_inventario);
        return mi.obtener_inventario_por_id(id_inventario); 
    }
}
