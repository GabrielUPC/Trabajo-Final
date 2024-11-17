package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;

import java.util.List;

@Repository
public interface IServicioCliente extends JpaRepository<ServicioCliente, Integer> {
    @Query(value = "SELECT id,descripcion,fechaservicio,nombre FROM serviciocliente s WHERE s.id_usuario=:usuarioId",nativeQuery = true)
    public List<String[]> findServiciosByUsuarioId(@Param("usuarioId") int usuarioId);
}
