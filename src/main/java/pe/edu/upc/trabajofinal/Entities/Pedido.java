package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido ;
    @Column(name ="fechacPedido",nullable = false)
    private LocalDate fechacPedido;
    @Column(name ="fechaEntrega",nullable = false)
    private LocalDate fechaEntrega;
    @Column(name ="estado",length = 20,nullable = false)
    private String estado;

    @OneToOne
    @JoinColumn(name="idCarrito")
    private Carrito c;
    @OneToOne
    @JoinColumn(name="idProducto")
    private Productos p;

    public Pedido() {
    }

    public Pedido(int idPedido, LocalDate fechacPedido, LocalDate fechaEntrega, String estado, Carrito c, Productos p) {
        this.idPedido = idPedido;
        this.fechacPedido = fechacPedido;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.c = c;
        this.p = p;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public Carrito getC() {
        return c;
    }

    public void setC(Carrito c) {
        this.c = c;
    }

    public Productos getP() {
        return p;
    }

    public void setP(Productos p) {
        this.p = p;
    }
}
