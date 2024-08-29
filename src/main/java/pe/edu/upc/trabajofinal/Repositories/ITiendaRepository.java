package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Tiendas;
import pe.edu.upc.trabajofinal.Entities.Usuario;

@Repository

public interface ITiendaRepository extends JpaRepository<Tiendas, Integer> {
}
