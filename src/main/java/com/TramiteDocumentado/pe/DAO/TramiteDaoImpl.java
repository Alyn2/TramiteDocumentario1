package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Documentoo;
import com.TramiteDocumentado.pe.Model.Derivacion;
import com.TramiteDocumentado.pe.Model.Documento;
//import com.TramiteDocumentado.pe.Model.Documento;

import com.TramiteDocumentado.pe.Model.TramiteTablaUsuario;
import com.TramiteDocumentado.pe.Personaa;
import com.TramiteDocumentado.pe.Tramitee;
import com.TramiteDocumentado.pe.util.Conexion;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author JS02
 */
public class TramiteDaoImpl extends Conexion implements ITramite {
//BD NUEVA

    @Override
    public List<TramiteTablaUsuario> listTramiteUsuario(int id) {
        List<TramiteTablaUsuario> lst = new ArrayList<>();
        try {
            String sql = "SELECT trámite.fechaRecepcion, trámite.fechaTermino, trámite.Observación, "
                    + "documento.documentoId, documento.estado "
                    + "FROM `documento` "
                    + "INNER JOIN trámite ON trámite.tramiteId = documento.tramiteid "
                    + "WHERE trámite.idPersona = ?";
            try (PreparedStatement ps = getConexion().prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        TramiteTablaUsuario tu = new TramiteTablaUsuario();
                        tu.setFechaRecepcion(rs.getDate(1));
                        tu.setFechaTermino(rs.getDate(2));
                        tu.setObservacion(rs.getString(3));
                        tu.setIdDocumento(rs.getInt(4));
                        tu.setEstado(rs.getString(5));
                        lst.add(tu);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.out.println("No se hizo conexión a la base de datos");
        }
        return lst;
    }

//BD NUEVA
    @Override
    public void guardarDocumento(Documentoo doc) {
        try {
            // Obtén las fechas directamente de los objetos Date
            Date fecha = doc.getFecha();
            Date venFecha = doc.getVenFecha();

            // Asigna la fecha actual si no se proporciona una fecha específica
            LocalDate fechaLocal = (fecha != null) ? fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : LocalDate.now();

            String sql = "INSERT INTO `documento`(`Tipo`, `Estado`, `Fecha`, "
                    + "`Requisitos`, `venFecha`, `descripcion`, `adjunto`, `area_dirigida`) VALUES "
                    + "(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = getConexion().prepareStatement(sql);

            ps.setString(1, doc.getTipo());
            ps.setString(2, doc.getEstado());
            ps.setDate(3, (fecha != null) ? new java.sql.Date(fecha.getTime()) : null);
            ps.setString(4, doc.getRequisitos());
            ps.setDate(5, (venFecha != null) ? new java.sql.Date(venFecha.getTime()) : null);
            ps.setString(6, doc.getDescripcion());
            ps.setBytes(7, doc.getAdjunto());
            ps.setString(8, doc.getAreaDirigida());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error al guardar el documento: " + e);
        }
    }
//BD NUEVA
    @Override
    public void guardarTramite(Tramitee tra) {
        
            Date fechaRecepcion = tra.getFechaRecepcion();
            Date fechaTermino = tra.getFechaTermino();

            try {
                String sql = "INSERT INTO `trámite`( `fechaRecepcion`, `Observación`, `idPersona`, "
                        + "`Cantidad_dias`, `fechaTermino`, `asunto` ) VALUES (?,?"
                        + ",?,?,?,?)";
                PreparedStatement ps = getConexion().prepareStatement(sql);
                ps.setDate(1, (fechaRecepcion != null) ? new java.sql.Date(fechaRecepcion.getTime()) : null);
                ps.setString(2, tra.getObservación());
                ps.setInt(3, tra.getIdPersona());
                ps.setInt(4, tra.getCantidaddias());
                ps.setDate(5, (fechaTermino != null) ? new java.sql.Date(fechaTermino.getTime()) : null);
                ps.setString(6, tra.getAsunto());
                ps.execute();
            } catch (Exception e) {
                System.out.println("error: no se puede agregar tramite da" + e);
            }
        
    }

    @Override
    public int ultimo_tramite() {
        int ultimo = 0;
        try {
            String sql = "SELECT MAX(tramiteId) FROM `trámite`";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ultimo = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return ultimo;
    }

    @Override
    public void guardarDerivacion(Derivacion devi) {
        try {
            String sql = "INSERT INTO `derivacion`(`estado`, `documentoid`) VALUES (?,?)";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, devi.getEstado());
            ps.setInt(2, devi.getDocumento());
            ps.execute();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

    }

    @Override
    public int ultimo_documento() {
        int ultimo = 0;
        try {
            String sql = "SELECT MAX(documentoId) FROM `documento`";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ultimo = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return ultimo;
    }
//PARA LISTAR EN LA PARTE DONDE SE ACEPTA O RECHASA EL TRAMITE_DOCUMENTO
    @Override
    public List<TramiteTablaUsuario> listTramiteVerificador() {
        List<TramiteTablaUsuario> lst = new ArrayList<>();
        try {
            String sql = "SELECT\n"
                    + "    trámite.tramiteId,\n"
                    + "    trámite.fechaRecepcion,\n"
                    + "    trámite.fechaTermino,\n"
                    + "    trámite.Observación,\n"
                    + "    documento.documentoId,\n"
                    + "    documento.estado\n"
                    + "FROM\n"
                    + "    `documento`\n"
                    + "INNER JOIN trámite ON trámite.tramiteId = documento.tramiteid;";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TramiteTablaUsuario tu = new TramiteTablaUsuario();
                tu.setIdTramite(rs.getInt(1));
                tu.setFechaRecepcion(rs.getDate(2));
                tu.setFechaTermino(rs.getDate(3));
                tu.setObservacion(rs.getString(4));
                tu.setIdDocumento(rs.getInt(5));
                tu.setEstado(rs.getString(6));
                lst.add(tu);
            }

        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
        return lst;
    }

    @Override
    public void modificarvalidacion(String estado, int Documentoid) {
        try {
            String sql = "UPDATE `documento` SET `estado`= ? WHERE documentoid = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, Documentoid);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
    }

    @Override
    public int busquedaIDTramiteEnDocumento(int iddocumento) {
        int id = 0;
        try {
            String sql = "SELECT tramiteid FROM `documento` WHERE documentoId = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, iddocumento);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }

        return id;
    }

    @Override
    public String busquedaFechaInicioTramite(int iddocumento) {
        String id = "";
        try {
            String sql = "SELECT fechaRecepcion FROM `trámite` WHERE tramiteId = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, iddocumento);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }

        return id;

    }

    @Override
    public void modificarTramiteDato(String fecha, int dias, int idTramite) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate f1 = LocalDate.parse(fecha, formatter);
        try {
            String sql = "UPDATE `trámite` SET `Cantidad_dias`= ?,`fechaTermino`= ?  WHERE tramiteId = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, dias);
            ps.setDate(2, java.sql.Date.valueOf(f1));
            ps.setInt(3, idTramite);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("error : " + e);

        }
    }

    @Override
    public List<String> obtenerAreasDesdeBD() {
        List<String> nombresAreas = new ArrayList<>();

        try {
            String sql = "SELECT nombre FROM area WHERE estadoArea = 'activo'";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreArea = rs.getString("nombre");
                nombresAreas.add(nombreArea);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener nombres de áreas: " + e);
        }

        return nombresAreas;
    }

    public List<Integer> obtenerIdsPersonasDesdeBD() {
        List<Integer> idsPersonas = new ArrayList<>();

        try {
            // Aquí iría la lógica de conexión a la base de datos
            String sql = "SELECT IdPersona FROM persona";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt("IdPersona");
                idsPersonas.add(idPersona);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener IDs de personas: " + e);
        }

        return idsPersonas;
    }

    public Personaa buscarPorId(int idPersona) {
        Personaa persona = null;

        try {
            String sql = "SELECT * FROM persona WHERE idPersona = ?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, idPersona);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                persona = new Personaa();
                persona.setIdpersona(rs.getInt("idPersona"));

                // Agrega otras propiedades según la estructura de tu tabla
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar persona por ID: " + e);
        }

        return persona;
    }

    /*@Override
    public Documento getDocumentoo(int id) {
    Documentoo doc = new Documentoo();
        try {
            String sql = "SELECT * FROM `documento` WHERE documentoId =?";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doc.setDocumentoId(rs.getInt(1));
                doc.setTipo(rs.getString(2));
                doc.setEstado(rs.getString(3));
                doc.setFecha(rs.getDate(5));
                doc.setRequisitos(rs.getString(6));
               // doc.setTramiteid(rs.getInt(7));
                doc.setVenFecha(rs.getDate(8));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return getDocumentoo(id);
    }*/
    @Override
    public Documento getDocumentoo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
