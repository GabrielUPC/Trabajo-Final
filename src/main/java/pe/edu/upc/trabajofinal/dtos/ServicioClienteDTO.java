package pe.edu.upc.trabajofinal.dtos;


import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.time.LocalDate;

public class ServicioClienteDTO {

    private int id;

    private String nombre;

    private LocalDate fecha_servicio;

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

    public LocalDate getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(LocalDate fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
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
