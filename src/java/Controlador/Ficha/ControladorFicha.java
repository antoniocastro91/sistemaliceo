package Controlador.Ficha;

import Include.Ficha.Ficha;
import Modelo.Ficha.ModeloFicha;
import java.util.ArrayList;
import java.util.List;

public class ControladorFicha {
     Modelo.Ficha.ModeloFicha mf = new ModeloFicha();
     public String error = "";
     public boolean insertar(Ficha f){
        ModeloFicha mf = new ModeloFicha();
        return mf.insertarficha(f);
        }
      public List<Ficha> listar(){
            List<Ficha> lista_fichas = new ArrayList<>();
            lista_fichas = this.mf.listar_Fichas();
            return lista_fichas;
        }
      
        public boolean actualizar(Ficha f){
        ModeloFicha mf = new ModeloFicha();
        boolean result = mf.actualizar(f);
        this.error = mf.error;
        return result;
    }
    public boolean eliminar(int id_pieza){
        ModeloFicha mf = new ModeloFicha();
        boolean result = mf.eliminar_pieza(id_pieza);
        this.error = mf.error;
        return result;
    }
    public Ficha getFicha(int id_pieza){
        return mf.obtener_ficha_por_id(id_pieza); 
    }
    
}
