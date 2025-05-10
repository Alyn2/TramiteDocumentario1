package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Model.Login;
import com.TramiteDocumentado.pe.Model.Menu;
import com.TramiteDocumentado.pe.Model.UsuarioLogin;
import java.util.List;


public interface ISeguridad {
 
    Login Login(Login l);
    
    UsuarioLogin usuario(int id);
    
    List<Menu> lstmenu (int idRol);
    
}
