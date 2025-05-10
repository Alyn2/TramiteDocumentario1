/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TramiteDocumentado.pe;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Julio López
 */
@Entity
@Table(name = "documento")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByDocumentoId", query = "SELECT d FROM Documento d WHERE d.documentoId = :documentoId"),
    @NamedQuery(name = "Documento.findByTipo", query = "SELECT d FROM Documento d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "Documento.findByEstado", query = "SELECT d FROM Documento d WHERE d.estado = :estado"),
    @NamedQuery(name = "Documento.findByFecha", query = "SELECT d FROM Documento d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Documento.findByRequisitos", query = "SELECT d FROM Documento d WHERE d.requisitos = :requisitos"),
    @NamedQuery(name = "Documento.findByVenFecha", query = "SELECT d FROM Documento d WHERE d.venFecha = :venFecha"),
    @NamedQuery(name = "Documento.findByDescripcion", query = "SELECT d FROM Documento d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Documento.findByAreaDirigida", query = "SELECT d FROM Documento d WHERE d.areaDirigida = :areaDirigida")})
public class Documentoo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "documentoId")
    private Integer documentoId;
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "Estado")
    private String estado;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "Requisitos")
    private String requisitos;
    @Column(name = "venFecha")
    @Temporal(TemporalType.DATE)
    private Date venFecha;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Lob
    @Column(name = "adjunto")
    private byte[] adjunto;
    @Basic(optional = false)
    @Column(name = "area_dirigida")
    private String areaDirigida;
    @JoinColumn(name = "tramiteid", referencedColumnName = "tramiteId")
    @ManyToOne
    private Tramitee tramiteid;

    public Documentoo(Integer documentoId, String tipo, String estado, Date fecha, String requisitos, Date venFecha, String descripcion, byte[] adjunto, String areaDirigida, Tramitee tramiteid) {
        this.documentoId = documentoId;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
        this.requisitos = requisitos;
        this.venFecha = venFecha;
        this.descripcion = descripcion;
        this.adjunto = adjunto;
        this.areaDirigida = areaDirigida;
        this.tramiteid = tramiteid;
    }

    public Documentoo() {
    }

    public Documentoo(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public Documentoo(Integer documentoId, String descripcion, byte[] adjunto, String areaDirigida) {
        this.documentoId = documentoId;
        this.descripcion = descripcion;
        this.adjunto = adjunto;
        this.areaDirigida = areaDirigida;
    }

    public Integer getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Date getVenFecha() {
        return venFecha;
    }

    public void setVenFecha(Date venFecha) {
        this.venFecha = venFecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
    }

    public String getAreaDirigida() {
        return areaDirigida;
    }

    public void setAreaDirigida(String areaDirigida) {
        this.areaDirigida = areaDirigida;
    }

    public Tramitee getTramiteid() {
        return tramiteid;
    }

    public void setTramiteid(Tramitee tramiteid) {
        this.tramiteid = tramiteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoId != null ? documentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoo)) {
            return false;
        }
        Documentoo other = (Documentoo) object;
        if ((this.documentoId == null && other.documentoId != null) || (this.documentoId != null && !this.documentoId.equals(other.documentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TramiteDocumentado.pe.Documento[ documentoId=" + documentoId + " ]";
    }
    
}
