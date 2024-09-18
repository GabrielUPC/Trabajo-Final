package pe.edu.upc.trabajofinal.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class ReporteOfertaActivas {
    private String nombreOferta;



    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }


}
