package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Productos;

import java.util.List;

public interface ProductosInterfaces {
    public List<Productos> list();
    public void add(Productos producto);
    public void eliminar(int id);
    public void modificar(Productos producto);
    public Productos listid(int id);
    List<String[]> ProductoVencidos();
    List<String[]> ObtenerResenasProducto(String nombreProducto);
    List<String[]> GananciaTotalPorTienda();
    List<String[]> TotalStockProductos();

}
