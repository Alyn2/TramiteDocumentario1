package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Model.Personas;
import com.TramiteDocumentado.pe.Model.Rol;
import com.TramiteDocumentado.pe.Model.Usuario;
import com.TramiteDocumentado.pe.Model.UsuarioTabla;
import com.TramiteDocumentado.pe.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JS02
 */
public class IUsuariosImpl extends Conexion implements IUsuarios {

    @Override
    public List<UsuarioTabla> list() {
        List<UsuarioTabla> lst = new ArrayList<>();
        try {
            String sql = "SELECT usuarios.Idusuario  , persona.Nombre, persona.Apellido, rol.nombre, usuarios.Correo, usuarios.Contraseña , usuarios.estado FROM usuarios \n"
                    + "INNER JOIN rol on rol.id=usuarios.id_rol \n"
                    + "INNER JOIN persona on persona.Idpersona=usuarios.idPersona;";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioTabla u = new UsuarioTabla();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2)+" "+rs.getString(3));
                u.setRol(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setContraseña(rs.getString(6));
                u.setEstado(rs.getString(7));
                lst.add(u);
            }
        } catch (Exception e) {
        }
        return lst;
    }

    @Override
    public List<Rol> lstRol() {
        List<Rol> lst = new ArrayList<>();
        try {
            String sql = "Select * from rol";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setId(rs.getInt(1));
                rol.setRol(rs.getString(2));
                System.out.println("IDs rol: " +rs.getInt(1));
                lst.add(rol);
            }
        } catch (Exception e) {
        }
        return lst;
    }

    @Override
    public List<Personas> lstPersonas() {
        List<Personas> lst = new ArrayList<>();
        try {
            String sql = "Select * from persona";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Personas p = new Personas();
                p.setIdPersona(rs.getInt(1));
                p.setNombre(rs.getString(2) + " " + rs.getString(3));
            }
        } catch (Exception e) {
        }
        return lst;
    }

    @Override
    public void addUsuario(Usuario u) {
        try {
            String sql = "INSERT INTO usuarios(idPersona, Correo, Contraseña, id_rol, estado) VALUES (?,?,?,?,?)";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, u.getIdPersona());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getContraseña());
            ps.setInt(4, u.getRol());
            ps.setString(5, "activo");
            ps.execute();
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }

    @Override
    public void modificar(Usuario u) {
        
        
        try {
            String sql = "UPDATE usuarios SET idPersona= ? ,Correo= ?,Contraseña=?,id_rol=? WHERE Idusuario=?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, u.getIdPersona());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getContraseña());
            ps.setInt(4, u.getRol());
            ps.setInt(5, u.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
    }

    @Override
    public void darBaja(int u) {
        try {
            String sql = "UPDATE usuarios SET estado = ? WHERE Idusuario = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, "inhabitado");
            ps.setInt(2, u);
            ps.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public void activar(int u) {
        try {
            String sql = "UPDATE usuarios SET estado = ? WHERE Idusuario = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, "activo");
            ps.setInt(2, u);
            ps.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public Usuario buscarUsuario(int id) {
        Usuario u = new Usuario();
        try {
            
            String sql = "SELECT * FROM usuarios";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setIdPersona(rs.getInt(2));
                u.setCorreo(rs.getString(3));
                u.setContraseña(rs.getString(4));
                u.setRol(rs.getInt(5));
                u.setEstado(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return u;
    }

    
    
}
