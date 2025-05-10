
package com.TramiteDocumentado.pe.Controllers;

import com.TramiteDocumentado.pe.DAO.IRolDao;
import com.TramiteDocumentado.pe.DAO.RolDaoimpl;
import com.TramiteDocumentado.pe.Model.Rol1;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "RolesBenas")
@RequestScoped
public class RolesBenas {

    private final IRolDao dao = new RolDaoimpl();

    private List<Rol1> list;

    private String codigo;

    private int id;
    
    private int idEditar;
    
    private Rol1 rol;

    public RolesBenas() {
    }

    public String listar() {
        list = dao.listar();
        return "/Registrar Roles";
    }

    public String irRolNuevo() {
        codigo = "";
        return "/addRol";
    }

    public String guardar() {
        Rol1 rol = new Rol1();
        rol.setNombre(codigo);
        dao.guardarRol(rol);
        list = dao.listar();
        return "/Registrar Roles";
    }

    public String ihabilitar(){
        dao.darBaja(id);
        list = dao.listar();
        return "/Registrar Roles";
    }
    
    public String habilitar(){
        dao.habilitar(id);
        list = dao.listar();
        return "/Registrar Roles";
    }
    
    public String ireditar(){
      Rol1 role = dao.buscarRol(id);
      codigo = role.getNombre();
     return "/EditarRol";
    }
    
    public String editarRol(){
        Rol1 role = new Rol1();
        System.out.println("ID:"+ id);
        role.setIdRol(id);
        role.setNombre(codigo);
        dao.modificar(role);
        list = dao.listar();
        return "/Registrar Roles";
    }
    
    
    public List<Rol1> getList() {
        return list;
    }

    public void setList(List<Rol1> list) {
        this.list = list;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Rol1 getRol() {
        return rol;
    }

    public void setRol(Rol1 rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEditar() {
        return idEditar;
    }

    public void setIdEditar(int idEditar) {
        this.idEditar = idEditar;
    }

    
    
}
