package pe.edu.upc.trabajofinal.dtos;
import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.Entities.Productos;
import pe.edu.upc.trabajofinal.Entities.Usuario;

public class CarritoxProductoDTO {

    private int idCarritoXProducto;
    private int cantidadCarrito;
    private Productos producto;
    private Carrito carrito;


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
