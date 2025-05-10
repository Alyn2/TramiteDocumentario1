/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Documentoo;
import java.util.List;
import com.TramiteDocumentado.pe.Model.Tramite;
import com.TramiteDocumentado.pe.Model.TramiteTablaUsuario;
import com.TramiteDocumentado.pe.Tramitee;
import com.TramiteDocumentado.pe.util.Conexion;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author 
 */
public class DocumentoDaoImpl extends Conexion implements DocumentoDao.IDocumentoDao {

    @Override
    public List<Documentoo> obtenerDocumentos() {
        List<Documentoo> documentos = new ArrayList<>();

        try {
            String sql = "SELECT documentoId, Tipo, Estado, Fecha, Requisitos, tramiteid, venFecha, descripcion, adjunto, area_dirigida FROM documento";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Documentoo documento = new Documentoo();
                documento.setDocumentoId(rs.getInt("documentoId"));
                documento.setTipo(rs.getString("Tipo"));
                documento.setEstado(rs.getString("Estado"));
                documento.setFecha(rs.getDate("Fecha"));
                documento.setRequisitos(rs.getString("Requisitos"));
                documento.setTramiteid(new Tramitee(rs.getInt("tramiteid")));
                documento.setVenFecha(rs.getDate("venFecha"));
                documento.setDescripcion(rs.getString("descripcion"));
                documento.setAdjunto(rs.getBytes("adjunto"));
                documento.setAreaDirigida(rs.getString("area_dirigida"));

                documentos.add(documento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener documentos: " + e);
        }

        return documentos;
    }
   /* public List<Documentoo> actualizarAreaDocumento(int documentoId, String nuevaArea) {
    try {
        String sql = "UPDATE documento SET area_asignada = ? WHERE documentoId = ?";
        PreparedStatement ps = getConexion().prepareStatement(sql);
        ps.setString(1, nuevaArea);
        ps.setInt(2, documentoId);
        ps.executeUpdate();

        // Después de actualizar el área, obtén la lista actualizada de documentos
        return obtenerDocumentos();
    } catch (SQLException e) {
        System.out.println("Error al actualizar el área del documento: " + e);
        // Manejar la excepción según tus necesidades
        return Collections.emptyList(); // o devuelve null o una lista vacía, dependiendo de tus necesidades
    }
    
}*/

 public void derivarDocumentoManual(int documentoId, String nuevaArea) {
        try {
            // Realiza la lógica de derivación manual en la base de datos
            // Puedes usar SQL UPDATE para cambiar el área del documento según el documentoId

            String sql = "UPDATE documento SET area_dirigida = ? WHERE documentoId = ?";
            try (PreparedStatement ps = getConexion().prepareStatement(sql)) {
                ps.setString(1, nuevaArea);
                ps.setInt(2, documentoId);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error al derivar manualmente el documento: " + e);
            // Maneja la excepción según tus necesidades
        }
    }


    
}
