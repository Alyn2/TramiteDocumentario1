package com.TramiteDocumentado.pe.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Dates {
    
    public String DiaActual(){
        LocalDate fechaActual = LocalDate.now();
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formato);
        return  fechaFormateada;
    }
    
    
    public String fechaVencidaDocu(){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaEn7Dias = fechaActual.plusDays(7);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaEn7Dias.format(formato);
        return fechaFormateada;
    }
    
    public int Diferencia(String fBS){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaRegistrada = LocalDate.parse(fBS, formato);
        LocalDate fechaActual = LocalDate.now();
        long difenciaenDias = ChronoUnit.DAYS.between(fechaActual, fechaRegistrada);
        return (int) difenciaenDias;
    }
    
    
}
