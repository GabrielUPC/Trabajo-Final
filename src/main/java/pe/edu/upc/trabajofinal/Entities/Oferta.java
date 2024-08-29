package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Oferta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idOferta;
    @Column(name="nombreOferta", nullable=false,length = 45)
    private String nombreOferta;
    @Column(name="fechaInicio", nullable=false)
    private LocalDate fechaInicio;
    @Column(name="fechaFin", nullable=false)
    private LocalDate fechaFin;
    @Column(name="CantidadProductos", nullable=false)
    private int CantidadProductos;

    public Oferta() {
    }

    public Oferta(Integer id, String nombreOferta, LocalDate fechaInicio, LocalDate fechaFin, int cantidadProductos) {
        this.idOferta = idOferta;
        this.nombreOferta = nombreOferta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        CantidadProductos = cantidadProductos;
    }

    public Integer getId() {
        return idOferta;
    }

    public void setId(Integer id) {
        this.idOferta = id;
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

    public int getCantidadProductos() {
        return CantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        CantidadProductos = cantidadProductos;
    }
}
