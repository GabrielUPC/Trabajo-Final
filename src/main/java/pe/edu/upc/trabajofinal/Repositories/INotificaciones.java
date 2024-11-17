package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Notificaciones;
import pe.edu.upc.trabajofinal.dtos.NotificacionIDDTO;

import java.util.List;

@Repository
public interface INotificaciones extends JpaRepository<Notificaciones,Integer> {
    @Query(value = "select id_notificacion, contenido,fecha from notificaciones n join usuario u on u.id_usuario = n.id_usuario where u.id_usuario =:id%", nativeQuery = true)
    public List<String[]> buscarIDUS(@Param("id") int id);
}
