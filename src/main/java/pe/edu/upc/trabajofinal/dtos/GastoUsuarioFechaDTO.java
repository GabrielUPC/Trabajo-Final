package pe.edu.upc.trabajofinal.dtos;

import java.time.LocalDate;

public class GastoUsuarioFechaDTO {
    private Double precioTotalCarrito;
    private int idUsuario;
    private LocalDate fechacPedido;

    public Double getPrecioTotalCarrito() {
        return precioTotalCarrito;
    }

    public void setPrecioTotalCarrito(Double precioTotalCarrito) {
        this.precioTotalCarrito = precioTotalCarrito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechacPedido() {
        return fechacPedido;
    }

    public void setFechacPedido(LocalDate fechacPedido) {
        this.fechacPedido = fechacPedido;
    }
}
