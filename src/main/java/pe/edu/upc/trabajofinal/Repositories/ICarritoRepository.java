package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajofinal.Entities.Carrito;
@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Integer> {

}