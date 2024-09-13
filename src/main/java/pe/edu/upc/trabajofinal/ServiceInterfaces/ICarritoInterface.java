package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Carrito;
import pe.edu.upc.trabajofinal.Entities.Oferta;

import java.util.List;

public interface ICarritoInterface { public List<Carrito> list();
    public void add(Carrito carrito);
    public Carrito listId(int id);
    public void modificar(Carrito carrito);
    public void eliminar(int id);
    public List<String[]> gastototalusuariopormesService();
}
