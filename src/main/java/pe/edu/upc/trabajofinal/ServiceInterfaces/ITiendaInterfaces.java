package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Tiendas;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.util.List;

public interface ITiendaInterfaces {
    public List<Tiendas> list();
    public void add(Tiendas tienda);
    public Tiendas listId(int id);
    public void modificar(Tiendas tienda);
    public void eliminar(int id);
    List<Tiendas> Buscar(String nombre);

}
