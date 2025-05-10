package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Model.Personas;
import com.TramiteDocumentado.pe.Model.Rol;
import com.TramiteDocumentado.pe.Model.Usuario;
import com.TramiteDocumentado.pe.Model.UsuarioTabla;
import java.util.List;

public interface IUsuarios {
    
    List<UsuarioTabla> list();
    
    List<Rol> lstRol();
    
    List<Personas> lstPersonas();
    
    void addUsuario(Usuario u);
    
    void modificar(Usuario u);
    
    void darBaja(int u);
    
    void activar(int u);
    
    Usuario buscarUsuario(int id);
    
}
