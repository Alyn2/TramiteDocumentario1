package com.TramiteDocumentado.pe.Controllers;

import com.TramiteDocumentado.pe.DAO.IUsuarios;
import com.TramiteDocumentado.pe.DAO.IUsuariosImpl;
import com.TramiteDocumentado.pe.Model.Usuario;
import com.TramiteDocumentado.pe.Model.UsuarioTabla;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "usuarioBeans")
@RequestScoped

public class UsuarioBeans implements Serializable {

    IUsuarios dao = new IUsuariosImpl();

    List<UsuarioTabla> lst;

    int idPersona;
    
    String correo;
    
    String contra;
    
    int idrol;

    int idRolAsigado;
    
    public UsuarioBeans() {
    }

    public String listar() {
        lst = dao.list();
        return "/Registrar Usuarios";
    }

    public String iraddUsuario() {
        return "/AddUsuario";
    }

    public String irInhabilitado(){
        dao.darBaja(idRolAsigado);
        lst = dao.list();
        return "/Registrar Usuarios";
    }
    
    public String irhabilitado(){
        dao.activar(idRolAsigado);
        lst = dao.list();
        return "/Registrar Usuarios";
    }
    
    public String irEditar(){
        Usuario us = dao.buscarUsuario(idRolAsigado);
        idPersona = us.getIdPersona();
        correo = us.getCorreo();
        contra = us.getContraseña();
        idrol = us.getRol();
        return "/editar";
    }
    
    public String editar(){
        Usuario us = new Usuario();
        us.setId(idRolAsigado);
        us.setIdPersona(idPersona);
        us.setContraseña(contra);
        us.setCorreo(correo);
        us.setRol(idrol);
        dao.modificar(us);
        lst = dao.list();
        return "/Registrar Usuarios";
    }
    
    public String addUsuario() {

        Usuario u = new Usuario();
        u.setIdPersona(idPersona);
        u.setContraseña(contra);
        u.setCorreo(correo);
        u.setRol(idrol);
        dao.addUsuario(u);
        lst = dao.list();
        return "/Registrar Usuarios";
    }

    public List<UsuarioTabla> getLst() {
        return lst;
    }

    public void setLst(List<UsuarioTabla> lst) {
        this.lst = lst;
    }

    public IUsuarios getDao() {
        return dao;
    }

    public void setDao(IUsuarios dao) {
        this.dao = dao;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public int getIdRolAsigado() {
        return idRolAsigado;
    }

    public void setIdRolAsigado(int idRolAsigado) {
        this.idRolAsigado = idRolAsigado;
    }


    
    
}
