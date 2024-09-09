package pe.edu.upc.trabajofinal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CarritoXProducto")
public class CarritoXProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarritoXProducto;

    @Column(name = "cantidad", nullable = false)
    private int cantidadCarrito;


    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Productos producto;


    @ManyToOne
    @JoinColumn(name = "idCarrito", nullable = false)
    private Carrito carrito;

    public CarritoXProducto() {
    }


    public int getIdCarritoXProducto() {
        return idCarritoXProducto;
    }

    public void setIdCarritoXProducto(int idCarritoXProducto) {
        this.idCarritoXProducto = idCarritoXProducto;
    }

    public int getCantidadCarrito() {
        return cantidadCarrito;
    }

    public void setCantidadCarrito(int cantidadCarrito) {
        this.cantidadCarrito = cantidadCarrito;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
