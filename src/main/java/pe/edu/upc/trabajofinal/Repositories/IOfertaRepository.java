package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajofinal.Entities.Oferta;

public interface IOfertaRepository extends JpaRepository<Oferta,Integer> {
}
