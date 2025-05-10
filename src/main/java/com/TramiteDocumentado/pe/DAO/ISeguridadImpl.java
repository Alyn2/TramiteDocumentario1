package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Model.Login;
import com.TramiteDocumentado.pe.Model.Menu;
import com.TramiteDocumentado.pe.Model.UsuarioLogin;
import com.TramiteDocumentado.pe.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ISeguridadImpl extends Conexion implements ISeguridad {

    @Override
    public Login Login(com.TramiteDocumentado.pe.Model.Login l) {
        Login lsql = new Login();
        try {
            String sql = "SELECT idPersona, Correo , Contraseña FROM usuarios WHERE Correo = ? and  Contraseña = ? and estado = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, l.getUsuario());
            ps.setString(2, l.getContrasenia());
            ps.setString(3, "activo");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lsql.setIdUsuario(rs.getInt(1));
                lsql.setUsuario(rs.getString(2));
                lsql.setContrasenia(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
        return lsql;
    }

    @Override
    public UsuarioLogin usuario(int id) {
        UsuarioLogin u = new UsuarioLogin();
        try {
            String sql = "SELECT usuarios.idPersona , rol.id , persona.Nombre, persona.Apellido, rol.nombre FROM usuarios\n"
                    + "INNER JOIN persona on usuarios.idPersona = persona.Idpersona\n"
                    + "INNER JOIN rol on usuarios.id_rol = rol.id\n"
                    + "WHERE usuarios.idPersona = ? and usuarios.estado = ? ;";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, "activo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setIdRol(rs.getInt(2));
                u.setNombreCompleto(rs.getString(3) + " " + rs.getString(4));
                u.setRol(rs.getString(5));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return u;
    }

    @Override
    public List<Menu> lstmenu(int idRol) {
       List<Menu> lst = new ArrayList<>();
        try {
            String sql = "SELECT opcion.idOpcion , opcion.documento FROM permiso "
                    + "INNER JOIN opcion on permiso.idOpcion = opcion.idOpcion "
                    + "WHERE idrol = ? and opcion.estado = ?  ;";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.setString(2, "activo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Menu m = new Menu();
                m.setId(rs.getInt(1));
                m.setNombre(rs.getString(2));
                lst.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
       return lst;
    }

}
