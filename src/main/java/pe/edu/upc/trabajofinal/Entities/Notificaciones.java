package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;
    @Column(name="contenido",nullable = false,length = 100)
    private String contenido;
    @Column(name="fecha",nullable = false)
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario u;

    public Notificaciones() {}

    public Notificaciones(int idNotificacion, String contenido, LocalDate fecha, Usuario u) {
        this.idNotificacion = idNotificacion;
        this.contenido = contenido;
        this.fecha = fecha;
        this.u = u;
    }

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
