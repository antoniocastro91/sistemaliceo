/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Include.Inventario;

import java.util.Date;

/**
 *
 * @author Antonio Castro
 */
public class Inventario {
    private Integer IdInventario=1;
    private String NumInventario;
    private String Descripcion;
    private String NombrePieza;
    private String Forma;
    private Integer IdMaterial=1;
    private Integer IdTecnica=1;
    private String Color;
    private String Periodo;
    private String Clasificacion;
    private String Alto;
    private String Ancho;
    private String Largo;
    private String Diamtero;
    private String Grosor;
    private String Peso;
    private String Procedencia;
    private String Condicion;
    private String FormaAdquisicion;
    private Date FAdquisicion;
    private String Regimen;
    private String Custodio;
    private Date FInventario;
    private String RealizadoPor;
    private String ActualizadoPor;
    private String Observaciones;    
    private String Imagenes;
    private String Nombre_Material;
    private String Nombre_Tecnica;

    public String getNombre_Material() {
        return Nombre_Material;
    }

    public void setNombre_Material(String Nombre_Material) {
        this.Nombre_Material = Nombre_Material;
    }

    public String getNombre_Tecnica() {
        return Nombre_Tecnica;
    }

    public void setNombre_Tecnica(String Nombre_Tecnica) {
        this.Nombre_Tecnica = Nombre_Tecnica;
    }
    
    

    public String getImagenes() {
        return Imagenes;
    }
    public void setImagenes(String Imagenes) {
        this.Imagenes = Imagenes;
    }

    public Inventario(){}
    
    public Inventario( Integer idinventario, String numinventario,String descripcion, String nombrepieza,String forma,Integer idmaterial,Integer idtecnica,String color,String periodo, String clasificacion, String alto, String ancho, String largo, String diametro, String grosor, String peso, String procedencia, String condicion, String formaadquisicion, Date fadquisicion, String regimen, String custodio, Date finventario, String realizadopor, String actualizadopor, String observaciones){
    this.IdInventario= idinventario;
    this.NumInventario=numinventario;
    this.Descripcion=descripcion;
    this.NombrePieza=nombrepieza;
    this.Forma=forma;
    this.IdMaterial=idmaterial;
    this.IdTecnica=idtecnica;
    this.Color=color;
    this.Periodo=periodo;
    this.Clasificacion=clasificacion;
    this.Alto=alto;
    this.Ancho=ancho;
    this.Largo=largo;
    this.Diamtero=diametro;
    this.Grosor=grosor;
    this.Peso=peso;
    this.Procedencia=procedencia;
    this.Condicion=condicion;
    this.FormaAdquisicion=formaadquisicion;
    this.FAdquisicion=fadquisicion;
    this.Regimen=regimen;
    this.Custodio=custodio;
    this.FInventario=finventario;
    this.RealizadoPor=realizadopor;
    this.ActualizadoPor=actualizadopor;
    this.Observaciones=observaciones;
    }
        public Inventario(String numinventario,String descripcion, String nombrepieza,String forma,Integer idmaterial,Integer idtecnica,
                            String color,String periodo, String clasificacion, String alto, String ancho, String largo, String diametro,
                            String grosor, String peso, String procedencia, String condicion, String formaadquisicion, Date fadquisicion,
                            String regimen, String custodio, Date finventario, String realizadopor, String actualizadopor, String observaciones){
    
    this.NumInventario=numinventario;
    this.Descripcion=descripcion;
    this.NombrePieza=nombrepieza;
    this.Forma=forma;
    this.IdMaterial=idmaterial;
    this.IdTecnica=idtecnica;
    this.Color=color;
    this.Periodo=periodo;
    this.Clasificacion=clasificacion;
    this.Alto=alto;
    this.Ancho=ancho;
    this.Largo=largo;
    this.Diamtero=diametro;
    this.Grosor=grosor;
    this.Peso=peso;
    this.Procedencia=procedencia;
    this.Condicion=condicion;
    this.FormaAdquisicion=formaadquisicion;
    this.FAdquisicion=fadquisicion;
    this.Regimen=regimen;
    this.Custodio=custodio;
    this.FInventario=finventario;
    this.RealizadoPor=realizadopor;
    this.ActualizadoPor=actualizadopor;
    this.Observaciones=observaciones;
    }
    public Inventario(String numinventario,String descripcion, String nombrepieza,String forma,Integer idmaterial,Integer idtecnica,
                       String color,String periodo, String clasificacion, String alto, String ancho, String largo, String diametro,
                       String grosor, String peso, String procedencia, String condicion, String formaadquisicion, Date fadquisicion, 
                       String regimen, String custodio, Date finventario, String realizadopor, String observaciones){
    
    this.NumInventario=numinventario;
    this.Descripcion=descripcion;
    this.NombrePieza=nombrepieza;
    this.Forma=forma;
    this.IdMaterial=idmaterial;
    this.IdTecnica=idtecnica;
    this.Color=color;
    this.Periodo=periodo;
    this.Clasificacion=clasificacion;
    this.Alto=alto;
    this.Ancho=ancho;
    this.Largo=largo;
    this.Diamtero=diametro;
    this.Grosor=grosor;
    this.Peso=peso;
    this.Procedencia=procedencia;
    this.Condicion=condicion;
    this.FormaAdquisicion=formaadquisicion;
    this.FAdquisicion=fadquisicion;
    this.Regimen=regimen;
    this.Custodio=custodio;
    this.FInventario=finventario;
    this.RealizadoPor=realizadopor;
    this.Observaciones=observaciones;
    }    
    public Integer getIdInventario() {
        return IdInventario;
    }

