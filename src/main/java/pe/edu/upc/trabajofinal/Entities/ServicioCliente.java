package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="ServicioCliente")
public class ServicioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="nombre",length = 10,nullable = false)
    private String nombre;
    @Column(name ="fecha_servicio",nullable = false)
    private LocalDate fecha_servicio;
    @Column(name ="descripcion",length = 100,nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario u;
    public ServicioCliente() {}

    public ServicioCliente(int id, String nombre, LocalDate fecha_servicio, String descripcion, Usuario u) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_servicio = fecha_servicio;
        this.descripcion = descripcion;
        this.u = u;
    }

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
