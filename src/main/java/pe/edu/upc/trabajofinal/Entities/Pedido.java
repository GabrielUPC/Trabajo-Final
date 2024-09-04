package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="fechacPedido",nullable = false)
    private LocalDate fechacPedido;
    @Column(name ="fechaEntrega",nullable = false)
    private LocalDate fechaEntrega;
    @Column(name ="estado",length = 20,nullable = false)
    private String estado;

    public Pedido() {
    }

    public Pedido(int id, LocalDate fechacPedido, LocalDate fechaEntrega, String estado) {
        this.id = id;
        this.fechacPedido = fechacPedido;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechacPedido() {
        return fechacPedido;
    }

    public void setFechacPedido(LocalDate fechacPedido) {
        this.fechacPedido = fechacPedido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
