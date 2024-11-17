package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Oferta")
public class
Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOferta;
    @Column(name="nombreOferta", nullable=false,length = 45)
    private String nombreOferta;
    @Column(name="fechaInicio", nullable=false)
    private LocalDate fechaInicio;
    @Column(name="fechaFin", nullable=false)
    private LocalDate fechaFin;
    @Column(name="cantidad", nullable=false)
    private int cantidad;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idUsuario")
    private Usuario u;
    public Oferta() {
    }

    public Oferta(int idOferta, String nombreOferta, LocalDate fechaInicio, LocalDate fechaFin, int cantidad, Usuario u) {
        this.idOferta = idOferta;
        this.nombreOferta = nombreOferta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.u = u;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
}
