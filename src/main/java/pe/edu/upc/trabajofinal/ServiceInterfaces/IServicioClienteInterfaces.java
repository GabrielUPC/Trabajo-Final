package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.util.List;

public interface IServicioClienteInterfaces {
    public List<ServicioCliente> list();
    public void insert(ServicioCliente sc);
    public ServicioCliente listId(int id);
    public void modificar(ServicioCliente Sc);
    public void eliminar(int id);
}
