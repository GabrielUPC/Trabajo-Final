package pe.edu.upc.trabajofinal.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class PedidoDTO {
    private int id;
    private LocalDate fechacPedido;
    private LocalDate fechaEntrega;
    private String estado;
    private String reciboCompra;

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

    public String getReciboCompra() {
        return reciboCompra;
    }

    public void setReciboCompra(String reciboCompra) {
        this.reciboCompra = reciboCompra;
    }
}
