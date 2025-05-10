/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TramiteDocumentado.pe;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Julio López
 */
@Entity
@Table(name = "tr\u00e1mite")
@NamedQueries({
    @NamedQuery(name = "Tr\u00e1mite.findAll", query = "SELECT t FROM Tr\u00e1mite t"),
    @NamedQuery(name = "Tr\u00e1mite.findByTramiteId", query = "SELECT t FROM Tr\u00e1mite t WHERE t.tramiteId = :tramiteId"),
    @NamedQuery(name = "Tr\u00e1mite.findByFechaRecepcion", query = "SELECT t FROM Tr\u00e1mite t WHERE t.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Tr\u00e1mite.findByObservaci\u00f3n", query = "SELECT t FROM Tr\u00e1mite t WHERE t.observaci\u00f3n = :observaci\u00f3n"),
    @NamedQuery(name = "Tr\u00e1mite.findByCantidaddias", query = "SELECT t FROM Tr\u00e1mite t WHERE t.cantidaddias = :cantidaddias"),
    @NamedQuery(name = "Tr\u00e1mite.findByFechaTermino", query = "SELECT t FROM Tr\u00e1mite t WHERE t.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Tr\u00e1mite.findByAsunto", query = "SELECT t FROM Tr\u00e1mite t WHERE t.asunto = :asunto")})
public class Tramitee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tramiteId")
    private Integer tramiteId;
    @Column(name = "fechaRecepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Column(name = "Observaci\u00f3n")
    private String observación;
    @Column(name = "Cantidad_dias")
    private Integer cantidaddias;
    @Column(name = "fechaTermino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Basic(optional = false)
    @Column(name = "asunto")
    private String asunto;
    @Column(name = "idPersona")
    @ManyToOne
    private int idPersona;
    @OneToMany(mappedBy = "tramiteid")
    private Collection<Documentoo> documentoCollection;

    public Tramitee(Integer tramiteId, Date fechaRecepcion, String observación, Integer cantidaddias, Date fechaTermino, String asunto, int idPersona, Collection<Documentoo> documentoCollection) {
        this.tramiteId = tramiteId;
        this.fechaRecepcion = fechaRecepcion;
        this.observación = observación;
        this.cantidaddias = cantidaddias;
        this.fechaTermino = fechaTermino;
        this.asunto = asunto;
        this.idPersona = idPersona;
        this.documentoCollection = documentoCollection;
    }

    public Tramitee() {
    }

    public Tramitee(Integer tramiteId) {
        this.tramiteId = tramiteId;
    }

    public Tramitee(Integer tramiteId, String asunto) {
        this.tramiteId = tramiteId;
        this.asunto = asunto;
    }

    public Integer getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(Integer tramiteId) {
        this.tramiteId = tramiteId;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getObservación() {
        return observación;
    }

    public void setObservación(String observación) {
        this.observación = observación;
    }

    public Integer getCantidaddias() {
        return cantidaddias;
    }

    public void setCantidaddias(Integer cantidaddias) {
        this.cantidaddias = cantidaddias;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Collection<Documentoo> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documentoo> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tramiteId != null ? tramiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramitee)) {
            return false;
        }
        Tramitee other = (Tramitee) object;
        if ((this.tramiteId == null && other.tramiteId != null) || (this.tramiteId != null && !this.tramiteId.equals(other.tramiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TramiteDocumentado.pe.Tr\u00e1mite[ tramiteId=" + tramiteId + " ]";
    }
    
}
