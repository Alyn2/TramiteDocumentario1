package com.TramiteDocumentado.pe.DAO;

import com.TramiteDocumentado.pe.Documentoo;
import com.TramiteDocumentado.pe.Model.Derivacion;
import com.TramiteDocumentado.pe.Model.Documento;
import com.TramiteDocumentado.pe.Model.Tramite;
import com.TramiteDocumentado.pe.Model.TramiteTablaUsuario;
import com.TramiteDocumentado.pe.Tramitee;
import java.util.List;

/**
 *
 * @author JS02
 */
public interface ITramite {
    
    List<TramiteTablaUsuario> listTramiteUsuario(int id);
    
    void guardarDocumento(Documentoo doc);
    
    void guardarTramite(Tramitee tra);
    
    int ultimo_tramite();
    
    void guardarDerivacion(Derivacion devi);
    
    int ultimo_documento();
    
    Documento getDocumentoo(int id);
    
    int busquedaIDTramiteEnDocumento(int iddocumento);
    
    String busquedaFechaInicioTramite(int iddocumento);
    
    List<TramiteTablaUsuario> listTramiteVerificador();
    
    void modificarvalidacion(String validacion, int idDocumento );
    
    void modificarTramiteDato(String fecha, int dias , int idTramite);

    public List<String> obtenerAreasDesdeBD();
    
}
