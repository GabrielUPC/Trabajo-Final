package pe.edu.upc.trabajofinal.dtos;

import jakarta.persistence.Column;

public class CarritoDTO {

    private Integer idCarrito;

    private int cantidadCarrito;

    private Double precioTotalCarrito;

    private String estadoCarrito;

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getCantidadCarrito() {
        return cantidadCarrito;
    }

    public void setCantidadCarrito(int cantidadCarrito) {
        this.cantidadCarrito = cantidadCarrito;
    }

    public Double getPrecioTotalCarrito() {
        return precioTotalCarrito;
    }

    public void setPrecioTotalCarrito(Double precioTotalCarrito) {
        this.precioTotalCarrito = precioTotalCarrito;
    }

    public String getEstadoCarrito() {
        return estadoCarrito;
    }

    public void setEstadoCarrito(String estadoCarrito) {
        this.estadoCarrito = estadoCarrito;
    }
}

