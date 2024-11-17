package pe.edu.upc.trabajofinal.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.Repositories.INotificaciones;
import pe.edu.upc.trabajofinal.ServiceInterfaces.INotificacionesInterfaces;
import pe.edu.upc.trabajofinal.dtos.NotificacionIDDTO;

import java.util.List;
@Service
public class NotificacioneImplements implements INotificacionesInterfaces {
    @Autowired
    private INotificaciones nR;


    @Override
    public List<Notificaciones> list() {
        return nR.findAll();
    }

    @Override
    public void add(Notificaciones n) {
        nR.save(n);
    }

    @Override
    public Notificaciones listId(int id) {
        return nR.findById(id).orElse(new Notificaciones());
    }

    @Override
    public void modificar(Notificaciones n) {
        nR.save(n);
    }

    @Override
    public void eliminar(int id) {
        nR.deleteById(id);
    }

    @Override
    public List<String[]> buscarIDUS(int user_id) {
        return nR.buscarIDUS(user_id);
    }
}