    public void setIdInventario(Integer IdInventario) {
        this.IdInventario = IdInventario;
    }

    public String getNumInventario() {
        return NumInventario;
    }

    public void setNumInventario(String NumInventario) {
        this.NumInventario = NumInventario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNombrePieza() {
        return NombrePieza;
    }

    public void setNombrePieza(String NombrePieza) {
        this.NombrePieza = NombrePieza;
    }

    public String getForma() {
        return Forma;
    }

    public void setForma(String Forma) {
        this.Forma = Forma;
    }

    public Integer getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(Integer IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public Integer getIdTecnica() {
        return IdTecnica;
    }

    public void setIdTecnica(Integer IdTecnica) {
        this.IdTecnica = IdTecnica;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public String getAlto() {
        return Alto;
    }

    public void setAlto(String Alto) {
        this.Alto = Alto;
    }

    public String getAncho() {
        return Ancho;
    }

    public void setAncho(String Ancho) {
        this.Ancho = Ancho;
    }

    public String getLargo() {
        return Largo;
    }

    public void setLargo(String Largo) {
        this.Largo = Largo;
    }

    public String getDiamtero() {
        return Diamtero;
    }

    public void setDiamtero(String Diamtero) {
        this.Diamtero = Diamtero;
    }

    public String getGrosor() {
        return Grosor;
    }

    public void setGrosor(String Grosor) {
        this.Grosor = Grosor;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }



    public String getProcedencia() {
        return Procedencia;
    }

    public void setProcedencia(String Procedencia) {
        this.Procedencia = Procedencia;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String Condicion) {
        this.Condicion = Condicion;
    }

    public String getFormaAdquisicion() {
        return FormaAdquisicion;
    }

    public void setFormaAdquisicion(String FormaAdquisicion) {
        this.FormaAdquisicion = FormaAdquisicion;
    }

    public Date getFAdquisicion() {
        return FAdquisicion;
    }

    public void setFAdquisicion(Date FAdquisicion) {
        this.FAdquisicion = FAdquisicion;
    }

    public String getRegimen() {
        return Regimen;
    }

    public void setRegimen(String Regimen) {
        this.Regimen = Regimen;
    }

    public String getCustodio() {
        return Custodio;
    }

    public void setCustodio(String Custodio) {
        this.Custodio = Custodio;
    }

    public Date getFInventario() {
        return FInventario;
    }

    public void setFInventario(Date FInventario) {
        this.FInventario = FInventario;
    }

    public String getRealizadoPor() {
        return RealizadoPor;
    }

    public void setRealizadoPor(String RealizadoPor) {
        this.RealizadoPor = RealizadoPor;
    }

    public String getActualizadoPor() {
        return ActualizadoPor;
    }

    public void setActualizadoPor(String ActualizadoPor) {
        this.ActualizadoPor = ActualizadoPor;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
    
    
    
}
