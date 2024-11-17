package pe.edu.upc.trabajofinal.dtos;

import pe.edu.upc.trabajofinal.Entities.Oferta;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.time.LocalDate;

public class ProductosDTO {

    private int idProducto;

    private String nombreProducto;

    private String descripcionProducto;

    private double precioProducto;

    private String estadoProducto;

    private LocalDate fechavencimiento;

    private int stockProducto;

    private Usuario u;

    private Oferta o;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public LocalDate getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(LocalDate fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public Oferta getO() {
        return o;
    }

    public void setO(Oferta o) {
        this.o = o;
    }
}
