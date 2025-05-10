package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Model.Rol1;
import com.TramiteDocumentado.pe.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RolDaoimpl extends Conexion implements IRolDao {

    @Override
    public void guardarRol(Rol1 rol) {
        try {
            String query = "INSERT INTO rol (nombre, estado) VALUES (?,?);";
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, rol.getNombre());
            ps.setString(2, "activo");
            ps.execute();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
    }

    @Override
    public void modificar(Rol1 rol) {
        try {
            String query = "UPDATE rol SET nombre = ? WHERE id = ?";
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getIdRol());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
    }

    @Override
    public void darBaja(int id) {
        try {
            String query = "UPDATE rol SET estado = ? WHERE id = ?";
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, "inhabilitado");
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
    }

    @Override
    public List<Rol1> listar() {
        List<Rol1> lst = new ArrayList<>();
        try {
            String query = "SELECT * FROM rol";
            PreparedStatement ps = getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rol1 rol = new Rol1();
                rol.setIdRol(rs.getInt(1));
                rol.setNombre(rs.getString(2));
                rol.setEstado(rs.getString(3));
                lst.add(rol);
            }

        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
        return lst;
    }


    @Override
    public void habilitar(int id) {
        try {
            String query = "UPDATE rol SET estado = ? WHERE id = ?";
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, "Activo");
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
    }

    @Override
    public Rol1 buscarRol(int id) {
        Rol1 rol = new Rol1();
        try {
            String query = "SELECT * FROM rol Where id = ?";
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rol.setIdRol(rs.getInt(1));
                rol.setNombre(rs.getString(2));
                rol.setEstado(rs.getString(3));
            }

        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
        return rol;
    }

}
