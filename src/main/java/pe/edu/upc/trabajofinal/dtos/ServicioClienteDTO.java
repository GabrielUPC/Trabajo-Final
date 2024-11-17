package pe.edu.upc.trabajofinal.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.time.LocalDate;

public class ServicioClienteDTO {

    private int id;

    private String nombre;

    private LocalDate fechaservicio;

    private String descripcion;

    private Usuario u;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaservicio() {
        return fechaservicio;
    }

    public void setFechaservicio(LocalDate fechaservicio) {
        this.fechaservicio = fechaservicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
}
