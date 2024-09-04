package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajofinal.Entities.Reclamos;

public interface IReclamosRepository extends JpaRepository<Reclamos, Integer> {
}
