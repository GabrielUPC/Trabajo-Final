package pe.edu.upc.trabajofinal.ServiceInterfaces;

import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.Entities.Usuario;

import java.util.List;

public interface INotificacionesInterfaces {
    public List<Notificaciones> list();
    public void add(Notificaciones n);
    public Notificaciones listId(int id);
    public void modificar(Notificaciones n);
    public void eliminar(int id);
}
