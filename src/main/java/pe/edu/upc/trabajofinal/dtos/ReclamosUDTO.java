package pe.edu.upc.trabajofinal.dtos;

import java.time.LocalDate;

public class ReclamosUDTO {
    private int idReclamos;
    private String contenidoReclamo;
    private LocalDate fechaReclamo;

    public int getIdReclamos() {
        return idReclamos;
    }

    public void setIdReclamos(int idReclamos) {
        this.idReclamos = idReclamos;
    }

    public String getContenidoReclamo() {
        return contenidoReclamo;
    }

    public void setContenidoReclamo(String contenidoReclamo) {
        this.contenidoReclamo = contenidoReclamo;
    }

    public LocalDate getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(LocalDate fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }
}
