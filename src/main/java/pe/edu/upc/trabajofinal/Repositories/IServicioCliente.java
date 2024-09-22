package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;
@Repository
public interface IServicioCliente extends JpaRepository<ServicioCliente, Integer> {
}
