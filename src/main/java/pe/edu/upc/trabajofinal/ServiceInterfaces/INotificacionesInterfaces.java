package pe.edu.upc.trabajofinal.ServiceInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.dtos.NotificacionIDDTO;


import java.util.List;

public interface INotificacionesInterfaces {
    public List<Notificaciones> list();
    public void add(Notificaciones n);
    public Notificaciones listId(int id);
    public void modificar(Notificaciones n);
    public void eliminar(int id);
    public List<String[]> buscarIDUS(int user_id);
}
