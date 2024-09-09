package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;
import pe.edu.upc.trabajofinal.dtos.PedidoDTO;

import java.time.LocalDate;

@Entity
@Table(name="Reclamos")
public class Reclamos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReclamos;

    @Column(name="contenidoReclamo",nullable = false,length = 100)
    private String contenidoReclamo;

    @Column(name="fechaReclamo",nullable = false)
    private LocalDate fechaReclamo;

    @ManyToOne
    @JoinColumn(name="id")
    private Pedido p;

    public Reclamos() {
    }

    public Reclamos(int idReclamos, String contenidoReclamo, LocalDate fechaReclamo, Pedido p) {
        this.idReclamos = idReclamos;
        this.contenidoReclamo = contenidoReclamo;
        this.fechaReclamo = fechaReclamo;
        this.p = p;
    }

    public int getIdReclamos() {
        return idReclamos;
    }

    public void setIdReclamos(int idReclamos) {
        this.idReclamos = idReclamos;
    }

    public String getContenidoReclamo() {
        return contenidoReclamo;
    }

    public void setContenidoReclamo(String contenidoReclamo) {
        this.contenidoReclamo = contenidoReclamo;
    }

    public LocalDate getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(LocalDate fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }

    public Pedido getP() {
        return p;
    }

    public void setP(Pedido p) {
        this.p = p;
    }
}
