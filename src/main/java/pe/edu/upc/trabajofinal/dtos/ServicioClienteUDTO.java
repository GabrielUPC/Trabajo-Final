package pe.edu.upc.trabajofinal.dtos;

import java.time.LocalDate;

public class ServicioClienteUDTO {
    private int id;

    private String nombre;

    private LocalDate fechaservicio;

    private String descripcion;

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
}
