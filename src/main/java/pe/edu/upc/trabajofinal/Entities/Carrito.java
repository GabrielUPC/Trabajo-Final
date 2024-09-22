package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="Carrito")
public class Carrito {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idCarrito;

    @Column(name="cantidadCarrito", nullable=false)
    private int cantidadCarrito;

    @Column(name="precioTotalCarrito", nullable=false)
    private Double precioTotalCarrito;

    @Column(name="estadoCarrito", nullable=false, length=30)
    private String estadoCarrito;

    public Carrito() {
    }

    public Carrito(Integer idCarrito, int cantidadCarrito, Double precioTotalCarrito, String estadoCarrito) {
        this.idCarrito = idCarrito;
        this.cantidadCarrito = cantidadCarrito;
        this.precioTotalCarrito = precioTotalCarrito;
        this.estadoCarrito = estadoCarrito;
    }

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
