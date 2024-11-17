package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="serviciocliente")
public class ServicioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="nombre",length = 10,nullable = false)
    private String nombre;
    @Column(name ="fechaservicio",nullable = false)
    private LocalDate fechaservicio;
    @Column(name ="descripcion",length = 100,nullable = false)
    private String descripcion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario u;
    public ServicioCliente() {}

    public ServicioCliente(int id, String nombre, LocalDate fechaservicio, String descripcion, Usuario u) {
        this.id = id;
        this.nombre = nombre;
        this.fechaservicio = fechaservicio;
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
