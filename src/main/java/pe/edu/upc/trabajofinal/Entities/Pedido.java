package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Pedido")
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
    @JoinColumn(name = "idCarritoXProducto")
    private CarritoxProducto carritoxProducto;

    public Pedido() {
    }

    public Pedido(int idPedido, LocalDate fechacPedido, LocalDate fechaEntrega, String estado, CarritoxProducto carritoxProducto) {
        this.idPedido = idPedido;
        this.fechacPedido = fechacPedido;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.carritoxProducto = carritoxProducto;
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

    public CarritoxProducto getCarritoxProducto() {
        return carritoxProducto;
    }

    public void setCarritoxProducto(CarritoxProducto carritoxProducto) {
        this.carritoxProducto = carritoxProducto;
    }
}
