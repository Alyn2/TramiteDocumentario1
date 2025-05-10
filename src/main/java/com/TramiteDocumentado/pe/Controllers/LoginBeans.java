package com.TramiteDocumentado.pe.Controllers;

import com.TramiteDocumentado.pe.DAO.ISeguridadImpl;
import com.TramiteDocumentado.pe.Model.Login;
import com.TramiteDocumentado.pe.Model.Menu;
import com.TramiteDocumentado.pe.Model.UsuarioLogin;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.TramiteDocumentado.pe.DAO.ISeguridad;

@ManagedBean(name = "loginBeans")
@RequestScoped

public class LoginBeans implements Serializable {

    ISeguridad dao = new ISeguridadImpl();

    String usuario;

    String contrasenia;

    int id;

    int idRol;

    String nombreCompleto;

    String rol;

    List<Menu> menuSeleccionado;
    
    //===================================================
    public String ingreso() {
// ingreso
        String url = "/index";
        Login l = new Login();
        l.setUsuario(usuario);
        l.setContrasenia(contrasenia);
        Login lsql = dao.Login(l);
        
        if (l.getUsuario().equals(lsql.getUsuario()) && l.getContrasenia().equals(lsql.getContrasenia())) {
            url = "/Menu";
        }    
        //datos
        UsuarioLogin u = dao.usuario(lsql.getIdUsuario());
        id = u.getId();
        idRol=u.getIdRol();
        nombreCompleto = u.getNombreCompleto();
        rol = u.getRol();
        //Menu
        
        menuSeleccionado = dao.lstmenu(idRol);
        
        return url;
    }

    
    
    
    //===============================================
    public ISeguridad getDao() {
        return dao;
    }

    public void setDao(ISeguridad dao) {
        this.dao = dao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Menu> getMenuSeleccionado() {
        return menuSeleccionado;
    }

    public void setMenuSeleccionado(List<Menu> menuSeleccionado) {
        this.menuSeleccionado = menuSeleccionado;
    }
    
}
