package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.CarritoXProducto;

import java.util.List;

public interface ICarritoXProductoInterface {
    public List<CarritoXProducto> list();
    public void add(CarritoXProducto carritoXProducto);
    public CarritoXProducto listId(int id);
    public void modificar(CarritoXProducto carritoXProducto);
    public void eliminar(int id);
}