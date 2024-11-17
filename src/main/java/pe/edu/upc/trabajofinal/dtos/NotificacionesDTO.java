package pe.edu.upc.trabajofinal.dtos;

import jakarta.persistence.*;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.time.LocalDate;

public class NotificacionesDTO {

    private int idNotificacion;

    private String contenido;

    private LocalDate fecha;

    private Usuario u;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
}
