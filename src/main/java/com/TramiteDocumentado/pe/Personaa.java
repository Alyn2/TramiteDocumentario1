/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TramiteDocumentado.pe;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Julio López
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByTipodedocumento", query = "SELECT p FROM Persona p WHERE p.tipodedocumento = :tipodedocumento"),
    @NamedQuery(name = "Persona.findByNumerodedocumento", query = "SELECT p FROM Persona p WHERE p.numerodedocumento = :numerodedocumento"),
    @NamedQuery(name = "Persona.findByCargo", query = "SELECT p FROM Persona p WHERE p.cargo = :cargo")})
public class Personaa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Idpersona")
    private Integer idpersona;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Telefono")
    private Integer telefono;
    @Column(name = "Tipo_de_documento")
    private String tipodedocumento;
    @Column(name = "Numero_de_documento")
    private Integer numerodedocumento;
    @Column(name = "Cargo")
    private String cargo;
    @OneToMany(mappedBy = "idPersona")
    private Collection<Tramitee> trámiteCollection;

    public Personaa(Integer idpersona, String nombre, String apellido, Integer telefono, String tipodedocumento, Integer numerodedocumento, String cargo, Collection<Tramitee> trámiteCollection) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipodedocumento = tipodedocumento;
        this.numerodedocumento = numerodedocumento;
        this.cargo = cargo;
        this.trámiteCollection = trámiteCollection;
    }

    public Personaa() {
    }

    public Personaa(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getTipodedocumento() {
        return tipodedocumento;
    }

    public void setTipodedocumento(String tipodedocumento) {
        this.tipodedocumento = tipodedocumento;
    }

    public Integer getNumerodedocumento() {
        return numerodedocumento;
    }

    public void setNumerodedocumento(Integer numerodedocumento) {
        this.numerodedocumento = numerodedocumento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Collection<Tramitee> getTrámiteCollection() {
        return trámiteCollection;
    }

    public void setTrámiteCollection(Collection<Tramitee> trámiteCollection) {
        this.trámiteCollection = trámiteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personaa)) {
            return false;
        }
        Personaa other = (Personaa) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TramiteDocumentado.pe.Persona[ idpersona=" + idpersona + " ]";
    }
    
}
