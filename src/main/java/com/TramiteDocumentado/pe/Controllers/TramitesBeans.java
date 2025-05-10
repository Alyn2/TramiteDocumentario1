package com.TramiteDocumentado.pe.Controllers;

import com.TramiteDocumentado.pe.DAO.DocumentoDaoImpl;
import com.TramiteDocumentado.pe.DAO.ITramite;
import com.TramiteDocumentado.pe.DAO.TramiteDaoImpl;
import com.TramiteDocumentado.pe.Documentoo;
import com.TramiteDocumentado.pe.Model.Derivacion;
import com.TramiteDocumentado.pe.Model.Documento;
import com.TramiteDocumentado.pe.Model.Tramite;
import com.TramiteDocumentado.pe.Model.TramiteTablaUsuario;
import com.TramiteDocumentado.pe.Personaa;
import com.TramiteDocumentado.pe.Tramitee;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean(name = "TramiteBeans")
@RequestScoped
public class TramitesBeans {

    //variable de derivacion
    private int idDocumentoManual;

    public int getIdDocumentoManual() {
        return idDocumentoManual;
    }

    public void setIdDocumentoManual(int idDocumentoManual) {
        this.idDocumentoManual = idDocumentoManual;
    }

    //Dates date = new Dates();
    //DAOS
    ITramite dao = new TramiteDaoImpl();
    TramiteDaoImpl dao2 = new TramiteDaoImpl();
    DocumentoDaoImpl dao3 = new DocumentoDaoImpl();

    private int idGeneral;
    private String selectedArea;
    private int selecionarIdPersona;
    private List<SelectItem> listaDeAreas;
    // Atributos tramite
    private Date fechaRecepcion;
    private String observacion;
    private int idPersona;
    private Date FechaTermino;
    private int idDocumento;
    private String asunto;
    private String tipo;
    private String requisitos;
    private int tramiteID;
    private String fechavencimiento;
    private String fechaActuarDocumento;
    private Integer cantidaddias;

    //DOCUMENTO ARTRIBUTOS
    private String estado;
    private Date fecha;

    private Date venfecha;
    private String descripcion;
    private byte[] adjunto;
    private String areaDirigida;
    private Tramitee tramiteId;

    //----------------------------------------------------------------------------
    List<TramiteTablaUsuario> listTablaUsuario;
    List<TramiteTablaUsuario> listTablaUsuario2;

    public List<TramiteTablaUsuario> getListTablaUsuario2() {
        return listTablaUsuario2;
    }

    public void setListTablaUsuario2(List<TramiteTablaUsuario> listTablaUsuario2) {
        this.listTablaUsuario2 = listTablaUsuario2;
    }

    public int getSelecionarIdPersona() {
        return selecionarIdPersona;
    }

    public void setSelecionarIdPersona(int selecionarIdPersona) {
        this.selecionarIdPersona = selecionarIdPersona;
    }

