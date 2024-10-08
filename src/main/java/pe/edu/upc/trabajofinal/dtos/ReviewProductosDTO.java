package pe.edu.upc.trabajofinal.dtos;

import java.time.LocalDate;

public class ReviewProductosDTO {

    private int calificacion;
    private String comentarios;
    private LocalDate fecha;


    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
