package pe.edu.upc.trabajofinal.dtos;

import pe.edu.upc.trabajofinal.Entities.Productos;

public class MontoTotalDTO {
    private int cantidad;
    private double precio;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
