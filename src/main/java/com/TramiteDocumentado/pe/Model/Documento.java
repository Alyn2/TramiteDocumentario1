package com.TramiteDocumentado.pe.Model;

public class Documento {
    private int idDocumento;
    
    private String asunto;
    
    private String tipo;
    
    private String requisitos;
    
    private int tramiteID;
    
    private String fechaActual;
    
    private String fechavencimiento;

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public int getTramiteID() {
        return tramiteID;
    }

    public void setTramiteID(int tramiteID) {
        this.tramiteID = tramiteID;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }
    
}
