/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Include.Materiales;

/**
 *
 * @author Antonio Castro
 */
public class Materiales {
    private int IdMaterial;
    private String Material;

    public int getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(int IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }
    
    public String ToString(){
        return this.IdMaterial + this.Material;
    }
}
