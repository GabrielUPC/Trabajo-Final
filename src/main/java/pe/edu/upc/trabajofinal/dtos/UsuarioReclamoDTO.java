package pe.edu.upc.trabajofinal.dtos;

import java.time.LocalDate;

public class UsuarioReclamoDTO {
    private String nombreUsuario;
    private String ContenidoReclamo;
    private LocalDate fechaReclamo;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContenidoReclamo() {
        return ContenidoReclamo;
    }

    public void setContenidoReclamo(String contenidoReclamo) {
        ContenidoReclamo = contenidoReclamo;
    }

    public LocalDate getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(LocalDate fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }
}
