package Include.Ficha;

import java.util.Date;

public class Ficha {
    
    private Integer IdPieza;
    private String NombrePieza;
    private String Forma;
    private String Material;
    private String Tecnica;
    private String Color;
    private String Periodo;
    private String Clasificacion;
    private Double Alto;
    private Double Ancho;
    private Double Largo;
    private Double Diamtero;
    private Double Grosor;
    private Double Peso;
    private String Procedencia;
    private String Condicion;
    private String FormaAdquisicion;
    private String FAdquisicion;
    private String Regimen;
    private String Custodio;
    
    public Ficha(){ }
    
    public Ficha(Integer idpieza, String nombre, String forma,String material,String tecnica,String color,String periodo, String clasificacion, Double alto, Double ancho, Double largo, Double diametro, Double grosor, Double peso, String procedencia, String condicion, String formaadquisicion, String fadquisicion, String regimen, String custodio){
        this.IdPieza = idpieza;
 this.Forma=forma;
    this.Material=material;
    this.Tecnica=tecnica;
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
    }
    
    public Ficha(String nombre,  String forma,String material,String tecnica,String color,String periodo, String clasificacion, Double alto, Double ancho, Double largo, Double diametro, Double grosor, Double peso, String procedencia, String condicion, String formaadquisicion, String fadquisicion, String regimen, String custodio){
    this.NombrePieza = nombre;
    this.Forma=forma;
    this.Material=material;
    this.Tecnica=tecnica;
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
    }

    public Integer getIdPieza() {
        return IdPieza;
    }

    public void setIdPieza(Integer IdPieza) {
        this.IdPieza = IdPieza;
    }

    public String getNombre() {
        return NombrePieza;
    }

    public void setNombre(String Nombre) {
        this.NombrePieza = Nombre;
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

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public String getTecnica() {
        return Tecnica;
    }

    public void setTecnica(String Tecnica) {
        this.Tecnica = Tecnica;
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

    public Double getAlto() {
        return Alto;
    }

    public void setAlto(Double Alto) {
        this.Alto = Alto;
    }

    public Double getAncho() {
        return Ancho;
    }

    public void setAncho(Double Ancho) {
        this.Ancho = Ancho;
    }

    public Double getLargo() {
        return Largo;
    }

    public void setLargo(Double Largo) {
        this.Largo = Largo;
    }

    public Double getDiamtero() {
        return Diamtero;
    }

    public void setDiamtero(Double Diamtero) {
        this.Diamtero = Diamtero;
    }

    public Double getGrosor() {
        return Grosor;
    }

    public void setGrosor(Double Grosor) {
        this.Grosor = Grosor;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double Peso) {
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

    public String getFAdquisicion() {
        return FAdquisicion;
    }

    public void setFAdquisicion(String FAdquisicion) {
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


    
}
