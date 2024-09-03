package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajofinal.Entities.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
}
