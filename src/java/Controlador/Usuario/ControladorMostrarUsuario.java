/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Usuario;

import Include.Usuario.Usuario;
import Modelo.Usuario.ModeloMostrarUsuario;

/**
 *
 * @author Antonio Castro
 */
public class ControladorMostrarUsuario {
        public boolean consultar(Usuario u){
        Modelo.Usuario.ModeloMostrarUsuario mu = new ModeloMostrarUsuario();
        return mu.consultarusuario(u);
    }
}
