package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    private LocalDate fecha_vencimientoProducto;
    @Column(name="stockProducto",nullable = false)
    private int stockProducto;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario u;
    @ManyToOne
    @JoinColumn(name="idTiendas")
    private Tiendas t;
    @ManyToOne
    @JoinColumn(name="idOfertas")
    private Oferta o;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<CarritoXProducto> carritos = new HashSet<>();
    public Productos() {}


    public Productos(int idProducto, String nombreProducto, String descripcionProducto, double precioProducto, String estadoProducto, LocalDate fecha_vencimientoProducto, int stockProducto, Usuario u, Tiendas t, Oferta o) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.estadoProducto = estadoProducto;
        this.fecha_vencimientoProducto = fecha_vencimientoProducto;
        this.stockProducto = stockProducto;
        this.u = u;
        this.t = t;
        this.o = o;
    }

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

    public LocalDate getFecha_vencimientoProducto() {
        return fecha_vencimientoProducto;
    }

    public void setFecha_vencimientoProducto(LocalDate fecha_vencimientoProducto) {
        this.fecha_vencimientoProducto = fecha_vencimientoProducto;
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

    public Tiendas getT() {
        return t;
    }

    public void setT(Tiendas t) {
        this.t = t;
    }

    public Oferta getO() {
        return o;
    }

    public void setO(Oferta o) {
        this.o = o;
    }
}
