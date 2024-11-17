package pe.edu.upc.trabajofinal.ServiceInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.Entities.CarritoxProducto;

import java.util.List;

public interface ICarritoInterfaces {
    public List<Carrito> list();
    public Carrito findById(int id);
    public void add(Carrito carrito);
    public void modificar(Carrito carrito);
    public void eliminar(int id);
    public List<String[]> findCarritosByUsuarioId( int usuarioId);
}
