package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;

import java.util.List;

public interface ICarritoxProductoInterfaces {
    public List<CarritoxProducto> list();
    public CarritoxProducto findById(int id);
    public void add(CarritoxProducto producto);
    public void modificar(CarritoxProducto producto);
    public void eliminar(int id);
}
