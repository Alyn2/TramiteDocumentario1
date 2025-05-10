/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TramiteDocumentado.pe.Controllers;

import com.TramiteDocumentado.pe.DAO.DocumentoDaoImpl;
import com.TramiteDocumentado.pe.Documentoo;
import com.TramiteDocumentado.pe.Model.Documento;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "DocuemntoBens")
@RequestScoped
/**
 *
 * @author Julio López
 */
public class DocumentoBeans {
    DocumentoDaoImpl dao3 = new DocumentoDaoImpl();
    // Constructor y otros métodos
    // Método para obtener la lista de documentos desde la base de datos
    private List<Documentoo> listaDeDocumentos;
    private Documento selectedDocumento;

    // Getter y setter para listaDeDocumentos
    public List<com.TramiteDocumentado.pe.Documentoo> getListaDeDocumentos() {
        return dao3.obtenerDocumentos();
    }

    // Getter y setter para selectedDocumento
    public Documento getSelectedDocumento() {
        return selectedDocumento;
    }

    public void setSelectedDocumento(Documento selectedDocumento) {
        this.selectedDocumento = selectedDocumento;
    }
}