    public Tramitee getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(Tramitee tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getAreaDirigida() {
        return areaDirigida;
    }

    public void setAreaDirigida(String areaDirigida) {
        this.areaDirigida = areaDirigida;
    }

    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getVenfecha() {
        return venfecha;
    }

    public void setVenfecha(Date venfecha) {
        this.venfecha = venfecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidaddias() {
        return cantidaddias;
    }

    public void setCantidaddias(Integer cantidaddias) {
        this.cantidaddias = cantidaddias;
    }

    public TramitesBeans() {
    }

    public String getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(String selectedArea) {
        this.selectedArea = selectedArea;
    }

    public String getFechaActuarDocumento() {
        return fechaActuarDocumento;
    }

    public void setFechaActuarDocumento(String fechaActuarDocumento) {
        this.fechaActuarDocumento = fechaActuarDocumento;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public int getTramiteID() {
        return tramiteID;
    }

    public void setTramiteID(int tramiteID) {
        this.tramiteID = tramiteID;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public ITramite getDao() {
        return dao;
    }

    public void setDao(ITramite dao) {
        this.dao = dao;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaTermino() {
        return FechaTermino;
    }

    public void setFechaTermino(Date FechaTermino) {
        this.FechaTermino = FechaTermino;
    }

    public int getIdGeneral() {
        return idGeneral;
    }

    public void setIdGeneral(int idGeneral) {
        this.idGeneral = idGeneral;
    }

    public List<TramiteTablaUsuario> getListTablaUsuario() {
        return listTablaUsuario;
    }

    public void setListTablaUsuario(List<TramiteTablaUsuario> listTablaUsuario) {
        this.listTablaUsuario = listTablaUsuario;
    }
    //LOISTA DE ID
    private List<SelectItem> listaDeIdsPersonas = new ArrayList<>();

    public List<SelectItem> getListaDeIdsPersonas() {
        return listaDeIdsPersonas;
    }

    public void setListaDeIdsPersonas(List<SelectItem> listaDeIdsPersonas) {
        this.listaDeIdsPersonas = listaDeIdsPersonas;
    }
//Prueba para subir el archivo
    private UploadedFile adjuntoo;

    // Getter y Setter para adjunto
    public UploadedFile getAdjuntoo() {
        return adjuntoo;
    }

    public void setAdjuntoo(UploadedFile adjuntoo) {
        this.adjuntoo = adjuntoo;
    }

    public void derivarDocumentoManualmente() {
        try {
            if (idDocumentoManual > 0 && selectedArea != null && !selectedArea.isEmpty()) {
                // Derivar manualmente el documento usando el DAO
                dao3.derivarDocumentoManual(idDocumentoManual, selectedArea);

                // Actualizar la lista de documentos después de la derivación (opcional)
                List<Documentoo> listaDocumentoos = dao3.obtenerDocumentos();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Documento derivado correctamente."));
            } else {
                System.out.println("\"Advertencia\", \"I\\\"ngrese un ID de documento válido y seleccione un área antes de derivar.\"");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al derivar el documento manualmente."));
            e.printStackTrace(); // Maneja las excepciones según tus necesidades
        }
    }

    public List<SelectItem> getListaDeAreas() {
        // Lógica para obtener las áreas disponibles y agregarlas a la lista
        listaDeAreas = new ArrayList<>();
        List<String> areasDesdeBD = dao2.obtenerAreasDesdeBD();

        for (String area : areasDesdeBD) {
            listaDeAreas.add(new SelectItem(area, area));
        }

        return listaDeAreas;
    }

    public List<SelectItem> getListaDeIdPersonas() {
        listaDeIdsPersonas.clear();
        List<Integer> idPersonaDesdeBD = dao2.obtenerIdsPersonasDesdeBD();

        for (Integer idPersona : idPersonaDesdeBD) {
            listaDeIdsPersonas.add(new SelectItem(idPersona, String.valueOf(idPersona)));
        }

        return listaDeIdsPersonas;
    }

    public String listaTramiteUsuario() {
        listTablaUsuario = dao.listTramiteUsuario(idGeneral);
        return "/TramiteUsuario";
    }

    public String listarTramiteValidacion() {
        listTablaUsuario2 = dao.listTramiteVerificador();
        return "/TramiteVerificador";
    }
    public String listarTramiteValidacionRecursosHumanos() {
        listTablaUsuario2 = dao.listTramiteVerificador();
        return "/AreaRecursosHumanos";
    }
    public String listarTramiteValidacionContabilidad() {
        listTablaUsuario2 = dao.listTramiteVerificador();
        return "/AreaContabilidad";
    }
     public String listarTramiteValidacionAdministracion() {
        listTablaUsuario2 = dao.listTramiteVerificador();
        return "/AreaAdministracion";
    }
//MODIFICAR PARA OBTENER LA VISTA-------------------------------------------------------

    public String irNuevoTramite() {

        return "/AddTramite";
    }
//MODIFICAR CON LA NUEVA BASE DE DATOS

    public String guardarDocumento_Tramite() {

        Tramitee tra = new Tramitee();
        tra.setFechaRecepcion(fechaRecepcion);
        tra.setObservación(observacion);
        tra.setIdPersona(idPersona);
        tra.setCantidaddias(cantidaddias);
        tra.setFechaTermino(FechaTermino);
        tra.setAsunto(asunto);
        dao.guardarTramite(tra);
        //-----------------------------------------------------
        Documentoo doc = new Documentoo();
        doc.setTipo(tipo);
        doc.setEstado(estado);
        doc.setFecha(fecha);
        doc.setRequisitos(requisitos);
        doc.setVenFecha(venfecha);
        doc.setDescripcion(descripcion);
        //doc.setAdjunto(adjunto);
        doc.setAreaDirigida(areaDirigida);
        byte[] contenidoAdjunto = adjuntoo.getContent();
        doc.setAdjunto(contenidoAdjunto);
        dao.guardarDocumento(doc);
        return "/TramiteUsuario";
    }

    public void handleFileUpload(FileUploadEvent event) {
        adjuntoo = event.getFile();
    }

    public String irDocumento() {
        Documento d = dao.getDocumentoo(idGeneral);
        idDocumento = d.getIdDocumento();
        tramiteID = d.getTramiteID();
        asunto = d.getAsunto();
        tipo = d.getTipo();
        requisitos = d.getRequisitos();
        fechaActuarDocumento = d.getFechaActual();
        // FechaTermino = d.getFechavencimiento();
        return "/Documento";
    }

    public String irDocumentoValidadcion() {
        Documento d = dao.getDocumentoo(idGeneral);
        idDocumento = d.getIdDocumento();
        tramiteID = d.getTramiteID();
        asunto = d.getAsunto();
        tipo = d.getTipo();
        requisitos = d.getRequisitos();
        fechaActuarDocumento = d.getFechaActual();
        // FechaTermino = d.getFechavencimiento();
        return "/DocumentoValidacion";
    }
//NUEVA BASE DE DATOS

    public String aceptado() {
        dao.modificarvalidacion("Aprobado", idGeneral);

        listTablaUsuario2 = dao.listTramiteVerificador();
        return "/TramiteVerificador";
    }

    public String desaprobado() {
        dao.modificarvalidacion("Rechazado", idGeneral);

        listTablaUsuario2 = dao.listTramiteVerificador();
        return "/TramiteVerificador";
    }
}
