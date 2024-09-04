package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.MetodoPago;
@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago,Integer> {
}
