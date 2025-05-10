package com.TramiteDocumentado.pe.DAO;


import com.TramiteDocumentado.pe.Model.Rol1;
import java.util.List;


public interface IRolDao {
    
    void guardarRol(Rol1 rol);
    
    void modificar (Rol1 rol);
    
    void darBaja(int id);
    
    void habilitar(int id);
    
    List<Rol1> listar();
    
    Rol1 buscarRol(int id);
    
}
