package com.TramiteDocumentado.pe.Model;


public class Tramite {
    
    
    private String fechaRecepcion;
    
    private String observacion;
    
    private int idPersona;
    
    private String FechaTermino;
    
    private int cantidad_de_dias;

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getFechaTermino() {
        return FechaTermino;
    }

    public void setFechaTermino(String FechaTermino) {
        this.FechaTermino = FechaTermino;
    }

    public int getCantidad_de_dias() {
        return cantidad_de_dias;
    }

    public void setCantidad_de_dias(int cantidad_de_dias) {
        this.cantidad_de_dias = cantidad_de_dias;
    }
    
    
    
    
}
