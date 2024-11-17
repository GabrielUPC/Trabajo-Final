package pe.edu.upc.trabajofinal.dtos;

import java.time.LocalDate;

public class PedidosUDTO {
    private int idPedido ;
    private String estado;
    private LocalDate fechacPedido;
    private LocalDate fechaEntrega;


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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


}
