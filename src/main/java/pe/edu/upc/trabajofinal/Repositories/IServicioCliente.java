package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajofinal.Entities.ServicioCliente;

public interface IServicioCliente extends JpaRepository<ServicioCliente, Integer> {
}
