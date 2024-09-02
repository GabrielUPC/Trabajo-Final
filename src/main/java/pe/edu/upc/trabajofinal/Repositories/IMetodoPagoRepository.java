package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajofinal.Entities.MetodoPago;

public interface IMetodoPagoRepository extends JpaRepository<MetodoPago,Integer> {
}
