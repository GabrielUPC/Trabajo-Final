package pe.edu.upc.trabajofinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajofinal.Entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("SELECT p FROM Pedido p WHERE p.fechaEntrega BETWEEN :fechaInicio AND :fechaFin")
    List<Pedido> findPedidosEntreFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
}