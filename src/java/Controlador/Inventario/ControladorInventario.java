package Controlador.Inventario;


import Include.Inventario.Inventario;
import Modelo.Inventario.ModeloInventario;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio Castro
 */
public class ControladorInventario {
     ModeloInventario mi = new ModeloInventario();
     public String error = "";
     public boolean insertar(Inventario i){
        ModeloInventario mi = new ModeloInventario();
        return mi.insertarinventario(i);
        }
      public List<Inventario> listar(){
            List<Inventario> lista_fichas = new ArrayList<>();
            lista_fichas = this.mi.listar_Inventario();
            return lista_fichas;
        }
      
        public boolean actualizar(Inventario i){
        ModeloInventario mi = new ModeloInventario();
        boolean result = mi.actualizar(i);
        this.error = mi.error;
        return result;
    }
    public boolean eliminar(int id_inventario){
        ModeloInventario mi = new ModeloInventario();
        boolean result = mi.eliminar_inventario(id_inventario);
        this.error = mi.error;
        return result;
    }
    public Inventario getInventario(int id_inventario){
        return mi.obtener_inventario_por_id(id_inventario); 
    }
}
