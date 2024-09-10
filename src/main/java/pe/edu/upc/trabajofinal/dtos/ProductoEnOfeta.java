package pe.edu.upc.trabajofinal.dtos;

import java.time.LocalDate;

public class ProductoEnOfeta {
    private String producto;
    private String nombreOfeta;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int cantidadProducto;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNombreOfeta() {
        return nombreOfeta;
    }

    public void setNombreOfeta(String nombreOfeta) {
        this.nombreOfeta = nombreOfeta;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
}
