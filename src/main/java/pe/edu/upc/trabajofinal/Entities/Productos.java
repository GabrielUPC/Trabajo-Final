package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="Productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name="nombreProducto",nullable = false,length = 20)
    private String nombreProducto;
    @Column(name="descripcionProducto",nullable = false,length = 100)
    private String descripcionProducto;
    @Column(name="precioProducto",nullable = false)
    private double precioProducto;
    @Column(name="estadoProducto",nullable = false,length = 20)
    private String estadoProducto;
    @Column(name="fecha_vencimientoProducto",nullable = false)
    private LocalDate fechavencimiento;
    @Column(name="stockProducto",nullable = false)
    private int stockProducto;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idUsuario")
    private Usuario u;
    @ManyToOne
    @JoinColumn(name="idOferta")
    private Oferta o;
    public Productos() {}

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
