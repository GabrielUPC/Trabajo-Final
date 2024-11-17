package pe.edu.upc.trabajofinal.dtos;

import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.time.LocalDate;

public class PedidoDTO {
    private int idPedido ;
    private LocalDate fechacPedido;
    private LocalDate fechaEntrega;
    private String estado;
    private CarritoxProducto carritoxProducto;


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
